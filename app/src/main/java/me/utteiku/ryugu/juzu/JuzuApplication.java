package me.utteiku.ryugu.juzu;

import android.app.Application;

import me.utteiku.ryugu.juzu.manager.UserManager;

/**
 * Created by ryugu on 2017/12/10.
 *
 * Manage shared data etc within Application
 * todo google analytics
 */


public class JuzuApplication extends Application {

    public JuzuApplication() {
        super();
    }

    public void onCreate(){
        super.onCreate();

        UserManager.getInstance().setContext(this);
    }


}
