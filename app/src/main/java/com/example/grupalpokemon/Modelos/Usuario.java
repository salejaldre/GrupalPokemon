package com.example.grupalpokemon.Modelos;

import java.io.Serializable;

public class Usuario implements Serializable {

    String user;
    String pass;
    String faccion;

    public Usuario() {
    }

    public Usuario(String user, String pass,String faccion) {
        this.user = user;
        this.pass = pass;
        this.faccion = faccion;
    }

    public String getFaccion() {
        return faccion;
    }

    public void setFaccion(String faccion) {
        this.faccion = faccion;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}