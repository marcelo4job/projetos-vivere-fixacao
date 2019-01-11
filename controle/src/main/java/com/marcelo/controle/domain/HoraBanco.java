package com.marcelo.controle.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.marcelo.controle.domain.enums.DiasSemana;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
public class HoraBanco implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Dia")
    private Integer dia;

    @Column(name = "Hora")
    private LocalTime hora;

    @Column(name = "Data")
    private LocalDate date = LocalDate.now();

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "funcionario_id ")
    private  Funcionario funcionario;

    //Construtores

    public  HoraBanco(){

        }
    public HoraBanco(Integer id, DiasSemana dia, LocalTime hora, LocalDate date, Integer funcionarioMat){

    }

    public HoraBanco(Integer id, DiasSemana dia, LocalTime hora, LocalDate date, Funcionario funcionario) {
        this.id = id;
        this.dia = (dia == null) ? null : dia.getCod();
        this.hora = hora;
        this.date = date;
        this.funcionario = funcionario;


    }

    //Get&Set's


    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
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

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public DiasSemana getDia() {
        return DiasSemana.toEnum(dia);
    }

    public void setDia(DiasSemana dia) {
        this.dia = dia.getCod();
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
