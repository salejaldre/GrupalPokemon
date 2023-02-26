package com.example.grupalpokemon.Imagenes;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class Imagenes {

    public static void mostrarImagen(ImageView imgpoke,String url){
        if(!url.equals("")){
            Picasso.get().load(url).into(imgpoke);
        }

    }
}
