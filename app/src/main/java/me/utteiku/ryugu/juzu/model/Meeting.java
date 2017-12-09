package me.utteiku.ryugu.juzu.model;

import java.util.Date;

/**
 * Created by ryugu on 2017/12/09.
 */

public class Meeting {
    public Date date;
    public String place;
    public int evaluation;
    public int cost;
    //public Payment payment;
    //public Opportunity opportunity;
    public String clothing;
    public String other;

    public Meeting(){
        this.date = null;
        this.place = null;
        this.cost = 0;
        this.evaluation = 0;
        // this.payment = null;
        // this.opportunity = null;
        this.clothing = null;
        this.other = null;
    }

    public Meeting(Date date, String place, int cost, int evaluation, String clothing, String other){
        this.date = date;
        this.place = place;
        this.cost = cost;
        this.evaluation = evaluation;
        // this.payment = null;
        // this.opportunity = null;
        this.clothing = clothing;
        this.other = other;
    }
}
