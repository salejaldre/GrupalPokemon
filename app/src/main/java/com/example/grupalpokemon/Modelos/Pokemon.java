package com.example.grupalpokemon.Modelos;

public class Pokemon {
    int id;
    String name;
    String type1;
    String type2;
    String base;

    public Pokemon(int id, String name, String type1, String type2, String base) {
        this.id = id;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.base = base;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }
}
