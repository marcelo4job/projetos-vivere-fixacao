package com.marcelo.controle.dto;

import com.marcelo.controle.domain.Funcionario;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class FuncionarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer matricula;
    @NotEmpty(message = "Preenchimento Obrigatório")
    @Length(min = 5, max = 80, message = "O tamnho deve ser entre 5 e 80 caracteres!")
    private String nome;
    private String setor;
    private String cargo;

    public FuncionarioDTO(){

    }

    public FuncionarioDTO(Funcionario obj){

        matricula = obj.getMatricula();
        nome = obj.getNome();
        setor = obj.getSetor();
        cargo = obj.getCargo();
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
