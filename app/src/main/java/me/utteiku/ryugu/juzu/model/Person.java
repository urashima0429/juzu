package me.utteiku.ryugu.juzu.model;

import me.utteiku.ryugu.juzu.Gender;

/**
 * Created by ryugu on 2017/12/09.
 */

interface Person {
    int id = 0;
    String name = null;
    int age = 0;
    Gender gender = Gender.other;
    String occupation = null;
}
