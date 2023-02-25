package com.example.grupalpokemon.Modelos;

import java.io.Serializable;

public class EquipoModelo implements Serializable {

    private Pokemon pokemon1, pokemon2, pokemon3, pokemon4,pokemon5,pokemon6;
    private Usuario user;
    private String ataques1, ataques2, ataques3, ataques4, ataques5, ataques6;
    private String naturaleza1, naturaleza2, naturaleza3,naturaleza4, naturaleza5, naturaleza6;
    private String habilidad1, habilidad2, habilidad3, habilidad4, habilidad5, habilidad6;

    public EquipoModelo(Usuario user, Pokemon pokemon1, String ataques1, String habilidad1, String naturaleza1,
                        Pokemon pokemon2, String ataques2, String habilidad2, String naturaleza2,
                        Pokemon pokemon3, String ataques3, String habilidad3, String naturaleza3,
                        Pokemon pokemon4, String ataques4, String habilidad4, String naturaleza4,
                        Pokemon pokemon5, String ataques5, String habilidad5, String naturaleza5,
                        Pokemon pokemon6, String ataques6, String habilidad6, String naturaleza6) {

        this.user = user;
        this.pokemon1 = pokemon1;
        this.ataques1 = ataques1;
        this.habilidad1 = habilidad1;
        this.naturaleza1 = naturaleza1;
        this.pokemon2 = pokemon2;
        this.ataques2 = ataques2;
        this.habilidad2 = habilidad2;
        this.naturaleza2 = naturaleza2;
        this.pokemon3 = pokemon3;
        this.ataques3 = ataques3;
        this.habilidad3 = habilidad3;
        this.naturaleza3 = naturaleza3;
        this.pokemon4 = pokemon4;
        this.ataques4 = ataques4;
        this.habilidad4 = habilidad4;
        this.naturaleza4 = naturaleza4;
        this.pokemon5 = pokemon5;
        this.ataques5 = ataques5;
        this.habilidad5 = habilidad5;
        this.naturaleza5 = naturaleza5;
        this.pokemon6 = pokemon6;
        this.ataques6 = ataques6;
        this.habilidad6 = habilidad6;
        this.naturaleza6 = naturaleza6;
    }

    public Usuario getUser() {
        return user;
    }

    public Pokemon getPokemon1() {
        return pokemon1;
    }

    public Pokemon getPokemon2() {
        return pokemon2;
    }

    public Pokemon getPokemon3() {
        return pokemon3;
    }

    public Pokemon getPokemon4() {
        return pokemon4;
    }

    public Pokemon getPokemon5() {
        return pokemon5;
    }

    public Pokemon getPokemon6() {
        return pokemon6;
    }
}

