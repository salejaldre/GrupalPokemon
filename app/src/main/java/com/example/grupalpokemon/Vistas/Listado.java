package com.example.grupalpokemon.Vistas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;

import com.example.grupalpokemon.BBDD.Pokemon_ADO;
import com.example.grupalpokemon.Controladores.Adaptador_Listado;
import com.example.grupalpokemon.Json.Json;
import com.example.grupalpokemon.Modelos.Pokemon;
import com.example.grupalpokemon.R;

import java.util.ArrayList;
import java.util.List;

public class Listado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        RecyclerView recyclerView;
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Pokemon_ADO ado = new Pokemon_ADO(this);

        List<Pokemon> pokemonlist = new ArrayList<>();
        pokemonlist= ado.getAll();

        recyclerView.setAdapter(new Adaptador_Listado(pokemonlist));
    }
}