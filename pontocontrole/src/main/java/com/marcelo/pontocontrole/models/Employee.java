package com.marcelo.pontocontrole.models;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;

@Entity
@Table(name = "TB_FUNCIONARIO")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String office;
    private String sector;
    private String registration;
    private Time timeDay;

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

    private Time TimeMonth;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }
}
