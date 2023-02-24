package com.example.grupalpokemon.Imagenes;

import android.content.Context;
import android.widget.ImageView;

import com.example.grupalpokemon.BBDD.Pokemon_ADO;
import com.example.grupalpokemon.Json.JsonPokemon;
import com.example.grupalpokemon.Modelos.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class Imagenes {

    public static void mostrarImagen(ImageView imgpoke,String url){
        if(!url.equals("")){
            Picasso.get().load(url).into(imgpoke);
            System.out.println();}

    }
}
