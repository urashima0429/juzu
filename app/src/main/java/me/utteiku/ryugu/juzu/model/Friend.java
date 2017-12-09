package me.utteiku.ryugu.juzu.model;

import java.io.Serializable;

import me.utteiku.ryugu.juzu.Gender;

/**
 * Created by ryugu on 2017/08/20.
 */

public class Friend implements Serializable{

    public int id;
    public String name;
    public int age;
    public Gender gender;
    public String introduction;
    public String address;

    public Friend(){
        this.id = 0;
        this.name = null;
        this.age = 0;
        this.gender = Gender.other;
        this.introduction = null;
        this.address = null;
    }

    public Friend(int id, String name, int age, Gender gender, String introduction, String address){
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.introduction = introduction;
        this.address = address;
    }
}
