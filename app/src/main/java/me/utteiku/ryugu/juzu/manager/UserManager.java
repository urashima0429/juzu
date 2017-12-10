package me.utteiku.ryugu.juzu.manager;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Calendar;

import me.utteiku.ryugu.juzu.Constants;
import me.utteiku.ryugu.juzu.Gender;
import me.utteiku.ryugu.juzu.utility.AESCipher;

/**
 * Created by ryugu on 2017/12/10.
 */

//todo user登録ダイアログ
public class UserManager {

    private enum StoreKeys {
        Registered("AuthRegistered"),
        UserId("AuthUserId"),
        UserName("AuthUserName"),
        Password("AuthPassword"),
        AuthToken("AuthToken"),
        LastUserSettingDialogShown("LastUserSettingDialogShown"),
        UserInfoLastUpdate("UserInfoLastUpdate");

        private final String text;
        private StoreKeys(final String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return this.text;
        }
    }

    private static final UserManager userManager = new UserManager();
    private SharedPreferences pref;
    private Boolean registered;
    private Integer userId;
    private String username;
    private String password;
    private String authToken;
    private boolean firstNeedsUserInfoUpdateCheck = true;

public static UserManager getInstance() {
        return userManager;
    }

    public void setContext(Context context) {
        pref = context.getSharedPreferences(Constants.GENERAL_PREF_FILE_NAME, Context.MODE_PRIVATE);
    }

    public boolean isRegistered() {
        if (registered == null) {
            registered = pref.getBoolean(StoreKeys.Registered.toString(), false);
        }
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(StoreKeys.Registered.toString(), registered);
        editor.commit();
    }

    public void setUserId(int userId) {
        this.userId = userId;
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(StoreKeys.UserId.toString(), userId);
        editor.commit();
    }

    public String getUsername() {
        if (username == null) {
            String encrypted = pref.getString(StoreKeys.UserName.toString(), "");
            username = AESCipher.decrypt(encrypted);
        }
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        SharedPreferences.Editor editor = pref.edit();
        String encrypted = AESCipher.encrypt(username);
        editor.putString(StoreKeys.UserName.toString(), encrypted);
        editor.commit();
    }

    public String getPassword() {
        if (password == null) {
            String encrypted = pref.getString(StoreKeys.Password.toString(), "");
            password = AESCipher.decrypt(encrypted);
        }
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        SharedPreferences.Editor editor = pref.edit();
        String encrypted = AESCipher.encrypt(password);
        editor.putString(StoreKeys.Password.toString(), encrypted);
        editor.commit();
    }

    public String getAuthToken() {
        if (authToken == null) {
            authToken = pref.getString(StoreKeys.AuthToken.toString(), "");
        }
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(StoreKeys.AuthToken.toString(), authToken);
        editor.commit();
    }

    public long getUserInfoLastUpdate() {
        return pref.getLong(StoreKeys.UserInfoLastUpdate.toString(), 0);
    }

    public void setUserInfoLastUpdate(long timemills) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putLong(StoreKeys.UserInfoLastUpdate.toString(), timemills);
        editor.commit();
    }

    private long getLastUserSettingDialogShown() {
        return pref.getLong(StoreKeys.LastUserSettingDialogShown.toString(), 0);
    }

    public void setLastUserSettingDialogShown(long timemills) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putLong(StoreKeys.LastUserSettingDialogShown.toString(), timemills);
        editor.commit();
    }

    public boolean shouldShowUserSettingDialog() {
        return ((Calendar.getInstance().getTimeInMillis() - getLastUserSettingDialogShown()) > Constants.USER_SETTING_DIALOG_TIME_INTERVAL);
    }

}
