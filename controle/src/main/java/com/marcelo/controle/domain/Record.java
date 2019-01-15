package com.marcelo.controle.domain;

import com.marcelo.controle.domain.enums.DiasSemana;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
public class Record implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Dia")
    private Integer dayOfWeek;

    @Column(name = "Hora")
    private LocalTime times;

    @Column(name = "Data")
    private LocalDate date = LocalDate.now();


    @ManyToOne
    @JoinColumn(name = "user_id ")
    private User user;

    @ManyToOne
    @JoinColumn(name = "Bank_id")
    private TimeBank timeBank;

    //Construtores

    public Record(){

        }
    public Record(Integer id, DiasSemana dia, LocalTime hora, LocalDate date, Integer funcionarioMat, Integer idTimeBank ){

    }

    public Record(Integer id, DiasSemana dia, LocalTime hora, LocalDate date, User funcionario, TimeBank timeBank) {
        this.id = id;
        this.dayOfWeek = (dia == null) ? null : dia.getCod();
        this.times = hora;
        this.date = date;
        this.user = funcionario;
        this.timeBank = timeBank;


    }

    //Get&Set's


    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public TimeBank getTimeBank() {
        return timeBank;
    }

    public void setTimeBank(TimeBank timeBank) {
        this.timeBank = timeBank;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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

    public DiasSemana getDayOfWeek() {
        return DiasSemana.toEnum(dayOfWeek);
    }

    public void setDia(DiasSemana dia) {
        this.dayOfWeek = dia.getCod();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record horaBanco = (Record) o;
        return Objects.equals(id, horaBanco.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
