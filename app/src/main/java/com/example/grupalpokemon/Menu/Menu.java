package com.example.grupalpokemon.Menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.grupalpokemon.Controladores.Comunes;
import com.example.grupalpokemon.Modelos.Pokemon;
import com.example.grupalpokemon.R;
import com.example.grupalpokemon.Vistas.Listado;
import com.example.grupalpokemon.Vistas.Pantalla_principal;

import java.util.ArrayList;

public class Menu extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menugeneral, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.menuprincipal) {
            Intent intent = new Intent(this, Pantalla_principal.class);
            startActivity(intent);

        } else if (item.getItemId() == R.id.filtrar) {
            AlertDialog builder = new AlertDialog.Builder(this).create();
            LayoutInflater inflater = getLayoutInflater();
            View vista = inflater.inflate(R.layout.filtrar, null);
            builder.setView(vista);

            builder.setTitle("Filtrar Pokemon");
            EditText et = vista.findViewById(R.id.txtfiltrar);
            Spinner spin = vista.findViewById(R.id.spnfiltrar);
            ImageView bt = vista.findViewById(R.id.btfiltrar);

            bt.setOnClickListener(v -> {
                if (comprobarflitrar(et, spin)) {

                    Intent intent = new Intent(this, Listado.class);
                    intent.putExtra("listafiltrada", listafiltrada);
                    startActivity(intent);

                    builder.dismiss();
                }
            });
            builder.show();
        }
        return super.onOptionsItemSelected(item);
    }

    private boolean comprobarflitrar(EditText txt, Spinner sp) {

        if (txt.getText().toString().trim().equals("") && sp.getSelectedItemPosition() == 0) {
            Comunes.mensaje(getString(R.string.filtrarerror), this);
            return false;
        } else {
            listafiltrada = new ArrayList<>();
            if (sp.getSelectedItemPosition() != 0 && !txt.getText().toString().trim().equals("")) {

                listafiltrada = comprobarspiner(sp);
                compruebanombre(txt, true);

            } else if (sp.getSelectedItemPosition() != 0) {
                listafiltrada = comprobarspiner(sp);

            } else {
                compruebanombre(txt, false);
            }
        }
        return true;
    }

    private ArrayList<Pokemon> compruebanombre(EditText txt, boolean comp) {

        if (comp) {
            ArrayList<Pokemon> lista = (ArrayList<Pokemon>) listafiltrada.clone();
            limpiar();
            for (int q = 0; q < lista.size(); q++) {
                if (lista.get(q).getName().toLowerCase().contains(txt.getText().toString().toLowerCase())) {

                    listafiltrada.add(lista.get(q));
                }
            }

        } else {
            limpiar();
            for (int q = 0; q < pokemonlist.size(); q++) {

                if (pokemonlist.get(q).getName().toLowerCase().contains(txt.getText().toString().toLowerCase())) {
                    listafiltrada.add(pokemonlist.get(q));
                }
            }
        }
        return listafiltrada;
    }

    private void limpiar() {

        listafiltrada.clear();
    }

    private ArrayList<Pokemon> comprobarspiner(Spinner sp) {
        limpiar();
        for (int q = 0; q < pokemonlist.size(); q++) {

            if (pokemonlist.get(q).getType2().equals(sp.getSelectedItem().toString())
                    || pokemonlist.get(q).getType1().equals(sp.getSelectedItem().toString())) {
                listafiltrada.add(pokemonlist.get(q));
            }
        }
        return listafiltrada;
    }
}