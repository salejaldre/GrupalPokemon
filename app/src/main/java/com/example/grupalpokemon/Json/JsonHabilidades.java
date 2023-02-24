package com.example.grupalpokemon.Json;

import android.os.AsyncTask;

import com.example.grupalpokemon.Modelos.Habilidades;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class JsonHabilidades extends AsyncTask<String, Void, String> {

    private DownloadJSONCallback callback;

    public static List<Habilidades> habilidadeslist = new ArrayList<>();

    public JsonHabilidades(DownloadJSONCallback callback) {
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
        void onDownloadJSONHabilidadesComplete(String result);
    }

    @Override
    protected void onPostExecute(String result) {
        // aquí puede procesar el resultado (result) que es el archivo JSON descargado
        callback.onDownloadJSONHabilidadesComplete(result);

        Gson gson = new Gson();
        //Guardar el json entero
        JsonArray jsonObject = gson.fromJson(result, JsonArray.class);

        //JsonElement jsonElement = jsonObject;

        //añadir todos los datos de result en una lista
        JsonArray lista = jsonObject.getAsJsonArray();

        //Guarda en un arraylist de tipo JsonObject todos los results
        List<JsonObject> objeto = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            objeto.add((JsonObject) lista.get(i));
        }

        //Guardar todos los datos del JSON en variables y añadirlas a un objeto de nuestra clase


        List<JsonArray> abilities = new ArrayList<>();
        List<JsonElement> elementsabilities = new ArrayList<>();

        for (int p = 0; p < objeto.size(); p++) {
            abilities.add((JsonArray) objeto.get(p).get("ability"));
            for(int i = 0; i < 85; i++){
                elementsabilities.add(abilities.get(0).get(i));
                habilidadeslist.add(new Habilidades(String.valueOf(elementsabilities.get(i)).replace("\"", "")));
            }

        }
    }
}
