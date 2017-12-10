package me.utteiku.ryugu.juzu.utility;

import android.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by ryugu on 2017/12/10.
 */

public class AESCipher {

    //// TODO: 2017/12/10 edit key
    private static final String ENCODING = "UTF-8";
    private static final String SECRET_KEY = "cho$93mJbW%ir#6w";
    private static final String SECRET_IV = "xOu7f%Y#QCY74mmi";

    public static String encrypt(String text) {
        if (text.isEmpty()) return text;
        try {
            byte[] target = text.getBytes(ENCODING);

            // generate encryption key
            byte[] keySrc = SECRET_KEY.getBytes(ENCODING);
            SecretKeySpec key = new SecretKeySpec(keySrc, "AES");

            // generate initialization vector
            byte[] ivSrc = SECRET_IV.getBytes(ENCODING);
            IvParameterSpec iv = new IvParameterSpec(ivSrc);

            // encrypt with AES (CBC)
            Cipher encrypt = Cipher.getInstance("AES/CBC/PKCS5Padding");
            encrypt.init(Cipher.ENCRYPT_MODE, key, iv);
            byte[] encrypted = encrypt.doFinal(target);
            // Convert byte to Base64
            return Base64.encodeToString(encrypted, Base64.DEFAULT);
        } catch (Exception e) {
            throw new RuntimeException("[encrypt] error");
        }
    }

    public static String decrypt(String text) {
        if (text.isEmpty()) return text;
        try {
            // Convert Base64 to byte
            byte[] target = Base64.decode(text, Base64.DEFAULT);

            // generate encryption key
            byte[] keySrc = SECRET_KEY.getBytes(ENCODING);
            SecretKeySpec key = new SecretKeySpec(keySrc, "AES");

            // generate initialization vector
            byte[] ivSrc = SECRET_IV.getBytes(ENCODING);
            IvParameterSpec iv = new IvParameterSpec(ivSrc);

            // decrypt with AES (CBC)
            Cipher decrypt = Cipher.getInstance("AES/CBC/PKCS5Padding");
            decrypt.init(Cipher.DECRYPT_MODE, key, iv);
            byte[] decrypted = decrypt.doFinal(target);
            // Convert byte to String
            return new String(decrypted, ENCODING);
        } catch (Exception e) {
            throw new RuntimeException("[decrypt] error");
        }
    }
}
