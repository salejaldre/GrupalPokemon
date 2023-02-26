import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.example.grupalpokemon.BBDD.Pokemon_ADO;

import com.example.grupalpokemon.Json.JsonHabilidades;
import com.example.grupalpokemon.Json.JsonMovimientos;
import com.example.grupalpokemon.Json.JsonPokemon;
import com.example.grupalpokemon.Modelos.Pokemon;
import com.example.grupalpokemon.R;
import com.example.grupalpokemon.Sonidos.Sonidos;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements JsonPokemon.DownloadJSONCallback, JsonMovimientos.DownloadJSONCallback, JsonHabilidades.DownloadJSONCallback{
    public static ArrayList<Pokemon> pokemonlist;
    public static ArrayList<Pokemon> listafiltrada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listafiltrada = new ArrayList<>();
        JsonPokemon downloadpokedex = new JsonPokemon(this);
        JsonMovimientos downloadmovimientos = new JsonMovimientos(this);
        JsonHabilidades downloadhabilidades = new JsonHabilidades(this);
        Sonidos.crearsonidofondo(this);
        downloadmovimientos.execute("https://raw.githubusercontent.com/salejaldre/GrupalPokemon/main/jsonmovimientos.json");
        downloadhabilidades.execute("https://raw.githubusercontent.com/salejaldre/GrupalPokemon/main/jsonHabilidades.json");
        downloadpokedex.execute("https://raw.githubusercontent.com/salejaldre/GrupalPokemon/main/jsonPokedex.json");

    }

    @Override
    public void onDownloadJSONComplete(String result) {
        Handler handler = new Handler(Looper.myLooper());
        handler.postDelayed(()-> {

            Pokemon_ADO pado = new Pokemon_ADO(this);

            cargarbasesdatos(pado);

            if(pokemonlist.size()==0){
                pado.insertAll();
                cargarbasesdatos(pado);
            }

            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
        }, 1500);

    }
    private void cargarbasesdatos(Pokemon_ADO pado){

        pokemonlist = (ArrayList<Pokemon>) pado.getAll();
    }


    @Override
    public void onDownloadJSONHabilidadesComplete(String result) {

    }

    @Override
    public void onDownloadJSONMovimientosComplete(String result) {

    }
}