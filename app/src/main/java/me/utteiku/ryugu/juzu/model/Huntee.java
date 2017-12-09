package me.utteiku.ryugu.juzu.model;

import java.io.Serializable;

import me.utteiku.ryugu.juzu.Gender;

/**
 * Created by ryugu on 2017/12/09.
 */

public class Huntee implements Person, Serializable{

    public int id;
    public String name;
    public int age;
    public Gender gender;
    public String occupation;
    public int firstImpression;

    public Huntee(){
        id = 0;
        name = null;
        age = 0;
        gender = Gender.other;
        occupation = null;
        firstImpression = 0;
    }

    public Huntee(int id, String name, int age, Gender gender, String occupation, int firstImpression){
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = Gender.other;
        this.occupation = occupation;
        this.firstImpression = firstImpression;
    }

}
