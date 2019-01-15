package com.marcelo.controle.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class UserNewDTO {

    private String name;
    private String departament;
    private String roles;


    private Integer recordId;
    private Integer dayOfWeek;
    private LocalTime times;
    private LocalDate date = LocalDate.now();

    private Integer idTimeBank;
    private String status;

    public UserNewDTO(){

    }


    public Integer getIdTimeBank() {
        return idTimeBank;
    }

    public void setIdTimeBank(Integer idTimeBank) {
        this.idTimeBank = idTimeBank;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
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
}
