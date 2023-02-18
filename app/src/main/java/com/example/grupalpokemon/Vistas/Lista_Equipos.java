package com.example.grupalpokemon.Vistas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.grupalpokemon.BBDD.Equipos_ADO;
import com.example.grupalpokemon.BBDD.Pokemon_ADO;
import com.example.grupalpokemon.Controladores.Adaptador_Listado;
import com.example.grupalpokemon.Modelos.EquipoModelo;
import com.example.grupalpokemon.Modelos.Pokemon;
import com.example.grupalpokemon.R;

import java.util.ArrayList;
import java.util.List;

public class Lista_Equipos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_equipos);



        RecyclerView recyclerView;
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Equipos_ADO ado = new Equipos_ADO(this);

        List<String> nombrepokemons = new ArrayList<>();
        List<Equipo> equipos = new ArrayList<>();
        nombrepokemons= ado.getEquiposOtros(
                //nombre del actual usuario
        );

        for(int q = 0;q<nombrepokemons.size();q++){
            if(nombrepokemons.get(q))

        }


        recyclerView.setAdapter(new Adaptador_Listado(pokemonlist));



    }
}