package com.example.grupalpokemon.Controladores;

import static com.example.grupalpokemon.Vistas.Datos.mostrardatos;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.grupalpokemon.Modelos.Pokemon;

import java.util.ArrayList;

public class Controlador_Datos {

    public static void comprobarsiguiente(int posicion, ArrayList lista, ImageView flechaB, ImageView flechaA) {
        if (posicion == 0) {
            flechaB.setVisibility(View.INVISIBLE);
        } else if (posicion == lista.size() - 1) {
            flechaA.setVisibility(View.INVISIBLE);
        } else {
            flechaB.setVisibility(View.VISIBLE);
            flechaA.setVisibility(View.VISIBLE);
        }

    }

    public static void desactivarflechas(ImageView flechaB, ImageView flechaA) {
        flechaB.setVisibility(View.INVISIBLE);
        flechaA.setVisibility(View.INVISIBLE);
    }

    public static Pokemon movimiento(ArrayList lista, int posicion, ImageView flechaB, ImageView flechaA) {

        Pokemon prxpokemon = (Pokemon) lista.get(posicion);
        mostrardatos(prxpokemon);
        comprobarsiguiente(posicion, lista, flechaB, flechaA);
        return prxpokemon;
    }

    public static void activarlabels(TextView natur, TextView hab, TextView mov) {
        natur.setVisibility(View.VISIBLE);
        hab.setVisibility(View.VISIBLE);
        mov.setVisibility(View.VISIBLE);
    }
}