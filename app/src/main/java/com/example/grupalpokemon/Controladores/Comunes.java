package com.example.grupalpokemon.Controladores;

import android.content.Context;
import android.widget.Toast;

public class Comunes {

    public static void mensaje(String ms, Context context){
        Toast.makeText(context, ms, Toast.LENGTH_SHORT).show();
    }
}
