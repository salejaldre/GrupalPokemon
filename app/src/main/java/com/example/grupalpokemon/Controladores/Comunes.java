package com.example.grupalpokemon.Controladores;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.widget.TextView;
import android.widget.Toast;

import com.example.grupalpokemon.Modelos.Pokemon;

import java.util.ArrayList;

public class Comunes {

    public static void mensaje(String ms, Context context){
        Toast.makeText(context, ms, Toast.LENGTH_SHORT).show();
    }

    public static void intentos(Context context, Pokemon pokemon,int ruta,Class destino){

        Intent intent = new Intent(context,destino);
        intent.putExtra("pokemon",pokemon);
        intent.putExtra("ruta",ruta);
        context.startActivity(intent);
    }

    public static void intentosdos(Context context,int position,int ruta, Class destino){

        Intent intent = new Intent(context, destino);
        intent.putExtra("posicion",position);
        intent.putExtra("ruta",ruta);
        context.startActivity(intent);
    }

    public static ArrayList<Integer> colores(String type1) {
        ArrayList color = new ArrayList<Integer>();
        if(type1.equals("Fire")||type1.equals("Valor")){ color.add(255);color.add(0);color.add(0);}
        else  if(type1.equals("Water")||type1.equals("Sabiduria")){color.add(0);color.add(0);color.add(255);}
        else  if(type1.equals("Grass")){color.add(32);color.add(199);color.add(103);}
        else  if(type1.equals("Rock")){color.add(169);color.add(149);color.add(118);}
        else  if(type1.equals("Ground")){color.add(150);color.add(95);color.add(63);}
        else  if(type1.equals("Fighting")){color.add(236);color.add(155);color.add(31);}
        else  if(type1.equals("Flying")){color.add(216);color.add(243);color.add(242);}
        else  if(type1.equals("Bug")){color.add(90);color.add(131);color.add(82);}
        else  if(type1.equals("Dark")){color.add(0);color.add(0);color.add(0);}
        else  if(type1.equals("Psychic")){color.add(248);color.add(28);color.add(145);}
        else  if(type1.equals("Fairy")){color.add(255);color.add(171);color.add(242);}
        else  if(type1.equals("Normal")){color.add(202);color.add(152);color.add(167);}
        else  if(type1.equals("Ghost")){color.add(144);color.add(103);color.add(144);}
        else  if(type1.equals("Steel")){color.add(202);color.add(201);color.add(202);}
        else  if(type1.equals("Poison")){color.add(155);color.add(105);color.add(217);}
        else  if(type1.equals("Dragon")){color.add(67);color.add(56);color.add(156);}
        else  if(type1.equals("Electric")||type1.equals("Instinto")){color.add(234);color.add(227);color.add(20);}
        else  if(type1.equals("Ice")){color.add(121);color.add(255);color.add(245);}
        return color;
    }

    public static void pintar(TextView txt, ArrayList<Integer> colores){
        txt.setTextColor(Color.rgb(colores.get(0),colores.get(1),colores.get(2)));

    }
    public static boolean compcampodos(Pokemon pkm){
        return !pkm.getType2().equals("null");
    }
}
