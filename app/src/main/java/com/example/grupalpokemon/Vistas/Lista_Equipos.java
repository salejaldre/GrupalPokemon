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
        ArrayList<EquipoModelo> todoslosequipos = crearobjeto((ArrayList) equiposlist);
        recyclerView.setAdapter(new Adaptador_Lista_Equipos(todoslosequipos));

    }

    private ArrayList<EquipoModelo> crearobjeto(ArrayList equipolista) {

        ArrayList<EquipoModelo> todoslosequipos = new ArrayList<>();

        do{
            Usuario user = new Usuario(equipolista.get(0).toString(),"","");
            Pokemon poke1 =crearpokemonpornombre((String) equipolista.get(1));
            Pokemon poke2 =crearpokemonpornombre((String) equipolista.get(5));
            Pokemon poke3 =crearpokemonpornombre((String) equipolista.get(9));
            Pokemon poke4 =crearpokemonpornombre((String) equipolista.get(13));
            Pokemon poke5 =crearpokemonpornombre((String) equipolista.get(17));
            Pokemon poke6 =crearpokemonpornombre((String) equipolista.get(21));
            poke1.setMovimientos(equipolista.get(2).toString());
            poke2.setMovimientos(equipolista.get(6).toString());
            poke3.setMovimientos(equipolista.get(10).toString());
            poke4.setMovimientos(equipolista.get(14).toString());
            poke5.setMovimientos(equipolista.get(18).toString());
            poke6.setMovimientos(equipolista.get(22).toString());

            poke1.setHabilidad(equipolista.get(3).toString());
            poke2.setHabilidad(equipolista.get(7).toString());
            poke3.setHabilidad(equipolista.get(11).toString());
            poke4.setHabilidad(equipolista.get(15).toString());
            poke5.setHabilidad(equipolista.get(19).toString());
            poke6.setHabilidad(equipolista.get(23).toString());

            poke1.setNaturaleza(equipolista.get(4).toString());
            poke2.setNaturaleza(equipolista.get(8).toString());
            poke3.setNaturaleza(equipolista.get(12).toString());
            poke4.setNaturaleza(equipolista.get(16).toString());
            poke5.setNaturaleza(equipolista.get(20).toString());
            poke6.setNaturaleza(equipolista.get(24).toString());

            user.setFaccion(equipolista.get(25).toString());


            todoslosequipos.add(new EquipoModelo(user,poke1,String.valueOf(poke1.getMovimientos()), poke1.getHabilidad(), poke1.getNaturaleza(),
                    poke2, String.valueOf(poke2.getMovimientos()), poke2.getHabilidad(), poke2.getNaturaleza(),
                    poke3, String.valueOf(poke3.getMovimientos()), poke3.getHabilidad(), poke3.getNaturaleza(),
                    poke4, String.valueOf(poke4.getMovimientos()), poke4.getHabilidad(), poke4.getNaturaleza(),
                    poke5, String.valueOf(poke5.getMovimientos()), poke5.getHabilidad(), poke5.getNaturaleza(),
                    poke6, String.valueOf(poke6.getMovimientos()), poke6.getHabilidad(), poke6.getNaturaleza()));
           borrarequipo(equipolista);

        } while(equipolista.size()!=0);

        return todoslosequipos;
    }


    private void borrarequipo(ArrayList equipolista) {
        for (int q = 0; q < 26; q++) {
            equipolista.remove(0);
        }

    }

    private Pokemon crearpokemonpornombre(String pkn) {
        for(int q = 0;q<pokemonlist.size();q++){
            if(pokemonlist.get(q).getName().equals(pkn)){
                return pokemonlist.get(q);
            }

        }
        return null;
    }

}




