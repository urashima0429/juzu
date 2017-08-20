package me.utteiku.ryugu.juzu.model;

import android.content.Intent;

import me.utteiku.ryugu.juzu.Gender;

/**
 * Created by ryugu on 2017/08/20.
 */

public class Person {

    private int id;
    private String name;
    private int age;
    private Gender gender;
    private String introduction;
    private String address;

    public Person(int id, String name, int age, Gender gender, String introduction, String address){
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
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
