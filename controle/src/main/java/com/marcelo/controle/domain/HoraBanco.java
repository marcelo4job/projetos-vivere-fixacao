package com.marcelo.controle.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.Objects;

@Entity
public class HoraBanco implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalTime hora;
    private String dia;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "funcionario_id ")
    private  Funcionario funcionario;

    //Construtores
    public HoraBanco(){

    }

    public HoraBanco(LocalTime hora, String dia) {
        this.hora = hora;
        this.dia = dia;
    }

    //Get&Set's

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HoraBanco horaBanco = (HoraBanco) o;
        return Objects.equals(id, horaBanco.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
