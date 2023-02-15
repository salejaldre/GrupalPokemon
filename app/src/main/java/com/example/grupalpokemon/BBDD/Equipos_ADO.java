package com.example.grupalpokemon.BBDD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.grupalpokemon.Modelos.EquipoModelo;
import com.example.grupalpokemon.Modelos.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class Equipos_ADO implements AutoCloseable{


    private DBHelper_Pokemon helper;
    private SQLiteDatabase db;
    private Context context;

    
    public static List<EquipoModelo> equipoLocal = new ArrayList<>();


    public Equipos_ADO(Context context){
        helper = new DBHelper_Pokemon(context);
        db = helper.getReadableDatabase();
    }

    public void dropTableEquipos(){
        db.execSQL("DROP TABLE IF EXISTS equipo");

        db.execSQL("CREATE TABLE equipo (id INTEGER PRIMARY KEY AUTOINCREMENT, pokemon1 TEXT, " +
                "pokemon2 TEXT, pokemon3 TEXT, pokemon4 TEXT, pokemon5 TEXT, " +
                "pokemon6 TEXT)");
    }

    public void insertar(List<String> equipopokemon){

        ContentValues valores = new ContentValues();

        valores.put("pokemon1",equipopokemon.get(0));
        valores.put("pokemon2",equipopokemon.get(1));
        valores.put("pokemon3",equipopokemon.get(2));
        valores.put("pokemon4",equipopokemon.get(3));
        valores.put("pokemon5",equipopokemon.get(4));
        valores.put("pokemon6",equipopokemon.get(5));
        

        helper.getWritableDatabase().insert("equipo",null,valores);
    }

    public List<String> getAll(){
        String sql = "SELECT * FROM equipo";
        Cursor cursor = db.rawQuery(sql,null);

        equipoLocal.clear();

        List<String> pokeEquipo = new ArrayList<>();
        
        while(cursor.moveToNext()){

            pokeEquipo.set(0, cursor.getString(0));
            pokeEquipo.set(1, cursor.getString(1));
            pokeEquipo.set(2, cursor.getString(2));
            pokeEquipo.set(3, cursor.getString(3));
            pokeEquipo.set(4, cursor.getString(4));
            pokeEquipo.set(5, cursor.getString(5));

        }

        return pokeEquipo;
    }











    @Override
    public void close() throws Exception {

    }
}
