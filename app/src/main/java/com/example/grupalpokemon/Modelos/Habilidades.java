package com.example.grupalpokemon.Modelos;

public class Habilidades {
    String nombrehabilidad;

    public Habilidades() {
    }

    public Habilidades(String ability) {
        this.nombrehabilidad = ability;
    }

    public String getAbility() {
        return nombrehabilidad;
    }

    public void setAbility(String ability) {
        this.nombrehabilidad = ability;
    }
}
