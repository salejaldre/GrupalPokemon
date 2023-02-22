package com.example.grupalpokemon.Vistas;


import static com.example.grupalpokemon.Vistas.MainActivity.pokemonlist;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.grupalpokemon.BBDD.Equipos_ADO;
import com.example.grupalpokemon.Controladores.Adaptador_Lista_Equipos;
import com.example.grupalpokemon.Menu.Menu;
import com.example.grupalpokemon.Modelos.EquipoModelo;
import com.example.grupalpokemon.Modelos.Pokemon;
import com.example.grupalpokemon.Modelos.Usuario;
import com.example.grupalpokemon.R;

import java.util.ArrayList;
import java.util.List;

public class Lista_Equipos extends Menu {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_equipos);

        RecyclerView recyclerView;
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Equipos_ADO ado = new Equipos_ADO(this);

        List<String> equiposlist = ado.getEquiposOtros();
        ArrayList<EquipoModelo> todoslosequipos= crearobjeto((ArrayList) equiposlist);
        recyclerView.setAdapter(new Adaptador_Lista_Equipos(todoslosequipos));

    }

    private ArrayList<EquipoModelo> crearobjeto(ArrayList equipolista) {

        ArrayList<EquipoModelo> todoslosequipos = new ArrayList<>();

         do{
                Usuario user = new Usuario((String) equipolista.get(0),"","");
                Pokemon poke1 =comprobarpokemon((String) equipolista.get(1));
                Pokemon poke2 =comprobarpokemon((String) equipolista.get(2));
                Pokemon poke3 =comprobarpokemon((String) equipolista.get(3));
                Pokemon poke4 =comprobarpokemon((String) equipolista.get(4));
                Pokemon poke5 =comprobarpokemon((String) equipolista.get(5));
                Pokemon poke6 =comprobarpokemon((String) equipolista.get(6));
                todoslosequipos.add(new EquipoModelo(user,poke1,poke2,poke3,poke4,poke5,poke6));
                borrarequipo(equipolista);

        } while(equipolista.size()!=0);

        return todoslosequipos;
    }


    private void borrarequipo(ArrayList equipolista) {
        for (int q = 0; q < 7; q++) {
        equipolista.remove(0);
        }

    }


    private Pokemon comprobarpokemon(String pkn) {
        for(int q = 0;q<pokemonlist.size();q++){
            if(pokemonlist.get(q).getName().equals(pkn)){
                return pokemonlist.get(q);
            }

    }
        return null;
    }


}




