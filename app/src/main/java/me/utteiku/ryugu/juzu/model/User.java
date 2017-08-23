package me.utteiku.ryugu.juzu.model;

import me.utteiku.ryugu.juzu.Gender;

/**
 * Created by ryugu on 2017/08/20.
 */

//todo how to manage passward ?
public class User {

    private int id;
    private String name;
    private int age;
    private Gender gender;
    private int point;
    private boolean isPlayer;
    private String introduction;
    private String address;

    public User(int id, String name, int age, Gender gender, int point,boolean isPlayer, String introduction, String address){
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.point = point;
        this.isPlayer = isPlayer;
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
    public boolean isPlayer() {
        return isPlayer;
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
