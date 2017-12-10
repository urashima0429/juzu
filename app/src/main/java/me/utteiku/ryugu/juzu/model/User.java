package me.utteiku.ryugu.juzu.model;

import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

import me.utteiku.ryugu.juzu.Gender;

/**
 * Created by ryugu on 2017/08/20.
 */

public class User implements Person, Serializable {

    public int id;
    public String name;
    public int age;
    public Gender gender;
    public String occupation;
    public int point;
    public String introduction;
    public String address;

    public User(){
        this.id = 0;
        this.name = null;
        this.age = 0;
        this.gender = Gender.other;
        this.occupation = null;
        this.point = 0;
        this.introduction = null;
        this.address = null;
    }

    public User(int id, String name, int age, Gender gender, String occupation, int point, String introduction, String address){
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.occupation = occupation;
        this.point = point;
        this.introduction = introduction;
        this.address = address;
    }
}
