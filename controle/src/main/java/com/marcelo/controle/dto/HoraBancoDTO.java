package com.marcelo.controle.dto;

import com.marcelo.controle.domain.Funcionario;
import com.marcelo.controle.domain.HoraBanco;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class HoraBancoDTO  implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String dia;
    private LocalTime hora;
    private LocalDate date;
    private Funcionario funcionario;

    public HoraBancoDTO(){

    }

    public HoraBancoDTO(HoraBanco obj){

        dia = obj.getDia();
        hora = obj.getHora();
        date = obj.getDate();
        funcionario = obj.getFuncionario();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
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

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
