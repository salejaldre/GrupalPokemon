package com.example.grupalpokemon.Modelos;

import java.io.Serializable;

public class EquipoModelo implements Serializable {

    private Pokemon pokemon1, pokemon2, pokemon3, pokemon4,pokemon5,pokemon6;

    public EquipoModelo(Pokemon pokemon1, Pokemon pokemon2, Pokemon pokemon3, Pokemon pokemon4, Pokemon pokemon5, Pokemon pokemon6) {
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
        this.pokemon3 = pokemon3;
        this.pokemon4 = pokemon4;
        this.pokemon5 = pokemon5;
        this.pokemon6 = pokemon6;
    }

    public EquipoModelo() {
    }


    public Pokemon getPokemon1() {
        return pokemon1;
    }

    public void setPokemon1(Pokemon pokemon1) {
        this.pokemon1 = pokemon1;
    }

    public Pokemon getPokemon2() {
        return pokemon2;
    }

    public void setPokemon2(Pokemon pokemon2) {
        this.pokemon2 = pokemon2;
    }

    public Pokemon getPokemon3() {
        return pokemon3;
    }

    public void setPokemon3(Pokemon pokemon3) {
        this.pokemon3 = pokemon3;
    }

    public Pokemon getPokemon4() {
        return pokemon4;
    }

    public void setPokemon4(Pokemon pokemon4) {
        this.pokemon4 = pokemon4;
    }

    public Pokemon getPokemon5() {
        return pokemon5;
    }

    public void setPokemon5(Pokemon pokemon5) {
        this.pokemon5 = pokemon5;
    }

    public Pokemon getPokemon6() {
        return pokemon6;
    }

    public void setPokemon6(Pokemon pokemon6) {
        this.pokemon6 = pokemon6;
    }


    @Override
    public String toString() {
        return "Equipo{" +
                "pokemon1=" + pokemon1 +
                ", pokemon2=" + pokemon2 +
                ", pokemon3=" + pokemon3 +
                ", pokemon4=" + pokemon4 +
                ", pokemon5=" + pokemon5 +
                ", pokemon6=" + pokemon6 +
                '}';
    }
}

