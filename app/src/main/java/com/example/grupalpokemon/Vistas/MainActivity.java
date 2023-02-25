import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.example.grupalpokemon.BBDD.Equipos_ADO;
import com.example.grupalpokemon.BBDD.Pokemon_ADO;
import com.example.grupalpokemon.Json.JsonPokemon;
import com.example.grupalpokemon.Json.JsonHabilidades;
import com.example.grupalpokemon.Json.JsonMovimientos;
import com.example.grupalpokemon.Modelos.EquipoModelo;
import com.example.grupalpokemon.Modelos.Pokemon;
import com.example.grupalpokemon.R;
import com.example.grupalpokemon.Vistas.Login;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements JsonPokemon.DownloadJSONCallback, JsonMovimientos.DownloadJSONCallback, JsonHabilidades.DownloadJSONCallback{
    public static ArrayList<Pokemon> pokemonlist;
    public static ArrayList<Pokemon> listafiltrada;
    //  public static ArrayList<EquipoModelo> listadeequipos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listafiltrada = new ArrayList<>();
        JsonPokemon downloadJson = new JsonPokemon(this);
        JsonMovimientos downloadJsonDos = new JsonMovimientos(this);
        JsonHabilidades downloadabilities = new JsonHabilidades(this);

        downloadJsonDos.execute("https://raw.githubusercontent.com/fanzeyi/pokemon.json/master/moves.json");
        downloadabilities.execute("https://raw.githubusercontent.com/diurvi15/TrabajoGrupalBlackjack/main/soloabilitiesarray.json");
        downloadJson.execute("https://raw.githubusercontent.com/diurvi15/TrabajoGrupalBlackjack/main/pokedexconshinys.json");

    }

    @Override
    public void onDownloadJSONComplete(String result) {
        Handler handler = new Handler(Looper.myLooper());
        handler.postDelayed(()-> {

            Pokemon_ADO pado = new Pokemon_ADO(this);
            //  pado.insertAll(); //PA CUANDO SE JODA LA BBDD

            cargarbasesdatos(pado);

            if(pokemonlist.size()==0){
                pado.insertAll();
                cargarbasesdatos(pado);
            }

            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
        }, 500);

    }
    private void cargarbasesdatos(Pokemon_ADO pado){

        pokemonlist = (ArrayList<Pokemon>) pado.getAll();
    }

    @Override
    public void onDownloadJSONAbilityComplete(String result) {

    }

    @Override
    public void onDownloadJSONDosComplete(String result) {

    }