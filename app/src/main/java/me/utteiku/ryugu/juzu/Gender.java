package me.utteiku.ryugu.juzu;

/**
 * Created by ryugu on 2017/08/21.
 */

public enum Gender {
    male(0, "male"),
    female(1,"female"),
    other(2,"other");

    /* Enum定義 */
    private final int key;
    private final String value;

    Gender(final int key, final String value) {
        this.key = key;
        this.value = value;
    }
    public int getKey() { return key; }
    public String getValue() { return value; }
}

