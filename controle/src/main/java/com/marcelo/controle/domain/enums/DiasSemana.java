package com.marcelo.controle.domain.enums;

public enum DiasSemana {

    DOMINGO(1, "Domingo"),
    SEGUNDA(2, "Segunda"),
    TERCA(3, "Terça-feira"),
    QUARTA(4, "Quarta-feira"),
    QUINTA(5, "Quinta-feira"),
    SEXTA(6, "Sexta-feira"),
    SABADO(7, "Sábado");

    private int cod;
    private String descricao;

    private DiasSemana(int cod, String descricao){

        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static DiasSemana toEnum(Integer cod){

        if(cod == null){
            return null;
        }
        for (DiasSemana x : DiasSemana.values()){
            if (cod.equals(x.getCod())){
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido:" + cod);
    }

}
