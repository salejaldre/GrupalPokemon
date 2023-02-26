package com.example.grupalpokemon.Controladores;

import static com.example.grupalpokemon.Controladores.Comunes.colores;
import static com.example.grupalpokemon.Controladores.Comunes.intentos;
import static com.example.grupalpokemon.Controladores.Comunes.mensaje;
import static com.example.grupalpokemon.Controladores.Controlador_Equipo.cerrarboton;
import static com.example.grupalpokemon.Controladores.Controlador_Equipo.comprobarspiner;
import static com.example.grupalpokemon.Controladores.Controlador_Equipo.mostrarequipolabels;
import static com.example.grupalpokemon.Vistas.Equipo.*;
import static com.example.grupalpokemon.Controladores.Comunes.pintar;
import static com.example.grupalpokemon.Controladores.Controlador_Equipo.comprobarequipocompleto;
import static com.example.grupalpokemon.Controladores.Controlador_Equipo.rellenarspinerhabilidad;
import static com.example.grupalpokemon.Json.JsonMovimientos.movimientos;
import static com.example.grupalpokemon.Vistas.MainActivity.pokemonlist;
import static com.example.grupalpokemon.Vistas.Pantalla_principal.equipolocal;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.grupalpokemon.Imagenes.Imagenes;
import com.example.grupalpokemon.Modelos.EquipoModelo;
import com.example.grupalpokemon.Modelos.Pokemon;
import com.example.grupalpokemon.R;
import com.example.grupalpokemon.Sonidos.Sonidos;
import com.example.grupalpokemon.Vistas.Datos;

import java.util.ArrayList;
import java.util.List;

public class Controlador_AlertDialogs extends AppCompatActivity {

    public static void mostraralertaequipo(Context context, android.app.AlertDialog.Builder alerta, LayoutInflater inflater, int position, List<EquipoModelo> todosequipos){
        View vista = inflater.inflate(R.layout.datosequipo_layout, null);
        alerta.setView(vista);
        TextView txtpokeunoequiposelected = vista.findViewById(R.id.txtPrimerPokemon);
        TextView txtpokedosequiposelected = vista.findViewById(R.id.txtSegundoPokemon);
        TextView txtpoketresequiposelected = vista.findViewById(R.id.txtTercerPokemon);
        TextView txtpokecuatroequiposelected = vista.findViewById(R.id.txtCuartoPokemon);
        TextView txtpokecincoequiposelected = vista.findViewById(R.id.txtQuintoPokemon);
        TextView txtpokeseisequiposelected = vista.findViewById(R.id.txtSextoPokemon);
        TextView jefe = vista.findViewById(R.id.txtJefeEquipo);

        ImageView foto1 = vista.findViewById(R.id.imgPrimerPokemon);
        ImageView foto2 = vista.findViewById(R.id.imgSegundoPokemon);
        ImageView foto3 = vista.findViewById(R.id.imgTercerPokemon);
        ImageView foto4 = vista.findViewById(R.id.imgCuartoPokemon);
        ImageView foto5 = vista.findViewById(R.id.imgQuintoPokemon);
        ImageView foto6 = vista.findViewById(R.id.imgSextoPokemon);

        Imagenes.mostrarImagen(foto1,todosequipos.get(position).getPokemon1().getUrl());
        Imagenes.mostrarImagen(foto2,todosequipos.get(position).getPokemon2().getUrl());
        Imagenes.mostrarImagen(foto3,todosequipos.get(position).getPokemon3().getUrl());
        Imagenes.mostrarImagen(foto4,todosequipos.get(position).getPokemon4().getUrl());
        Imagenes.mostrarImagen(foto5,todosequipos.get(position).getPokemon5().getUrl());
        Imagenes.mostrarImagen(foto6,todosequipos.get(position).getPokemon6().getUrl());
        txtpokeunoequiposelected.setText(todosequipos.get(position).getPokemon1().getName());
        txtpokedosequiposelected.setText(todosequipos.get(position).getPokemon2().getName());
        txtpoketresequiposelected.setText(todosequipos.get(position).getPokemon3().getName());
        txtpokecuatroequiposelected.setText(todosequipos.get(position).getPokemon4().getName());
        txtpokecincoequiposelected.setText(todosequipos.get(position).getPokemon5().getName());
        txtpokeseisequiposelected.setText(todosequipos.get(position).getPokemon6().getName());
        jefe.setText(todosequipos.get(position).getUser().getUser());

        txtpokeunoequiposelected.setOnClickListener(v2->{
            intentos(v2.getContext(),todosequipos.get(position).getPokemon1(),1, Datos.class);
        });

        txtpokedosequiposelected.setOnClickListener(v2->{
            intentos(v2.getContext(),todosequipos.get(position).getPokemon2(),1, Datos.class);
        });

        txtpoketresequiposelected.setOnClickListener(v2->{
            intentos(v2.getContext(),todosequipos.get(position).getPokemon3(),1, Datos.class);
        });

        txtpokecuatroequiposelected.setOnClickListener(v2->{
            intentos(v2.getContext(),todosequipos.get(position).getPokemon4(),1, Datos.class);
        });

        txtpokecincoequiposelected.setOnClickListener(v2->{
            intentos(v2.getContext(),todosequipos.get(position).getPokemon5(),1, Datos.class);
        });

        txtpokeseisequiposelected.setOnClickListener(v2->{
            intentos(v2.getContext(),todosequipos.get(position).getPokemon6(),1, Datos.class);
        });

        alerta.show();

    }

