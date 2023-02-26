package com.example.grupalpokemon.BBDD;
import static com.example.grupalpokemon.Vistas.Login.useractual;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.grupalpokemon.Modelos.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Usuarios_ADO {

    private DBHelper_Pokemon helper;
    private SQLiteDatabase db;
    Context contexta;

    public static List<Usuario> datosusuario = new ArrayList<>();

    public Usuarios_ADO(Context context) {
        helper = new DBHelper_Pokemon(context);
        db = helper.getReadableDatabase();
        contexta = context;
    }

    public void insertar(Usuario usuario) {
        ContentValues valores = new ContentValues();

        valores.put("usuario", usuario.getUser());
        valores.put("password", usuario.getPass());
        valores.put("faccion", usuario.getFaccion());

        helper.getWritableDatabase().insert("usuarios", null, valores);
    }

    public List<Usuario> getAll() {
        String sql = "SELECT * FROM usuarios";
        Cursor cursor = db.rawQuery(sql, null);

        datosusuario.clear();
        while (cursor.moveToNext()) {

            Usuario user = new Usuario();

            user.setUser(cursor.getString(0));
            user.setPass(cursor.getString(1));
            user.setFaccion(cursor.getString(2));

            datosusuario.add(user);
        }

        return datosusuario;
    }

    public Usuario getUno() {
        String sql = "SELECT * FROM usuarios WHERE usuario = '" + useractual.getUser() + "'";
        Cursor cursor = db.rawQuery(sql, null);


        Usuario user = new Usuario();
        if (cursor.moveToFirst()) {
            do {
                user.setUser(cursor.getString(0));
                user.setPass(cursor.getString(1));
                user.setFaccion(cursor.getString(2));
            } while (cursor.moveToNext());
        }

        return user;
    }

    public boolean validarLogin(String username, String password) {
        String sql = "SELECT usuario, password FROM usuarios";

        List<Usuario> datosusu = new ArrayList<>();

        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {

            do {
                Usuario usu = new Usuario();
                usu.setUser(cursor.getString(0));
                usu.setPass(cursor.getString(1));


                datosusu.add(usu);
                datosusuario = datosusu;
            } while (cursor.moveToNext());

        }

        if (datosusu.size() == 0) {
            return false;
        } else {
            for (int i = 0; i < datosusu.size(); i++) {
                if (datosusu.get(i).getUser().equals(username) && datosusu.get(i).getPass().equals(password)) {
                    return true;
                }
            }
            return false;
        }
    }
}