package com.marcelo.controle.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   //@Column(name ="id_funcionario")
    private Integer matricula;
    private String nome;
    private String setor;
    private String cargo;

    @OneToMany(mappedBy = "funcionario")
    private List<HoraBanco> registro = new ArrayList<>();

    //Construtores
    public Funcionario(){

    }

    public Funcionario(Integer matricula, String nome, String setor, String cargo) {
        this.matricula = matricula;
        this.nome = nome;
        this.setor = setor;
        this.cargo = cargo;
    }
    //Gett&Set's


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

  public List<HoraBanco> getRegistro() {
        return registro;
    }

    public void setRegistro(List<HoraBanco> registro) {
        this.registro = registro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return Objects.equals(matricula, that.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }
}
