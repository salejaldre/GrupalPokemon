package com.example.grupalpokemon.Controladores;

import static com.example.grupalpokemon.Controladores.Comunes.mensaje;
import static com.example.grupalpokemon.Imagenes.Imagenes.mostrarImagen;
import static com.example.grupalpokemon.Json.JsonHabilidades.habilidadeslist;
import static com.example.grupalpokemon.Vistas.Equipo.*;
import static com.example.grupalpokemon.Vistas.Login.useractual;
import static com.example.grupalpokemon.Vistas.MainActivity.pokemonlist;
import static com.example.grupalpokemon.Vistas.Pantalla_principal.btshow;
import static com.example.grupalpokemon.Vistas.Pantalla_principal.equipolocal;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.grupalpokemon.BBDD.Equipos_ADO;
import com.example.grupalpokemon.Modelos.Pokemon;
import com.example.grupalpokemon.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Controlador_Equipo {

    public static void guardarequipo(TextView pkmn1, TextView pkmn2, TextView pkmn3, TextView pkmn4, TextView pkmn5, TextView pkmn6, Equipos_ADO ado,ArrayList<String> nombrecitos){
        if(comprobarpokemon(pkmn1)&&comprobarpokemon(pkmn2)&&comprobarpokemon(pkmn3)&&comprobarpokemon(pkmn4)&&comprobarpokemon(pkmn5)&&comprobarpokemon(pkmn6)){
            ArrayList<String> guardarequipo= new ArrayList<>(24);

            guardarequipo.add(useractual.getUser());

            guardarequipo = guardarcamposequipo(guardarequipo);

            guardarequipo.add(useractual.getFaccion());
            if(nombrecitos.get(0).equals("")){ado.insertar(guardarequipo);}
            else{ado.update(guardarequipo);}
            mensaje(pkmn1.getContext().getString(R.string.equipoguardado),pkmn1.getContext());

        }
    }

    public static List<String> arraystringlocal(Equipos_ADO ado) {
        List equipolocalstrings = new ArrayList<>();
        for (int q = 0; q < 24; q++) {equipolocalstrings.add(q,"");}
        equipolocalstrings = ado.getEquipolocal(equipolocalstrings);
        return equipolocalstrings;
    }


    private static ArrayList<String> guardarcamposequipo(ArrayList<String> valores){
        for(int a =0;a<equipolocal.size();a++){

            valores.add(equipolocal.get(a).getName());
            valores.add(equipolocal.get(a).getMovimientos());
            valores.add(equipolocal.get(a).getHabilidad());
            valores.add(equipolocal.get(a).getNaturaleza());

        }
        return valores;
    }

    private static boolean comprobarpokemon(TextView pkmon) {
        if(pkmon.getText().equals("Pokemon1")||pkmon.getText().equals("Pokemon2")||pkmon.getText().equals("Pokemon3")||
                pkmon.getText().equals("Pokemon4")||pkmon.getText().equals("Pokemon5")||pkmon.getText().equals("Pokemon6")){
            return false;
        }
        else{
            return true;
        }

    }

    public static void crearequipolocalvacio() {

        equipolocal.add(0,new Pokemon(1000,"Pokemon1","","","","","","","","","","","","","",""));
        equipolocal.add(1,new Pokemon(1000,"Pokemon2","","","","","","","","","","","","","",""));
        equipolocal.add(2,new Pokemon(1000,"Pokemon3","","","","","","","","","","","","","",""));
        equipolocal.add(3,new Pokemon(1000,"Pokemon4","","","","","","","","","","","","","",""));
        equipolocal.add(4,new Pokemon(1000,"Pokemon5","","","","","","","","","","","","","",""));
        equipolocal.add(5,new Pokemon(1000,"Pokemon6","","","","","","","","","","","","","",""));

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
        ran.setHabilidad("Libero");
        ran.setMovimientos("Pound;Growl;Tail Whip;Scrath");
        equipolocal.set(posicion,ran);

    }

    public static void rellenarequipolocal( List<String> equipolocalstrings) {
        int pos =0;
        for(int q=0;q<equipolocalstrings.size();q+=4){
            for(int p=0;p<pokemonlist.size();p++){
                if(pokemonlist.get(p).getName().equals(equipolocalstrings.get(q))){
                    Pokemon neupokemon = pokemonlist.get(p);
                    neupokemon.setMovimientos(equipolocalstrings.get(q+1));
                    neupokemon.setHabilidad(equipolocalstrings.get(q+2));
                    neupokemon.setNaturaleza(equipolocalstrings.get(q+3));
                    equipolocal.set(pos,neupokemon);
                    pos++;
                    break;
                }
            }
        }
    }

    public static void mostrarequipolabels(TextView pkmn1, TextView pkmn2, TextView pkmn3, TextView pkmn4,
                                           TextView pkmn5, TextView pkmn6,ImageView img1, ImageView img2, ImageView img3, ImageView img4,
                                           ImageView img5, ImageView img6,ImageView pok1,ImageView pok2,ImageView pok3,ImageView pok4,
                                           ImageView pok5,ImageView pok6){

        pkmn1.setText(equipolocal.get(0).getName());
        if(!comprobirtxt(pkmn1,"Pokemon1")){pok1.setVisibility(View.VISIBLE);}
        pkmn2.setText(equipolocal.get(1).getName());
        if(!comprobirtxt(pkmn2,"Pokemon2")){pok2.setVisibility(View.VISIBLE);}
        pkmn3.setText(equipolocal.get(2).getName());
        if(!comprobirtxt(pkmn3,"Pokemon3")){pok3.setVisibility(View.VISIBLE);}
        pkmn4.setText(equipolocal.get(3).getName());
        if(!comprobirtxt(pkmn4,"Pokemon4")){pok4.setVisibility(View.VISIBLE);}
        pkmn5.setText(equipolocal.get(4).getName());
        if(!comprobirtxt(pkmn5,"Pokemon5")){pok5.setVisibility(View.VISIBLE);}
        pkmn6.setText(equipolocal.get(5).getName());
        if(!comprobirtxt(pkmn6,"Pokemon6")){pok6.setVisibility(View.VISIBLE);}
        mostrarImagen(img1,equipolocal.get(0).getUrl());
        mostrarImagen(img2,equipolocal.get(1).getUrl());
        mostrarImagen(img3,equipolocal.get(2).getUrl());
        mostrarImagen(img4,equipolocal.get(3).getUrl());
        mostrarImagen(img5,equipolocal.get(4).getUrl());
        mostrarImagen(img6,equipolocal.get(5).getUrl());
    }


    public static boolean comprobirtxt(TextView txt,String poke){

        return txt.getText().equals(poke);
    }

    public static boolean comprobar(RadioButton rb1, RadioButton rb2, RadioButton rb3, RadioButton rb4, RadioButton rb5, RadioButton rb6, Context context,
                                    TextView pkmn1,TextView pkmn2,TextView pkmn3,TextView pkmn4,TextView pkmn5,TextView pkmn6) {

        if(comprobarbotonseleccionado(rb1)){
            comprobarpokemonseleccionado(pkmn1);posicion = 0;}
        else  if(comprobarbotonseleccionado(rb2)){
            comprobarpokemonseleccionado(pkmn2);posicion = 1;}
        else  if(comprobarbotonseleccionado(rb3)){
            comprobarpokemonseleccionado(pkmn3);posicion = 2;}
        else  if(comprobarbotonseleccionado(rb4)){
            comprobarpokemonseleccionado(pkmn4);posicion = 3;}
        else  if(comprobarbotonseleccionado(rb5)){
            comprobarpokemonseleccionado(pkmn5);posicion = 4;}
        else  if(comprobarbotonseleccionado(rb6)){
            comprobarpokemonseleccionado(pkmn6);posicion = 5;}
        else{
            return false;
        }
        return true;
    }
    public static void comprobarpokemonseleccionado(TextView name){

        for (int q = 0; q < equipolocal.size(); q++) {
            if (name.getText().toString().equals(equipolocal.get(q).getName())) {

                pokemonseleccionado = equipolocal.get(q);

                break;
            }
        }
    }
    public static void comprobarlabelspokemon(RadioButton rb){
        cerrarboton(btn,true);cerrarboton(btnrandom,true);
        if(rb.equals(rb1)&&!equipolocal.get(0).getName().equals("Pokemon1")){
            cerrarboton(btnmovs,true);}
        else  if(rb.equals(rb2)&&!equipolocal.get(1).getName().equals("Pokemon2")){
            cerrarboton(btnmovs,true);}
        else  if(rb.equals(rb3)&&!equipolocal.get(2).getName().equals("Pokemon3")){
            cerrarboton(btnmovs,true);}
        else  if(rb.equals(rb4)&&!equipolocal.get(3).getName().equals("Pokemon4")){
            cerrarboton(btnmovs,true);}
        else  if(rb.equals(rb5)&&!equipolocal.get(4).getName().equals("Pokemon5")){
            cerrarboton(btnmovs,true);}
        else  if(rb.equals(rb6)&&!equipolocal.get(5).getName().equals("Pokemon6")){
            cerrarboton(btnmovs,true);}
        else{
            cerrarboton(btnmovs,false);
        }
    }

    public static void rellenarspinerhabilidad(Spinner spinhabilidad) {

        ArrayList<String> habilidadesstring = new ArrayList<>();
        habilidadesstring.add("Seleccione Habilidad");
        for (int q = 0; q < habilidadeslist.size(); q++) {
            habilidadesstring.add(habilidadeslist.get(q).getAbility());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                spinhabilidad.getContext(), android.R.layout.simple_spinner_item, habilidadesstring);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinhabilidad.setAdapter(adapter);

    }

    private static void cambiarpokeball(ImageView pok1, ImageView pok2, ImageView pok3, ImageView pok4,
                                        ImageView pok5, ImageView pok6, int q, int img){
        if(q==0){pok1.setImageResource(img);}
        if(q==1){pok2.setImageResource(img);}
        if(q==2){pok3.setImageResource(img);}
        if(q==3){pok4.setImageResource(img);}
        if(q==4){pok5.setImageResource(img);}
        if(q==5){pok6.setImageResource(img);}

    }

    public static void comprobarequipocompleto(ImageView pok1, ImageView pok2, ImageView pok3, ImageView pok4,
                                               ImageView pok5, ImageView pok6,int op) {
        int bien = 0;
        for (int q = 0; q < equipolocal.size(); q++) {

            if (comprobartodoslosdatosdeunpokemon(equipolocal.get(q))) {
                cambiarpokeball(pok1,pok2,pok3,pok4,pok5,pok6,q,R.drawable.pokeballbien);

                bien++;
            }else{
                cambiarpokeball(pok1,pok2,pok3,pok4,pok5,pok6,q,R.drawable.pokeballmal);
            }
        }
        if (bien == 6) {
            if(op==0){  cerrarboton(btnguardar,true);}

            cerrarboton(btshow,true);

        } else {
            if(op==0){   cerrarboton(btnguardar,false);}
            cerrarboton(btshow,false);

        }

    }

    public static boolean comprobartodoslosdatosdeunpokemon(Pokemon pokemon) {
        if (!pokemon.getMovimientos().equals("") &&
                !pokemon.getNaturaleza().equals("") &&
                !pokemon.getHabilidad().equals(""))
        {
            return true;
        } else {
            return false;
        }
    }

    public static void cerrarboton(ImageView bt, Boolean sino){
        bt.setEnabled(sino);
        if(sino){
            if(bt.equals(btnguardar)){bt.setImageResource(R.drawable.botonb);}
            else if(bt.equals(btn)){bt.setImageResource(R.drawable.botong);}
            else if(bt.equals(btnrandom)){bt.setImageResource(R.drawable.botony);}
            else if(bt.equals(btshow)){bt.setImageResource(R.drawable.botonp);}
            else{bt.setImageResource(R.drawable.botonr);}
        }else{bt.setImageResource(R.drawable.bontogrey);}

    }

    public static boolean comprobarbotonseleccionado(RadioButton boton){
        return boton.isChecked();
    }

    public static boolean comprobarspiner(Spinner sp){
        return sp.getSelectedItemPosition()!=0;

    }
}
