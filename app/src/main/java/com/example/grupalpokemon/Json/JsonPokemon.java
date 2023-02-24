package com.example.grupalpokemon.Json;

import android.os.AsyncTask;

import com.example.grupalpokemon.Modelos.Pokemon;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class JsonPokemon extends AsyncTask<String, Void, String> {

    private DownloadJSONCallback callback;

    public static List<Pokemon> objpokemon = new ArrayList<>();

    public JsonPokemon(DownloadJSONCallback callback) {
        this.callback = callback;
    }

    @Override
    protected String doInBackground(String... params) {
        try {
            URL url = new URL(params[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream stream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            return builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public interface DownloadJSONCallback {
        void onDownloadJSONComplete(String result);
    }

    @Override
    protected void onPostExecute(String result) {
        // aquí puede procesar el resultado (result) que es el archivo JSON descargado
        callback.onDownloadJSONComplete(result);

        Gson gson = new Gson();
        //Guardar el json entero
        JsonArray jsonObject = gson.fromJson(result, JsonArray.class);

        //añadir todos los datos de result en una lista
        JsonArray lista = jsonObject.getAsJsonArray();

        //Guarda en un arraylist de tipo JsonObject todos los results
        List<JsonObject> objeto = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            objeto.add((JsonObject) lista.get(i));
        }

        //Guardar todos los datos del JSON en variables y añadirlas a un objeto de nuestra clase

        List<JsonObject> names = new ArrayList<>();
        List<JsonObject> bases = new ArrayList<>();
        List<JsonArray> types = new ArrayList<>();
        for (int p = 0; p < objeto.size(); p++) {
            names.add((JsonObject) objeto.get(p).get("name"));
            bases.add((JsonObject) objeto.get(p).get("base"));
            types.add((JsonArray) objeto.get(p).get("type"));

            if (types.get(p).size() == 1) {
                objpokemon.add(new Pokemon(Integer.parseInt(String.valueOf(objeto.get(p).get("id"))),
                        String.valueOf(names.get(p).get("english")), String.valueOf(types.get(p).get(0)),
                        String.valueOf(bases.get(p).get("HP")), String.valueOf(bases.get(p).get("Attack")),
                        String.valueOf(bases.get(p).get("Defense")), String.valueOf(bases.get(p).get("Sp. Attack")),
                        String.valueOf(bases.get(p).get("Sp. Defense")), String.valueOf(bases.get(p).get("Speed")),
                        String.valueOf(objeto.get(p).get("url")),String.valueOf(objeto.get(p).get("urlpokedex")),
                        String.valueOf(objeto.get(p).get("urlshiny")),"","",""));
            } else if (types.get(p).size() == 2) {
                objpokemon.add(new Pokemon(Integer.parseInt(String.valueOf(objeto.get(p).get("id"))),
                        String.valueOf(names.get(p).get("english")),String.valueOf(types.get(p).get(0)),
                        String.valueOf(types.get(p).get(1)), String.valueOf(bases.get(p).get("HP")),
                        String.valueOf(bases.get(p).get("Attack")), String.valueOf(bases.get(p).get("Defense")),
                        String.valueOf(bases.get(p).get("Sp. Attack")),String.valueOf(bases.get(p).get("Sp. Defense")),
                        String.valueOf(bases.get(p).get("Speed")),String.valueOf(objeto.get(p).get("url")),
                        String.valueOf(objeto.get(p).get("urlpokedex")),String.valueOf(objeto.get(p).get("urlshiny")),
                        "","",""));
            }

        }
    }
}

