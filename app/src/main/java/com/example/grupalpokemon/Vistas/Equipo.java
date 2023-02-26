package com.example.grupalpokemon.Vistas;



import static com.example.grupalpokemon.Controladores.Controlador_AlertDialogs.mostraralertaAnadir;
import static com.example.grupalpokemon.Controladores.Controlador_AlertDialogs.mostraralertaMovs;
import static com.example.grupalpokemon.Controladores.Controlador_Equipo.*;
import static com.example.grupalpokemon.Vistas.Pantalla_principal.equipolocal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.grupalpokemon.BBDD.Equipos_ADO;
import com.example.grupalpokemon.BBDD.Pokemon_ADO;
import com.example.grupalpokemon.Controladores.Comunes;
import com.example.grupalpokemon.Menu.Menu;
import com.example.grupalpokemon.Modelos.Pokemon;
import com.example.grupalpokemon.R;
import com.example.grupalpokemon.Sonidos.Sonidos;

import java.util.ArrayList;
import java.util.List;

public class Equipo extends Menu {

    public static TextView pkmn1;
    public static TextView pkmn2;
    public static TextView pkmn3;
    public static TextView pkmn4;
    public static TextView pkmn5;
    public static TextView pkmn6;
    public static ImageView img1;
    public static ImageView img2;
    public static ImageView img3;
    public static ImageView img4;
    public static ImageView img5;
    public static ImageView img6;
    public static ImageView impok1;
    public static ImageView impok2;
    public static ImageView impok3;
    public static ImageView impok4;
    public static ImageView impok5;
    public static ImageView impok6;
    public static RadioButton rb1;
    public static RadioButton rb2;
    public static RadioButton rb3;
    public static RadioButton rb4;
    public static RadioButton rb5;
    public static RadioButton rb6;
    public static int posicion;
    private List<String> equipolocalstrings;
    public static ImageView btn;
    public static ImageView btnmovs;
    public static ImageView btnguardar;
    public static ImageView btnrandom;
    Equipos_ADO eado;
    Pokemon_ADO pado;
    ConstraintLayout fondito;
    public static Pokemon pokemonseleccionado;
    android.app.AlertDialog alerta2;
    android.app.AlertDialog alerta1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipo);

        cargarcampos();
        fondito.setBackgroundResource(comprobarfondo());
        mostrarequipolabels(pkmn1, pkmn2, pkmn3, pkmn4, pkmn5, pkmn6, img1, img2, img3, img4, img5, img6,
                impok1,impok2,impok3,impok4,impok5,impok6);
        comprobarequipocompleto(impok1,impok2,impok3,impok4,impok5,impok6,0);

        LayoutInflater layoutInflater = getLayoutInflater();

        clicradiobt(rb1);
        clicradiobt(rb2);
        clicradiobt(rb3);
        clicradiobt(rb4);
        clicradiobt(rb5);
        clicradiobt(rb6);

        txtclicables(pkmn1, 0);
        txtclicables(pkmn2, 1);
        txtclicables(pkmn3, 2);
        txtclicables(pkmn4, 3);
        txtclicables(pkmn5, 4);
        txtclicables(pkmn6, 5);


        btnrandom.setOnClickListener(v -> {
            if (comprobar(rb1, rb2, rb3, rb4, rb5, rb6, this, pkmn1, pkmn2, pkmn3, pkmn4, pkmn5, pkmn6)) {
                pokemonrandom(posicion);
                mostrarequipolabels(pkmn1, pkmn2, pkmn3, pkmn4, pkmn5, pkmn6, img1, img2, img3, img4, img5, img6,
                        impok1,impok2,impok3,impok4,impok5,impok6);
                comprobarequipocompleto(impok1,impok2,impok3,impok4,impok5,impok6,0);
                cerrarboton(btnmovs,true);
            }

        });

        btnguardar.setOnClickListener(v -> {
            Sonidos.crearsonido(this, "guardar");
            guardarequipo(pkmn1, pkmn2, pkmn3, pkmn4, pkmn5, pkmn6, eado, (ArrayList<String>) equipolocalstrings);

        });

        btnmovs.setOnClickListener(v -> {
            if (comprobar(rb1, rb2, rb3, rb4, rb5, rb6, this, pkmn1, pkmn2, pkmn3, pkmn4, pkmn5, pkmn6)) {
                alerta1 = new android.app.AlertDialog.Builder(this).create();
                mostraralertaMovs(this,alerta1,layoutInflater);
            }
        });

        btn.setOnClickListener(v -> {

            if (comprobar(rb1, rb2, rb3, rb4, rb5, rb6, this, pkmn1, pkmn2, pkmn3, pkmn4, pkmn5, pkmn6)) {
                alerta2 = new android.app.AlertDialog.Builder(this).create();
                mostraralertaAnadir(this,alerta2,layoutInflater);
            }

        });

    }

   private void clicradiobt(RadioButton ra) {

       ra.setOnClickListener(v -> {
               comprobarlabelspokemon(ra);
       });
   }

    private void txtclicables(TextView txt, int ps) {

        txt.setOnClickListener(v -> {

            if ( comprobartxt(txt,"Pokemon1")|| comprobartxt(txt,"Pokemon4") ||
                    comprobartxt(txt,"Pokemon5") || comprobartxt(txt,"Pokemon3") ||
                    comprobartxt(txt,"Pokemon6") ||comprobartxt(txt,"Pokemon2")) {

            } else {
                Comunes.intentos(this,equipolocal.get(ps),9,Datos.class);
            }
        });

    }

    private void cargarcampos() {

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
        img1 = findViewById(R.id.imgpk1);
        img2 = findViewById(R.id.imgpk2);
        img3 = findViewById(R.id.imgpk3);
        img4 = findViewById(R.id.imgpk4);
        img5 = findViewById(R.id.imgpk5);
        img6 = findViewById(R.id.imgpk6);
        impok1= findViewById(R.id.pkcom1);
        impok2= findViewById(R.id.pkcom2);
        impok3= findViewById(R.id.pkcom3);
        impok4= findViewById(R.id.pkcom4);
        impok5= findViewById(R.id.pkcom5);
        impok6= findViewById(R.id.pkcom6);
        btn = findViewById(R.id.boton);
        btnmovs = findViewById(R.id.botonborrar);
        btnguardar = findViewById(R.id.botonguardar);
        btnrandom = findViewById(R.id.botonrandom);
        fondito = findViewById(R.id.fondito);

        pado = new Pokemon_ADO(this);
        eado = new Equipos_ADO(this);

        posicion = 0;
        equipolocalstrings = arraystringlocal(eado);
        pokemonseleccionado = new Pokemon();

    }

}