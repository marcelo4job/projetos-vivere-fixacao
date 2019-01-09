package com.marcelo.controle.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class HoraBancoNewDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private LocalDate dia = LocalDate.now();
    private LocalTime hora;
    private LocalDate date = LocalDate.now();

    private Integer matricula;
    private String nome;
    private String setor;
    private String cargo;

    HoraBancoNewDTO(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
