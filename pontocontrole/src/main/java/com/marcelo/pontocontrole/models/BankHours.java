package com.marcelo.pontocontrole.models;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;

@Entity
@Table(name= "TB_BANCOHORAS")
public class BankHours implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Time timeEntry;
    private Time timeExit;
    private String date;
    private Time timeDay;
    private Time TimeMonth;

    public Time getTimeDay() {
        return timeDay;
    }

    public void setTimeDay(Time timeDay) {
        this.timeDay = timeDay;
    }

    public Time getTimeMonth() {
        return TimeMonth;
    }

    public void setTimeMonth(Time timeMonth) {
        TimeMonth = timeMonth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getTimeEntry() {
        return timeEntry;
    }

    public void setTimeEntry(Time timeEntry) {
        this.timeEntry = timeEntry;
    }

    public Time getTimeExit() {
        return timeExit;
    }

    public void setTimeExit(Time timeExit) {
        this.timeExit = timeExit;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

   
}
