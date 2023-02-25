package com.example.grupalpokemon.Vistas;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.widget.EditText;
import android.widget.ImageView;

import com.example.grupalpokemon.BBDD.Equipos_ADO;
import com.example.grupalpokemon.Menu.Menu;
import com.example.grupalpokemon.R;

import java.util.ArrayList;
import java.util.List;

public class Showdown extends Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showdown);

        EditText multilineequipo = findViewById(R.id.multilineequipo);
        ImageView btnshowdown = findViewById(R.id.imgacceder);

        List<String> equipolocal = new ArrayList<>();
        Equipos_ADO equipos_ado = new Equipos_ADO(this);

        for (int q = 0; q < 24; q++) {equipolocal.add(q,"");}
        equipolocal = equipos_ado.getEquipolocal(equipolocal);

        String movspoke1;
        String movspoke2;
        String movspoke3;
        String movspoke4;
        String movspoke5;
        String movspoke6;

        movspoke1 = equipolocal.get(1);
        movspoke2 = equipolocal.get(5);
        movspoke3 = equipolocal.get(9);
        movspoke4 = equipolocal.get(13);
        movspoke5 = equipolocal.get(17);
        movspoke6 = equipolocal.get(21);

        String[] movimientos1 = movspoke1.split(";");
        String[] movimientos2 = movspoke2.split(";");
        String[] movimientos3 = movspoke3.split(";");
        String[] movimientos4 = movspoke4.split(";");
        String[] movimientos5 = movspoke5.split(";");
        String[] movimientos6 = movspoke6.split(";");

        String mov1 = movimientos1[0];
        String mov2 = movimientos1[1];
        String mov3 = movimientos1[2];
        String mov4 = movimientos1[3];


        String mov21 = movimientos2[0];
        String mov22 = movimientos2[1];
        String mov23 = movimientos2[2];
        String mov24 = movimientos2[3];

        String mov31 = movimientos3[0];
        String mov32 = movimientos3[1];
        String mov33 = movimientos3[2];
        String mov34 = movimientos3[3];


        String mov41 = movimientos4[0];
        String mov42 = movimientos4[1];
        String mov43 = movimientos4[2];
        String mov44 = movimientos4[3];


        String mov51 = movimientos5[0];
        String mov52 = movimientos5[1];
        String mov53 = movimientos5[2];
        String mov54 = movimientos5[3];


        String mov61 = movimientos6[0];
        String mov62 = movimientos6[1];
        String mov63 = movimientos6[2];
        String mov64 = movimientos6[3];

        Context con = multilineequipo.getContext();

        multilineequipo.setText(equipolocal.get(0) + con.getString(R.string.barraene) +
                "Ability: " + equipolocal.get(2) + con.getString(R.string.barraene) +
                "EVs: 252 SpA / 4 SpD / 252 Spe" + con.getString(R.string.barraene) +
                equipolocal.get(3) + con.getString(R.string.barraene) +
                "- " + mov1 + con.getString(R.string.barraene) +
                "- " + mov2 + con.getString(R.string.barraene) +
                "- " + mov3 + con.getString(R.string.barraene) +
                "- " + mov4 + con.getString(R.string.barraene) + con.getString(R.string.barraene) +
                equipolocal.get(4) + con.getString(R.string.barraene) +
                "Ability: " + equipolocal.get(6) + con.getString(R.string.barraene) +
                "EVs: 252 SpA / 4 SpD / 252 Spe" + con.getString(R.string.barraene) +
                equipolocal.get(7) + con.getString(R.string.barraene) +
                "- " + mov21 + con.getString(R.string.barraene) +
                "- " + mov22 + con.getString(R.string.barraene) +
                "- " + mov23 + con.getString(R.string.barraene) +
                "- " + mov24 + con.getString(R.string.barraene) +  con.getString(R.string.barraene) +
                equipolocal.get(8) + con.getString(R.string.barraene) +
                "Ability: " + equipolocal.get(10) + con.getString(R.string.barraene) +
                "EVs: 252 SpA / 4 SpD / 252 Spe" + con.getString(R.string.barraene) +
                equipolocal.get(11) + con.getString(R.string.barraene) +
                "- " + mov31 + con.getString(R.string.barraene) +
                "- " + mov32 + con.getString(R.string.barraene) +
                "- " + mov33 + con.getString(R.string.barraene) +
                "- " + mov34 + con.getString(R.string.barraene) + con.getString(R.string.barraene) +
                equipolocal.get(12) + con.getString(R.string.barraene) +
                "Ability: " + equipolocal.get(14) + con.getString(R.string.barraene) +
                "EVs: 252 SpA / 4 SpD / 252 Spe" + con.getString(R.string.barraene) +
                equipolocal.get(15) + con.getString(R.string.barraene) +
                "- " + mov41 + con.getString(R.string.barraene) +
                "- " + mov42 + con.getString(R.string.barraene) +
                "- " + mov43 + con.getString(R.string.barraene) +
                "- " + mov44 + con.getString(R.string.barraene) + con.getString(R.string.barraene) +
                equipolocal.get(16) + con.getString(R.string.barraene) +
                "Ability: " + equipolocal.get(18) + con.getString(R.string.barraene) +
                "EVs: 252 SpA / 4 SpD / 252 Spe" + con.getString(R.string.barraene) +
                equipolocal.get(19) + con.getString(R.string.barraene) +
                "- " + mov51 + con.getString(R.string.barraene) +
                "- " + mov52 + con.getString(R.string.barraene) +
                "- " + mov53 + con.getString(R.string.barraene) +
                "- " + mov54 + con.getString(R.string.barraene) + con.getString(R.string.barraene) +
                equipolocal.get(20) + con.getString(R.string.barraene) +
                "Ability: " + equipolocal.get(22) + con.getString(R.string.barraene) +
                "EVs: 252 SpA / 4 SpD / 252 Spe" + con.getString(R.string.barraene) +
                equipolocal.get(23) + con.getString(R.string.barraene) +
                "- " + mov61 + con.getString(R.string.barraene) +
                "- " + mov62 + con.getString(R.string.barraene) +
                "- " + mov63 + con.getString(R.string.barraene) +
                "- " + mov64 + con.getString(R.string.barraene));

        multilineequipo.setKeyListener(null);

        btnshowdown.setOnClickListener(v->{
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.pokemonshowdown.com/teambuilder"));
            startActivity(browserIntent);
        });
    }
}
