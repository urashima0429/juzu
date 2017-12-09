package me.utteiku.ryugu.juzu.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

import me.utteiku.ryugu.juzu.Gender;

/**
 * Created by ryugu on 2017/08/20.
 */

//todo how to manage passward ?
public class User {

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("age")
    private int age;

    @SerializedName("gender")
    private Gender gender;

    @SerializedName("point")
    private int point;

    @SerializedName("introduction")
    private String introduction;

    @SerializedName("address")
    private String address;

    public User(int id, String name, int age, Gender gender, int point, String introduction, String address){
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.point = point;
        this.introduction = introduction;
        this.address = address;
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public int getPoint() {
        return point;
    }
    public Gender getGender() {
        return gender;
    }
    public String getIntroduction() {
        return introduction;
    }
    public String getAddress(){
        return address;
    }
}
