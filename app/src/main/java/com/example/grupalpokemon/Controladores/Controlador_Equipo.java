package com.example.grupalpokemon.Controladores;


import static com.example.grupalpokemon.Controladores.Comunes.mensaje;
import static com.example.grupalpokemon.Imagenes.Imagenes.mostrarImagen;
import static com.example.grupalpokemon.Vistas.Equipo.*;
import static com.example.grupalpokemon.Vistas.Login.useractual;
import static com.example.grupalpokemon.Vistas.MainActivity.pokemonlist;

import android.content.Context;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.grupalpokemon.BBDD.Equipos_ADO;
import com.example.grupalpokemon.Modelos.Pokemon;
import com.example.grupalpokemon.R;
import com.example.grupalpokemon.Sonidos.Sonidos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Controlador_Equipo {

    public static void guardarequipo(TextView pkmn1, TextView pkmn2, TextView pkmn3, TextView pkmn4, TextView pkmn5, TextView pkmn6, Equipos_ADO ado,ArrayList<String> nombrecitos){
        if(comprobarpokemon(pkmn1)&&comprobarpokemon(pkmn2)&&comprobarpokemon(pkmn3)&&comprobarpokemon(pkmn4)&&comprobarpokemon(pkmn5)&&comprobarpokemon(pkmn6)){
        ArrayList<String> guardarnombre= new ArrayList<>();
        guardarnombre.add(useractual.getUser());
        guardarnombre.add(pkmn1.getText().toString());
        guardarnombre.add(pkmn2.getText().toString());
        guardarnombre.add(pkmn3.getText().toString());
        guardarnombre.add(pkmn4.getText().toString());
        guardarnombre.add(pkmn5.getText().toString());
        guardarnombre.add(pkmn6.getText().toString());

        if(nombrecitos.get(0).equals("")){ado.insertar(guardarnombre);}
        else{ado.update(guardarnombre);}
            mensaje(pkmn1.getContext().getString(R.string.equipoguardado),pkmn1.getContext());
    }else{
            mensaje(pkmn1.getContext().getString(R.string.equipomal),pkmn1.getContext());

        }
    }

    private static boolean comprobarpokemon(TextView pkmon) {
        for(int q = 0;q<pokemonlist.size();q++){
            if(pkmon.getText().equals(pokemonlist.get(q).getName())){return true;}
        }
        return false;

    }

    public static void borrarequipos() {

        equipolocal.add(0,new Pokemon("Pokemon1"));
        equipolocal.add(1,new Pokemon("Pokemon2"));
        equipolocal.add(2,new Pokemon("Pokemon3"));
        equipolocal.add(3,new Pokemon("Pokemon4"));
        equipolocal.add(4,new Pokemon("Pokemon5"));
        equipolocal.add(5,new Pokemon("Pokemon6"));

    }

    public static int comprobarfondo(){

        if(useractual.getFaccion().equals("Valor")){ return R.drawable.rojo;}
        else if(useractual.getFaccion().equals("Sabiduria")){ return R.drawable.aguagrande;}
        else {return R.drawable.yellow;}
    }

    public static void pokemonrandom(int posicion) {

        ArrayList<Pokemon> pokerandoms =pokemonlist;
        Collections.shuffle(pokerandoms);
       Pokemon ran = pokerandoms.get(0);
       ran.setNaturaleza("Naughty");
        equipolocal.set(posicion,ran);

    }

    public static void listaequipos( List<String> nombrecitos) {

        for(int q=0;q<nombrecitos.size();q++){
            String poknom = nombrecitos.get(q);
            for(int p=0;p<pokemonlist.size();p++){
                if(pokemonlist.get(p).getName().equals(poknom)){
                    equipolocal.add(q,pokemonlist.get(p));
                    equipolocal.remove(q+1);
                }
            }
        }
    }

    public static void cargarequipo(TextView pkmn1, TextView pkmn2, TextView pkmn3, TextView pkmn4, TextView pkmn5, TextView pkmn6,
                                    ImageView img1,ImageView img2,ImageView img3,ImageView img4,ImageView img5,ImageView img6){

        pkmn1.setText(equipolocal.get(0).getName());
        pkmn2.setText(equipolocal.get(1).getName());
        pkmn3.setText(equipolocal.get(2).getName());
        pkmn4.setText(equipolocal.get(3).getName());
        pkmn5.setText(equipolocal.get(4).getName());
        pkmn6.setText(equipolocal.get(5).getName());
        mostrarImagen(equipolocal.get(0),img1);
        mostrarImagen(equipolocal.get(1),img2);
        mostrarImagen(equipolocal.get(2),img3);
        mostrarImagen(equipolocal.get(3),img4);
        mostrarImagen(equipolocal.get(4),img5);
        mostrarImagen(equipolocal.get(5),img6);
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


    public static void comprobarAlerta(EditText campo, Spinner spin) {
        String nombre = campo.getText().toString();
        if(!nombre.trim().equals("")){

            for(int q=0;q<pokemonlist.size();q++){
                if(nombre.equals(pokemonlist.get(q).getName())){

                    if(spin.getSelectedItemPosition()!=0){

                        Sonidos.crearsonido(campo.getContext(),"nuevo");
                        pokemonlist.get(q).setNaturaleza(spin.getSelectedItem().toString());
                        equipolocal.add(posicion,pokemonlist.get(q));
                        equipolocal.remove(posicion+1);
                        cargarequipo(pkmn1,pkmn2,pkmn3,pkmn4,pkmn5,pkmn6,img1,img2,img3,img4,img5,img6);
                        break;

                    }else{mensaje(campo.getContext().getString(R.string.naturalezaerror), campo.getContext());}

                }else if(q == pokemonlist.size())mensaje(campo.getContext().getString(R.string.noencontrado),campo.getContext());
            }
        }
    }

    public static boolean comprobarseleccion(RadioButton boton){
        return boton.isChecked();
    }


}
