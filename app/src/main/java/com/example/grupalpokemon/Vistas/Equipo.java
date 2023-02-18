package com.example.grupalpokemon.Vistas;


import static com.example.grupalpokemon.Controladores.Controlador_Equipo.*;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.grupalpokemon.BBDD.Equipos_ADO;
import com.example.grupalpokemon.BBDD.Pokemon_ADO;
import com.example.grupalpokemon.Controladores.Controlador_AlertDialog;
import com.example.grupalpokemon.Menu.Menu;
import com.example.grupalpokemon.Modelos.Pokemon;
import com.example.grupalpokemon.R;
import com.example.grupalpokemon.Sonidos.Sonidos;

import java.util.ArrayList;
import java.util.List;

public class Equipo extends Menu {

    private TextView pkmn1;
    private TextView pkmn2;
    private TextView pkmn3;
    private TextView pkmn4;
    private TextView pkmn5;
    private TextView pkmn6;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private RadioButton rb5;
    private RadioButton rb6;
    public static String seleccionado;
    public static int posicion;
    public static ArrayList<Pokemon> equipolocal;
    private List<String> nombrecitos;
    private ArrayList<Pokemon> listapokemons;
    ImageView btn;
    ImageView btnborrar;
    ImageView btnguardar;
    ImageView btnrandom;
    Equipos_ADO ado;
    Pokemon_ADO adop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipo);

        iniciarlabels();
        borrarequipos();
        listaequipos(listapokemons,nombrecitos);
        cargarequipo(pkmn1,pkmn2,pkmn3,pkmn4,pkmn5,pkmn6);

    btnrandom.setOnClickListener(v->{
        if(comprobar(rb1,rb2,rb3,rb4,rb5,rb6,this,pkmn1,pkmn2,pkmn3,pkmn4,pkmn5,pkmn6)){
        pokemonrandom(posicion,listapokemons);
        cargarequipo(pkmn1,pkmn2,pkmn3,pkmn4,pkmn5,pkmn6);
        }

    });

    btnguardar.setOnClickListener(v->{
        Sonidos.crearsonido(this,"guardar");
        guardarequipo(pkmn1,pkmn2,pkmn3,pkmn4,pkmn5,pkmn6,ado);

        });

       btnborrar.setOnClickListener(v->{
           borrarequipos();
           cargarequipo(pkmn1,pkmn2,pkmn3,pkmn4,pkmn5,pkmn6);

       });

    btn.setOnClickListener(v->{

   if(comprobar(rb1,rb2,rb3,rb4,rb5,rb6,this,pkmn1,pkmn2,pkmn3,pkmn4,pkmn5,pkmn6)){
       Controlador_AlertDialog conta = new Controlador_AlertDialog();
       conta.mostraralerta(this,listapokemons);
       cargarequipo(pkmn1,pkmn2,pkmn3,pkmn4,pkmn5,pkmn6);

   }
    });
   }

    private void iniciarlabels(){

        pkmn1 = findViewById(R.id.pokemon1);
        pkmn2 = findViewById(R.id.pokemon2);
        pkmn3 = findViewById(R.id.pokemon3);
        pkmn4 = findViewById(R.id.pokemon4);
        pkmn5 = findViewById(R.id.pokemon5);
        pkmn6 = findViewById(R.id.pokemon6);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        rb4 = findViewById(R.id.rb4);
        rb5 = findViewById(R.id.rb5);
        rb6 = findViewById(R.id.rb6);

        btn = findViewById(R.id.boton);
        btnborrar = findViewById(R.id.botonborrar);
        btnguardar = findViewById(R.id.botonguardar);
        btnrandom = findViewById(R.id.botonrandom);

        adop = new Pokemon_ADO(this);
        ado = new Equipos_ADO(this);
        equipolocal = new ArrayList<>();
        posicion=0;
        seleccionado="";
        listapokemons = (ArrayList<Pokemon>) adop.getAll();
        nombrecitos = ado.getAll();
   }

}