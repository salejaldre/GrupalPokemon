package com.example.grupalpokemon.BBDD;

import static com.example.grupalpokemon.Vistas.Login.useractual;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.grupalpokemon.Modelos.EquipoModelo;

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

    public void insertar(List<String> equipopokemon){

        ContentValues valores = new ContentValues();
        valores.put("usuario",equipopokemon.get(0));
        valores.put("pokemon1",equipopokemon.get(1));
        valores.put("ataques1",equipopokemon.get(2));
        valores.put("habilidad1",equipopokemon.get(3));
        valores.put("naturaleza1",equipopokemon.get(4));
        valores.put("pokemon2",equipopokemon.get(5));
        valores.put("ataques2",equipopokemon.get(6));
        valores.put("habilidad2",equipopokemon.get(7));
        valores.put("naturaleza2",equipopokemon.get(8));
        valores.put("pokemon3",equipopokemon.get(9));
        valores.put("ataques3",equipopokemon.get(10));
        valores.put("habilidad3",equipopokemon.get(11));
        valores.put("naturaleza3",equipopokemon.get(12));
        valores.put("pokemon4",equipopokemon.get(13));
        valores.put("ataques4",equipopokemon.get(14));
        valores.put("habilidad4",equipopokemon.get(15));
        valores.put("naturaleza4",equipopokemon.get(16));
        valores.put("pokemon5",equipopokemon.get(17));
        valores.put("ataques5",equipopokemon.get(18));
        valores.put("habilidad5",equipopokemon.get(19));
        valores.put("naturaleza5",equipopokemon.get(20));
        valores.put("pokemon6",equipopokemon.get(21));
        valores.put("ataques6",equipopokemon.get(22));
        valores.put("habilidad6",equipopokemon.get(23));
        valores.put("naturaleza6",equipopokemon.get(24));
        valores.put("faccion",equipopokemon.get(25));


        helper.getWritableDatabase().insert("equipo",null,valores);
    }

    public void update(List<String> equipopokemon){

        ContentValues valores = new ContentValues();
        valores.put("usuario",equipopokemon.get(0));
        valores.put("pokemon1",equipopokemon.get(1));
        valores.put("ataques1",equipopokemon.get(2));
        valores.put("habilidad1",equipopokemon.get(3));
        valores.put("naturaleza1",equipopokemon.get(4));
        valores.put("pokemon2",equipopokemon.get(5));
        valores.put("ataques2",equipopokemon.get(6));
        valores.put("habilidad2",equipopokemon.get(7));
        valores.put("naturaleza2",equipopokemon.get(8));
        valores.put("pokemon3",equipopokemon.get(9));
        valores.put("ataques3",equipopokemon.get(10));
        valores.put("habilidad3",equipopokemon.get(11));
        valores.put("naturaleza3",equipopokemon.get(12));
        valores.put("pokemon4",equipopokemon.get(13));
        valores.put("ataques4",equipopokemon.get(14));
        valores.put("habilidad4",equipopokemon.get(15));
        valores.put("naturaleza4",equipopokemon.get(16));
        valores.put("pokemon5",equipopokemon.get(17));
        valores.put("ataques5",equipopokemon.get(18));
        valores.put("habilidad5",equipopokemon.get(19));
        valores.put("naturaleza5",equipopokemon.get(20));
        valores.put("pokemon6",equipopokemon.get(21));
        valores.put("ataques6",equipopokemon.get(22));
        valores.put("habilidad6",equipopokemon.get(23));
        valores.put("naturaleza6",equipopokemon.get(24));
        valores.put("faccion",equipopokemon.get(25));

        helper.getWritableDatabase().update("equipo",valores,"usuario ='"+useractual.getUser()+"'",null );
    }


    public List<String> getEquipolocal(List<String> pokeEquipo){
        // String sql = context.getString(R.string.consultaallequipos);
        String sql = "SELECT * FROM equipo WHERE usuario ='"+ useractual.getUser()+"'";
        Cursor cursor = db.rawQuery(sql,null);

        if(cursor.moveToFirst()) {
            do{
                pokeEquipo.set(0, cursor.getString(1));
                pokeEquipo.set(1, cursor.getString(2));
                pokeEquipo.set(2, cursor.getString(3));
                pokeEquipo.set(3, cursor.getString(4));
                pokeEquipo.set(4, cursor.getString(5));
                pokeEquipo.set(5, cursor.getString(6));
                pokeEquipo.set(6, cursor.getString(7));
                pokeEquipo.set(7, cursor.getString(8));
                pokeEquipo.set(8, cursor.getString(9));
                pokeEquipo.set(9, cursor.getString(10));
                pokeEquipo.set(10, cursor.getString(11));
                pokeEquipo.set(11, cursor.getString(12));
                pokeEquipo.set(12, cursor.getString(13));
                pokeEquipo.set(13, cursor.getString(14));
                pokeEquipo.set(14, cursor.getString(15));
                pokeEquipo.set(15, cursor.getString(16));
                pokeEquipo.set(16, cursor.getString(17));
                pokeEquipo.set(17, cursor.getString(18));
                pokeEquipo.set(18, cursor.getString(19));
                pokeEquipo.set(19, cursor.getString(20));
                pokeEquipo.set(20, cursor.getString(21));
                pokeEquipo.set(21, cursor.getString(22));
                pokeEquipo.set(22, cursor.getString(23));
                pokeEquipo.set(23, cursor.getString(24));
            }
            while (cursor.moveToNext()) ;
        }
        return pokeEquipo;
    }

    public List<String> getEquiposOtros(){
        String sql = "SELECT * FROM equipo WHERE usuario <>'"+useractual.getUser()+"'";
        Cursor cursor = db.rawQuery(sql,null);

        List<String> pokeEquipo = new ArrayList<>();

        if(cursor.moveToFirst()) {
            do{

                pokeEquipo.add(0, cursor.getString(0));
                pokeEquipo.add(1, cursor.getString(1));
                pokeEquipo.add(2, cursor.getString(2));
                pokeEquipo.add(3, cursor.getString(3));
                pokeEquipo.add(4, cursor.getString(4));
                pokeEquipo.add(5, cursor.getString(5));
                pokeEquipo.add(6, cursor.getString(6));
                pokeEquipo.add(7, cursor.getString(7));
                pokeEquipo.add(8, cursor.getString(8));
                pokeEquipo.add(9, cursor.getString(9));
                pokeEquipo.add(10, cursor.getString(10));
                pokeEquipo.add(11, cursor.getString(11));
                pokeEquipo.add(12, cursor.getString(12));
                pokeEquipo.add(13, cursor.getString(13));
                pokeEquipo.add(14, cursor.getString(14));
                pokeEquipo.add(15, cursor.getString(15));
                pokeEquipo.add(16, cursor.getString(16));
                pokeEquipo.add(17, cursor.getString(17));
                pokeEquipo.add(18, cursor.getString(18));
                pokeEquipo.add(19, cursor.getString(19));
                pokeEquipo.add(20, cursor.getString(20));
                pokeEquipo.add(21, cursor.getString(21));
                pokeEquipo.add(22, cursor.getString(22));
                pokeEquipo.add(23, cursor.getString(23));
                pokeEquipo.add(24, cursor.getString(24));
                pokeEquipo.add(25, cursor.getString(25));
            }  while (cursor.moveToNext());

        }

        return pokeEquipo;
    }

    @Override
    public void close() throws Exception {

    }
}
