package com.marcelo.controle.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class HoraBancoNewDTO implements Serializable {
    private static final long serialVersionUID = 1L;


    private Integer dia;
    private LocalTime hora;
    private LocalDate date = LocalDate.now();


    private Integer funcionarioMat;
    private String nome;
    private String setor;
    private String cargo;

    public HoraBancoNewDTO() {
    }



    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
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


    public Integer getFuncionarioMat() {
        return funcionarioMat;
    }

    public void setFuncionarioMat(Integer funcionarioMat) {
        this.funcionarioMat = funcionarioMat;
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
