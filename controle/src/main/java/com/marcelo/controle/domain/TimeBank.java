package com.marcelo.controle.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class TimeBank implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String status;


    @JsonIgnore
    @OneToMany(mappedBy = "timeBank")
    private List<Record> timesBank = new ArrayList<>();


    public TimeBank() {

    }

    public TimeBank(Integer id, String status){
        this.id = id;
        this.status = status;
    }


    public List<Record> getTimesBank() {
        return timesBank;
    }

    public void setTimesBank(List<Record> timesBank) {
        this.timesBank = timesBank;
    }

    public TimeBank(String status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeBank timeBank = (TimeBank) o;
        return Objects.equals(id, timeBank.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
