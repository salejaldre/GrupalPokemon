package com.example.grupalpokemon.Controladores;

import static com.example.grupalpokemon.Controladores.Comunes.mensaje;
import static com.example.grupalpokemon.Controladores.Controlador_AlertDialog.comprobarseleccion;
import static com.example.grupalpokemon.Vistas.Equipo.*;
import static com.example.grupalpokemon.Vistas.Login.useractual;


import android.content.Context;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.grupalpokemon.BBDD.Equipos_ADO;
import com.example.grupalpokemon.Modelos.Pokemon;
import com.example.grupalpokemon.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Controlador_Equipo {

    public static void guardarequipo(TextView pkmn1, TextView pkmn2, TextView pkmn3, TextView pkmn4, TextView pkmn5, TextView pkmn6, Equipos_ADO ado){

        ArrayList<String> guardarnombre= new ArrayList<>();
        guardarnombre.add(useractual.getUser());
        guardarnombre.add(pkmn1.getText().toString());
        guardarnombre.add(pkmn2.getText().toString());
        guardarnombre.add(pkmn3.getText().toString());
        guardarnombre.add(pkmn4.getText().toString());
        guardarnombre.add(pkmn5.getText().toString());
        guardarnombre.add(pkmn6.getText().toString());
        ado.insertar(guardarnombre);

    }

    public static void borrarequipos() {

        equipolocal.add(0,new Pokemon(1000,"Pokemon1","tipo","0","0","0","0","0","0","url"));
        equipolocal.add(1,new Pokemon(1001,"Pokemon2","tipo","0","0","0","0","0","0","url"));
        equipolocal.add(2,new Pokemon(1002,"Pokemon3","tipo","0","0","0","0","0","0","url"));
        equipolocal.add(3,new Pokemon(1003,"Pokemon4","tipo","0","0","0","0","0","0","url"));
        equipolocal.add(4,new Pokemon(1004,"Pokemon5","tipo","0","0","0","0","0","0","url"));
        equipolocal.add(5,new Pokemon(1005,"Pokemon6","tipo","0","0","0","0","0","0","url"));

    }

    public static void pokemonrandom(int posicion,ArrayList<Pokemon> listapokemons) {

        ArrayList<Pokemon> pokerandoms =listapokemons;
        Collections.shuffle(pokerandoms);
        equipolocal.set(posicion,pokerandoms.get(0));

    }

    public static void listaequipos(ArrayList<Pokemon> listapokemons, List<String> nombrecitos) {

        for(int q=0;q<nombrecitos.size();q++){
            String poknom = nombrecitos.get(q);
            for(int p=0;p<listapokemons.size();p++){
                if(listapokemons.get(p).getName().equals(poknom)){

                    equipolocal.add(q,listapokemons.get(p));
                    equipolocal.remove(q+1);
                }
            }
        }
    }

    public static void cargarequipo(TextView pkmn1,TextView pkmn2,TextView pkmn3,TextView pkmn4,TextView pkmn5,TextView pkmn6){

        pkmn1.setText(equipolocal.get(0).getName());
        pkmn2.setText(equipolocal.get(1).getName());
        pkmn3.setText(equipolocal.get(2).getName());
        pkmn4.setText(equipolocal.get(3).getName());
        pkmn5.setText(equipolocal.get(4).getName());
        pkmn6.setText(equipolocal.get(5).getName());
    }

    public static boolean comprobar(RadioButton rb1, RadioButton rb2, RadioButton rb3, RadioButton rb4, RadioButton rb5, RadioButton rb6, Context context,
    TextView pkmn1,TextView pkmn2,TextView pkmn3,TextView pkmn4,TextView pkmn5,TextView pkmn6) {

        if(comprobarseleccion(rb1)){seleccionado = pkmn1.getText().toString();posicion = 0;}
        else  if(comprobarseleccion(rb2)){seleccionado = pkmn2.getText().toString();posicion = 1;}
        else  if(comprobarseleccion(rb3)){seleccionado = pkmn3.getText().toString();posicion = 2;}
        else  if(comprobarseleccion(rb4)){seleccionado = pkmn4.getText().toString();posicion = 3;}
        else  if(comprobarseleccion(rb5)){seleccionado = pkmn5.getText().toString();posicion = 4;}
        else  if(comprobarseleccion(rb6)){seleccionado = pkmn6.getText().toString();posicion = 5;}
        else{
            mensaje(context.getString(R.string.noseleccion),context);
            return false;
        }
        return true;
    }


}
