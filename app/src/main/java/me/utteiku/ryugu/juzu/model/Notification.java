package me.utteiku.ryugu.juzu.model;

/**
 * Created by ryugu on 2017/08/23.
 */

public class Notification {

    private int id;
    private int content;

    public Notification(int id, int content){
        this.id = id;
        this.content = content;
    }

    public int getId() {
        return id;
    }
    public int getContent() {
        return content;
    }
}
