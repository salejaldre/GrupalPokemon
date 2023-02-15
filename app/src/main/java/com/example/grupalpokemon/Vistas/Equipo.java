package com.example.grupalpokemon.Vistas;

import static com.example.grupalpokemon.Controladores.Controlador_AlertDialog.comprobarseleccion;
import static com.example.grupalpokemon.Json.Json.objpokemon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.grupalpokemon.BBDD.Equipos_ADO;
import com.example.grupalpokemon.Controladores.Controlador_AlertDialog;
import com.example.grupalpokemon.Modelos.EquipoModelo;
import com.example.grupalpokemon.Modelos.Pokemon;
import com.example.grupalpokemon.R;

import java.util.ArrayList;
import java.util.List;

public class Equipo extends AppCompatActivity {

     TextView pkmn1;
     TextView pkmn2;
     TextView pkmn3;
     TextView pkmn4;
     TextView pkmn5;
     TextView pkmn6;
     RadioButton rb1;
     RadioButton rb2;
     RadioButton rb3;
     RadioButton rb4;
     RadioButton rb5;
     RadioButton rb6;
     public static String seleccionado;
     public static int posicion=0;
     public static ArrayList<Pokemon> equipolocal;
     public static List<String> nombrecitos;
     ImageView btn;
     ImageView btnborrar;
     ImageView btnguardar;
     Equipos_ADO ado = new Equipos_ADO(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipo);


        iniciarlabels();

        borrarequipos();
        nombrecitos = ado.getAll();
        listaequipos();

        cargarequipo();

        btnguardar.setOnClickListener(v->{
    ArrayList<String> guardarnombre = null;
           guardarnombre.add(pkmn1.getText().toString());
           guardarnombre.add(pkmn2.getText().toString());
           guardarnombre.add(pkmn3.getText().toString());
           guardarnombre.add(pkmn4.getText().toString());
           guardarnombre.add(pkmn5.getText().toString());
           guardarnombre.add(pkmn6.getText().toString());
    ado.insertar(guardarnombre);

        });

       btnborrar.setOnClickListener(v->{
           borrarequipos();
           cargarequipo();
       });

    btn.setOnClickListener(v->{

   if(comprobar()){
       Controlador_AlertDialog conta = new Controlador_AlertDialog();
       conta.mostraralerta(this);
   }
    });

   }

    private void listaequipos() {

    for(int q=0;q<nombrecitos.size();q++){
        String poknom = nombrecitos.get(q);
        for(int p=0;p<objpokemon.size();p++){
            if(objpokemon.get(q).getName().equals(poknom)){

                equipolocal.add(q,objpokemon.get(q));
                equipolocal.remove(q+1);
                }
            }
        }
    }

    private void borrarequipos() {
        //equipolocal.ensureCapacity(7);
        equipolocal.add(new Pokemon(1000,"Pokemon1","tipo","0","0","0","0","0","0"));
        equipolocal.add(new Pokemon(1001,"Pokemon2","tipo","0","0","0","0","0","0"));
        equipolocal.add(new Pokemon(1002,"Pokemon3","tipo","0","0","0","0","0","0"));
        equipolocal.add(new Pokemon(1003,"Pokemon4","tipo","0","0","0","0","0","0"));
        equipolocal.add(new Pokemon(1004,"Pokemon5","tipo","0","0","0","0","0","0"));
        equipolocal.add(new Pokemon(1005,"Pokemon6","tipo","0","0","0","0","0","0"));

    }

    public void cargarequipo(){

        pkmn1.setText(equipolocal.get(0).getName());
        pkmn2.setText(equipolocal.get(1).getName());
        pkmn3.setText(equipolocal.get(2).getName());
        pkmn4.setText(equipolocal.get(3).getName());
        pkmn5.setText(equipolocal.get(4).getName());
        pkmn6.setText(equipolocal.get(5).getName());
   }

    private void mensaje(String ms){
       Toast.makeText(this, ms, Toast.LENGTH_SHORT).show();
   }

    private boolean comprobar() {

              if(comprobarseleccion(rb1)){seleccionado.equals(pkmn1.getText().toString());posicion = 1;}
        else  if(comprobarseleccion(rb2)){seleccionado.equals(pkmn2.getText().toString());posicion = 2;}
        else  if(comprobarseleccion(rb3)){seleccionado.equals(pkmn3.getText().toString());posicion = 3;}
        else  if(comprobarseleccion(rb4)){seleccionado.equals(pkmn4.getText().toString());posicion = 4;}
        else  if(comprobarseleccion(rb5)){seleccionado.equals(pkmn5.getText().toString());posicion = 5;}
        else  if(comprobarseleccion(rb6)){seleccionado.equals(pkmn6.getText().toString());posicion = 6;}
        else{
            mensaje(getString(R.string.noseleccion));
            return false;
              }
        return true;
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



   }

}