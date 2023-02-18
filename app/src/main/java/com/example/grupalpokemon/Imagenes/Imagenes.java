package com.example.grupalpokemon.Imagenes;

import android.content.Context;
import android.widget.ImageView;

import com.example.grupalpokemon.BBDD.Pokemon_ADO;
import com.example.grupalpokemon.Json.Json;
import com.example.grupalpokemon.Modelos.Pokemon;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Imagenes {

    public static List<String> urls = new ArrayList<>();

    public static List<String> trabajarconfotos(Context context){

        Pokemon_ADO ado = new Pokemon_ADO(context);
        List<Pokemon> datospokemon = ado.getAll();

        for(int i = 0; i < Json.objpokemon.size(); i++){
            urls.add(datospokemon.get(i).getUrl());
        }

        return  urls;
    }

    public static void mostrarImagen(Context context, int posicion, ImageView imgpoke){
        List<String> urlsimagenes = Imagenes.trabajarconfotos(context);


        for (int i = 0; i < urlsimagenes.size(); i++){
            urlsimagenes.get(i);
        }

        Picasso.get().load(urlsimagenes.get(posicion)).into(imgpoke);

        System.out.println();
    }
}
