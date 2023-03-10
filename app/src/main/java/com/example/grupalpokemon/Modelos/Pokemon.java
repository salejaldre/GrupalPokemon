package com.example.grupalpokemon.Modelos;

import java.io.Serializable;

public class Pokemon implements Serializable {

    int id;
    String name;
    String type1;
    String type2;
    String hp;
    String attack;
    String defense;
    String spattack;
    String spdefense;
    String speed;
    String url;
    String urlshiny;
    String urlpokedex;
    String naturaleza;
    String habilidad;
    String movimientos;

    public Pokemon() {
    }

    public Pokemon(String name) {
        this.name = name;
    }

    public Pokemon(int id, String name, String type1, String hp, String attack, String defense, String spattack, String spdefense, String speed,  String url,String urlpokedex,String urlshiny,String naturaleza,String habilidad,String movimientos) {
        this.id = id;
        this.name = name;
        this.type1 = type1;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.spattack = spattack;
        this.spdefense = spdefense;
        this.speed = speed;
        this.url = url;
        this.urlpokedex = urlpokedex;
        this.urlshiny = urlshiny;
        this.habilidad = habilidad;
        this.movimientos = movimientos;
        this.naturaleza = naturaleza;

    }

    public Pokemon(int id, String name, String type1, String type2, String hp, String attack, String defense, String spattack, String spdefense, String speed,  String url,String urlpokedex,String urlshiny,String naturaleza,String habilidad,String movimientos) {
        this.id = id;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.spattack = spattack;
        this.spdefense = spdefense;
        this.speed = speed;
        this.url = url;
        this.urlpokedex = urlpokedex;
        this.urlshiny = urlshiny;
        this.habilidad = habilidad;
        this.movimientos = movimientos;
        this.naturaleza = naturaleza;
    }

    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }

    public String getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(String movimientos) {
        this.movimientos = movimientos;
    }

    public String getUrlshiny() {
        return urlshiny;
    }

    public void setUrlshiny(String urlshiny) {
        this.urlshiny = urlshiny;
    }

    public String getNaturaleza() {
        return naturaleza;
    }

    public void setNaturaleza(String naturaleza) {
        this.naturaleza = naturaleza;
    }

    public String getUrlpokedex() {
        return urlpokedex;
    }

    public void setUrlpokedex(String url2) {
        this.urlpokedex = url2;
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

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getAttack() {
        return attack;
    }

    public void setAttack(String attack) {
        this.attack = attack;
    }

    public String getDefense() {
        return defense;
    }

    public void setDefense(String defense) {
        this.defense = defense;
    }

    public String getSpattack() {
        return spattack;
    }

    public void setSpattack(String spattack) {
        this.spattack = spattack;
    }

    public String getSpdefense() {
        return spdefense;
    }

    public void setSpdefense(String spdefense) {
        this.spdefense = spdefense;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}