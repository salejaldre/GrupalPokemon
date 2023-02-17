package com.example.grupalpokemon.Sonidos;

import android.content.Context;
import android.media.MediaPlayer;

import com.example.grupalpokemon.R;

public class Sonidos {

    private static MediaPlayer sonidofondo;
    private static MediaPlayer sonido;

    public static void crearsonidofondo(Context context){

        sonidofondo = MediaPlayer.create(context, R.raw.pokemoninicio); sonidofondo.setLooping(true);sonidofondo.start();
    }
    public static void crearsonido(Context context, String name){

        sonidofondo.pause();
        if(name.equals("nuevo")){sonido = MediaPlayer.create(context,R.raw.nuevopokmon); }
        else{sonido = MediaPlayer.create(context,R.raw.guardarpokemon);}
        sonido.setLooping(false);
        sonido.start();
        do{}while(sonido.isPlaying());
        sonidofondo.start();
    }

}
