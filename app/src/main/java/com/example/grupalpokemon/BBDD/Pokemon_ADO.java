package com.example.grupalpokemon.BBDD;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.example.grupalpokemon.Json.JsonPokemon;
import com.example.grupalpokemon.Modelos.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class Pokemon_ADO implements AutoCloseable{

    private DBHelper_Pokemon helper;
    private SQLiteDatabase db;
    private Context context;

    public static List<Pokemon> datosPokemon = new ArrayList<>();


    public Pokemon_ADO(Context context){
        helper = new DBHelper_Pokemon(context);
        db = helper.getReadableDatabase();
    }

    public void insertar(Pokemon pokemon){
        ContentValues valores = new ContentValues();

        valores.put("id",pokemon.getId());
        valores.put("name",pokemon.getName().replace("\"", ""));
        valores.put("type1",pokemon.getType1().replace("\"", ""));
        if(pokemon.getType2()!=null) {
            valores.put("type2", pokemon.getType2().replace("\"", ""));
        }else{valores.put("type2","null");}
        valores.put("hp",pokemon.getHp().replace("\"", ""));
        valores.put("attack",pokemon.getAttack().replace("\"", ""));
        valores.put("defense",pokemon.getDefense().replace("\"", ""));
        valores.put("spattack",pokemon.getSpattack().replace("\"", ""));
        valores.put("spdefense",pokemon.getSpdefense().replace("\"", ""));
        valores.put("speed",pokemon.getSpeed().replace("\"", ""));
        valores.put("url",pokemon.getUrl().replace("\"", ""));
        valores.put("urlpokedex",pokemon.getUrlpokedex().replace("\"", ""));
        valores.put("urlshiny",pokemon.getUrlshiny().replace("\"", ""));


        helper.getWritableDatabase().insert("pokemon",null,valores);

    }

    public void insertAll(){
        DBHelper_Pokemon helperPokemon = new DBHelper_Pokemon(context);
        helperPokemon.onCreate(db);

        for (int i = 0; i < JsonPokemon.objpokemon.size(); i++) {
            insertar(JsonPokemon.objpokemon.get(i));
        }

    }

    public List<Pokemon> getAll(){
        //String sql = context.getString(R.string.consultaallpokemons);
        String sql = "SELECT * FROM pokemon";
        Cursor cursor = db.rawQuery(sql,null);

        datosPokemon.clear();
        if(cursor.moveToFirst()) {
            do {

                Pokemon poke = new Pokemon();

                poke.setId(cursor.getInt(0));
                poke.setName(cursor.getString(1));
                poke.setType1(cursor.getString(2));
                poke.setType2(cursor.getString(3));
                poke.setHp(cursor.getString(4));
                poke.setAttack(cursor.getString(5));
                poke.setDefense(cursor.getString(6));
                poke.setSpattack(cursor.getString(7));
                poke.setSpdefense(cursor.getString(8));
                poke.setSpeed(cursor.getString(9));
                poke.setUrl(cursor.getString(10));
                poke.setUrlpokedex(cursor.getString(11));
                poke.setUrlshiny(cursor.getString(12));


                datosPokemon.add(poke);
            }while (cursor.moveToNext());
        }


        return datosPokemon;
    }

    @Override
    public void close() throws Exception {

    }
}