package com.example.grupalpokemon.BBDD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper_Pokemon extends SQLiteOpenHelper {
    public DBHelper_Pokemon(@Nullable Context context) {
        super(context, "bbdd_pokemon.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS pokemon (id INTEGER PRIMARY KEY, name TEXT, type1 TEXT," +
                "type2 TEXT,hp TEXT,attack TEXT, defense TEXT, spattack TEXT, spdefense TEXT, speed TEXT , url TEXT,urlpokedex TEXT,urlshiny TEXT,naturaleza TEXT)");

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS equipo (usuario TEXT PRIMARY KEY , pokemon1 TEXT, ataques1 TEXT, " +
                "habilidad1 TEXT, naturaleza1 TEXT, pokemon2 TEXT, ataques2 TEXT, habilidad2 TEXT, naturaleza2 TEXT, pokemon3 TEXT, ataques3 TEXT, " +
                "habilidad3 TEXT,naturaleza3 TEXT, pokemon4 TEXT, ataques4, habilidad4 TEXT, naturaleza4 TEXT, pokemon5 TEXT, ataques5 TEXT, " +
                "habilidad5 TEXT, naturaleza5 TEXT, pokemon6 TEXT, ataques6 TEXT, habilidad6 TEXT, naturaleza6 TEXT,faccion TEXT)");

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS usuarios (usuario TEXT PRIMARY KEY , password TEXT,faccion TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
