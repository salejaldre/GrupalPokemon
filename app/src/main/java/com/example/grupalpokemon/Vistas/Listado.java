package com.example.grupalpokemon.Vistas;

import static com.example.grupalpokemon.Vistas.MainActivity.pokemonlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.grupalpokemon.BBDD.Pokemon_ADO;
import com.example.grupalpokemon.Controladores.Adaptador_Listado;
import com.example.grupalpokemon.Menu.Menu;
import com.example.grupalpokemon.Modelos.Pokemon;
import com.example.grupalpokemon.R;

import java.util.ArrayList;
import java.util.List;

public class Listado extends Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        RecyclerView recyclerView;
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();

        if(intent.hasExtra("listafiltrada")){
            recyclerView.setAdapter(new Adaptador_Listado((List<Pokemon>) intent.getSerializableExtra("listafiltrada")));
        } else{
            recyclerView.setAdapter(new Adaptador_Listado(pokemonlist));
        }


    }
}