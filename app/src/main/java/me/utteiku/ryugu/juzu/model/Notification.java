package me.utteiku.ryugu.juzu.model;

import java.io.Serializable;

/**
 * Created by ryugu on 2017/08/23.
 */

public class Notification implements Serializable {

    public int id;
    public String text;

    public Notification(){
        this.id = 0;
        this.text = null;
    }

    public Notification(int id, String text){
        this.id = id;
        this.text = text;
    }
}