    public static void mostraralertaAnadir(Context context, android.app.AlertDialog alerta, LayoutInflater layoutInflater) {

        EditText nombre;
        Spinner spinnatura;
        Spinner spinhabilidad;
        ImageView btaceptar;
        ImageView btatras;

        View  vista = layoutInflater.inflate(R.layout.editarequipo_layout, null);

        nombre = vista.findViewById(R.id.camponombre);
        spinnatura = vista.findViewById(R.id.spinnaturalezas);
        spinhabilidad = vista.findViewById(R.id.spinhabilidad);
        btaceptar = vista.findViewById(R.id.btacepa);
        btatras = vista.findViewById(R.id.btatrasa);

        nombre.setText(pokemonseleccionado.getName());

        rellenarspinerhabilidad(spinhabilidad);

        btaceptar.setOnClickListener(v->{

            comprobarAlerta(nombre, spinnatura, spinhabilidad,alerta);

        });

        finalalerta(alerta,vista,btatras);
    }

    public static void mostraralertaMovs(Context context, AlertDialog alerta, LayoutInflater layoutInflater){

        View vista = layoutInflater.inflate(R.layout.movimientos, null);

        Spinner mov1;
        Spinner mov2;
        Spinner mov3;
        Spinner mov4;
        ImageView ima;
        ImageView btacep;
        ImageView btatras;
        TextView tipe1, tipe2;
        ArrayList<String> movimientosnombre = new ArrayList<>();

        mov1 = vista.findViewById(R.id.mov1);
        mov2 = vista.findViewById(R.id.mov2);
        mov3 = vista.findViewById(R.id.mov3);
        mov4 = vista.findViewById(R.id.mov4);
        ima = vista.findViewById(R.id.imgsel);
        tipe1 = vista.findViewById(R.id.tipo1);
        tipe2 = vista.findViewById(R.id.tipo2);
        btacep = vista.findViewById(R.id.btacepa2);
        btatras = vista.findViewById(R.id.btatrasa2);

        Imagenes.mostrarImagen(ima, pokemonseleccionado.getUrl());
        tipe1.setText(pokemonseleccionado.getType1());
        pintar(tipe1,colores(tipe1.getText().toString()));
        if (!pokemonseleccionado.getType2().equals("null")) {
            tipe2.setVisibility(View.VISIBLE);
            tipe2.setText(pokemonseleccionado.getType2());
            pintar(tipe2,colores(tipe2.getText().toString()));
        } else {
            tipe2.setVisibility(View.INVISIBLE);
        }

        movimientosnombre.add("Movimiento");
        for (int q = 0; q < movimientos.size(); q++) {
            if (movimientos.get(q).getType().equals(pokemonseleccionado.getType1())
                    || movimientos.get(q).getType().equals(pokemonseleccionado.getType2())) {
                movimientosnombre.add(movimientos.get(q).getName());
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                context, android.R.layout.simple_spinner_item, movimientosnombre);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mov1.setAdapter(adapter);
        mov2.setAdapter(adapter);
        mov3.setAdapter(adapter);
        mov4.setAdapter(adapter);

        btacep.setOnClickListener(v->{
            comprobarAlertados(pokemonseleccionado, mov1, mov2, mov3, mov4,alerta);
            equipolocal.set(posicion, pokemonseleccionado);

        });

        finalalerta(alerta,vista,btatras);
    }

    private static void finalalerta(android.app.AlertDialog alerta, View vista,ImageView bt){
        bt.setOnClickListener(v->{
            alerta.dismiss();
        });
        alerta.setView(vista);
        alerta.show();
        comprobarequipocompleto(impok1,impok2,impok3,impok4,impok5,impok6,0);

    }

    public static void comprobarAlerta(EditText campo, Spinner spin,Spinner spinh,AlertDialog alerta) {
        String nombre = campo.getText().toString();
        if(!nombre.trim().equals("")){

            for(int q=0;q<pokemonlist.size();q++){
                if(nombre.equals(pokemonlist.get(q).getName())){

                    if(spin.getSelectedItemPosition()!=0&&spinh.getSelectedItemPosition()!=0){

                        Sonidos.crearsonido(campo.getContext(),"nuevo");
                        equipolocal.set(posicion,pokemonlist.get(q));
                        equipolocal.get(posicion).setMovimientos("");
                        equipolocal.get(posicion).setNaturaleza(spin.getSelectedItem().toString());
                        equipolocal.get(posicion).setHabilidad(spinh.getSelectedItem().toString());


                        mostrarequipolabels(pkmn1, pkmn2, pkmn3, pkmn4, pkmn5, pkmn6, img1, img2, img3, img4, img5, img6,
                                impok1,impok2,impok3,impok4,impok5,impok6);
                        comprobarequipocompleto(impok1,impok2,impok3,impok4,impok5,impok6,0);
                        cerrarboton(btnmovs,true);
                        alerta.dismiss();
                        break;

                    }else{mensaje(campo.getContext().getString(R.string.campovacio), campo.getContext());}

                }else if(q == pokemonlist.size())mensaje(campo.getContext().getString(R.string.noencontrado),campo.getContext());
            }
        }
    }

    public static void comprobarAlertados(Pokemon pk, Spinner mov1, Spinner mov2, Spinner mov3, Spinner mov4,AlertDialog alerta) {

        if(comprobarspiner(mov1)&&comprobarspiner(mov2)&&comprobarspiner(mov3)&&comprobarspiner(mov4)){

            pk.setMovimientos(
                    mov1.getSelectedItem().toString()+";"+
                            mov2.getSelectedItem().toString()+";"+
                            mov3.getSelectedItem().toString()+";"+
                            mov4.getSelectedItem().toString()+";");
            alerta.dismiss();
        }else {
            mensaje(mov1.getContext().getString(R.string.campovacio), mov1.getContext());

        }
        comprobarequipocompleto(impok1,impok2,impok3,impok4,impok5,impok6,0);

    }

}