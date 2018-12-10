package com.marcelo.pontocontrole.models;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;

@Entity
@Table(name= "TB_REGISTROS")
public class Record implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String employeerName;
    private Time timeEntry;
    private Time timeExit;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployeerName() {
        return employeerName;
    }

    public void setEmployeerName(String employeerName) {
        this.employeerName = employeerName;
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
}
