package com.marcelo.controle.dto;

import com.marcelo.controle.domain.Record;
import com.marcelo.controle.domain.User;
import com.marcelo.controle.domain.TimeBank;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class RecordDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private LocalTime times;
    private LocalDate date;
    private User user;
    private TimeBank timeBank;


    public RecordDTO(){

    }

    public RecordDTO(Record obj){

        id = obj.getId();
        times = obj.getTimes();
        date = obj.getDate();
        user = obj.getUser();
        timeBank = obj.getTimeBank();

    }

    public TimeBank getTimeBank() {
        return timeBank;
    }

    public void setTimeBank(TimeBank timeBank) {
        this.timeBank = timeBank;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public LocalTime getTimes() {
        return times;
    }

    public void setTimes(LocalTime times) {
        this.times = times;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
