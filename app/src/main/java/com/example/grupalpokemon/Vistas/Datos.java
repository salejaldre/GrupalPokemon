package com.example.grupalpokemon.Vistas;

import static com.example.grupalpokemon.Controladores.Comunes.*;
import static com.example.grupalpokemon.Controladores.Controlador_Datos.*;
import static com.example.grupalpokemon.Imagenes.Imagenes.mostrarImagen;
import static com.example.grupalpokemon.Vistas.MainActivity.listafiltrada;
import static com.example.grupalpokemon.Vistas.MainActivity.pokemonlist;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.grupalpokemon.Menu.Menu;
import com.example.grupalpokemon.Modelos.Pokemon;
import com.example.grupalpokemon.R;

public class Datos extends Menu {

    private int posicion;
    private static ImageView imgpoke;
    static TextView nombre;
    static TextView tipo1;
    static TextView tipo2;
    static TextView hp;
    static TextView atk;
    static TextView satk;
    static TextView def;
    static TextView sdef;
    static TextView speed;
    static TextView natur;
    static TextView habilidad;
    static TextView movimiento;

    ImageView imgurl,flechaA,flechaB,shiny,atras;
    Pokemon pokemon;
    int comp = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        cargarcampos();

        posicion = getIntent().getIntExtra("posicion", 0);

        int opcion = getIntent().getIntExtra("ruta", 0);
        if (opcion == 0) {

            pokemon = pokemonlist.get(posicion);
            comprobarsiguiente(posicion,pokemonlist,flechaB,flechaA);


        } else if(opcion == 2){

            pokemon = listafiltrada.get(posicion);
            comprobarsiguiente(posicion,listafiltrada,flechaB,flechaA);


        }else{
            pokemon = (Pokemon) getIntent().getSerializableExtra("pokemon");
            desactivarflechas(flechaB,flechaA);
            activarlabels(natur,habilidad,movimiento);

        }

        mostrardatos(pokemon);
        pintados();


        atras.setOnClickListener(v->{
            finish();
        });

        shiny.setOnClickListener(v->{

            if(comp == 0){ shiny.setImageResource(R.drawable.shynipeque);
                mostrarImagen(imgpoke,pokemon.getUrlshiny());
                comp=1;}
            else{shiny.setImageResource(R.drawable.shynino);
                mostrarImagen(imgpoke,pokemon.getUrl());
                comp=0;}

        });

        imgurl.setOnClickListener(v -> {

            abrirurl(pokemon.getUrlpokedex());
        });

        flechaA.setOnClickListener(v -> {
            posicion++;
            if (opcion == 0) {
                pokemon = movimiento(pokemonlist,posicion,flechaB,flechaA);
            }else{
                pokemon = movimiento(listafiltrada,posicion,flechaB,flechaA);
            }
            pintados();
            comp=0;
        });

        flechaB.setOnClickListener(v -> {
            posicion--;
            if (opcion == 0) {
                pokemon = movimiento(pokemonlist,posicion,flechaB,flechaA);
            }else{
                pokemon = movimiento(listafiltrada,posicion,flechaB,flechaA);
            }
            pintados();
            comp=0;
        });
    }

    private void pintados(){

        pintar(tipo1, colores(pokemon.getType1()));
        if (compcampodos(pokemon)) {
            pintar(tipo2, colores(pokemon.getType2()));
        }
    }
    public static void mostrardatos(Pokemon pkm) {

        nombre.setText(pkm.getName());
        tipo1.setText(pkm.getType1());
        if(compcampodos(pkm)){tipo2.setText(pkm.getType2());}
        else{tipo2.setText("");}
        hp.setText(String.format("Hp: %s",pkm.getHp()));
        atk.setText(String.format("Attack: %s",pkm.getAttack()));
        satk.setText(String.format("Sp.Atk: %s",pkm.getSpattack()));
        def.setText(String.format("Defense: %s",pkm.getDefense()));
        sdef.setText(String.format("Sp.Def: %s",pkm.getSpdefense()));
        speed.setText(String.format("Speed: %s",pkm.getSpeed()));
        natur.setText(String.format("Nature: %s",pkm.getNaturaleza()));
        habilidad.setText(String.format("Ability: %s",pkm.getHabilidad()));
        movimiento.setText(String.format("Moves: %s",pkm.getMovimientos()));

        mostrarImagen(imgpoke,pkm.getUrl());
    }

    private void abrirurl(String url){

        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);

    }

    private void cargarcampos(){

        nombre = findViewById(R.id.txtnombredatos);
        tipo1 = findViewById(R.id.txttype1datos);
        tipo2 = findViewById(R.id.txttype2datos);
        hp = findViewById(R.id.txthp);
        atk = findViewById(R.id.txtatk);
        def = findViewById(R.id.txtdef);
        satk = findViewById(R.id.txtsat);
        sdef = findViewById(R.id.txtSdef);
        speed = findViewById(R.id.txtspeed);
        imgpoke = findViewById(R.id.imgfotopoke);
        imgurl = findViewById(R.id.imagenurl);
        flechaA = findViewById(R.id.flechaadelante);
        flechaB = findViewById(R.id.flechaatras);
        flechaB.setVisibility(View.VISIBLE);
        flechaB.setVisibility(View.VISIBLE);
        natur = findViewById(R.id.txtnaturaleza);
        shiny = findViewById(R.id.btshiny);
        habilidad = findViewById(R.id.txthabilidad);
        movimiento = findViewById(R.id.txtmovimientos);
        atras = findViewById(R.id.btatras);
    }

}