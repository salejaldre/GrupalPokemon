package com.example.grupalpokemon.Modelos;

public class Ataques {
    String name;
    String type;

    public Ataques(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }
}
