import static com.example.grupalpokemon.Controladores.Comunes.mensaje;
import static com.example.grupalpokemon.Controladores.Controlador_Equipo.arraystringlocal;
import static com.example.grupalpokemon.Controladores.Controlador_Equipo.comprobarequipocompleto;
import static com.example.grupalpokemon.Controladores.Controlador_Equipo.crearequipolocalvacio;
import static com.example.grupalpokemon.Controladores.Controlador_Equipo.rellenarequipolocal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.grupalpokemon.BBDD.Equipos_ADO;
import com.example.grupalpokemon.Modelos.Pokemon;
import com.example.grupalpokemon.R;
import com.example.grupalpokemon.Sonidos.Sonidos;
import com.example.grupalpokemon.Vistas.Creditos_Oak;
import com.example.grupalpokemon.Vistas.Equipo;
import com.example.grupalpokemon.Vistas.Lista_Equipos;
import com.example.grupalpokemon.Vistas.Listado;

import java.util.ArrayList;
import java.util.List;

public class Pantalla_principal extends AppCompatActivity {
    public static ArrayList<Pokemon> equipolocal;
    private List<String> equipolocalstrings;
    Equipos_ADO eado;
    public static ImageView btshow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal);
        Sonidos.crearsonidofondo(this);
        ImageView dummy = findViewById(R.id.dummy);
        ImageView bt1= findViewById(R.id.btlistapokemon);
        ImageView bt2= findViewById(R.id.btequipo);
        ImageView bt4= findViewById(R.id.btlistaequipo);
        ImageView bt3= findViewById(R.id.btnoak);
        btshow= findViewById(R.id.btshow);

        cargarequipolocal();

        clics(bt1, Listado.class);
        clics(bt3, Creditos_Oak.class);
        clics(bt2, Equipo.class);

        btshow.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.pokemonshowdown.com/teambuilder"));
            startActivity(browserIntent);
        });

        bt4.setOnClickListener(v->{
            Equipos_ADO eado = new Equipos_ADO(this);
            ArrayList<String> equipos = (ArrayList<String>) eado.getEquiposOtros();
            if( equipos.size()>0){
                intento(Lista_Equipos.class);
            }
            else{
                mensaje(getString(R.string.nohayequipo),this);
            }});

        comprobarequipocompleto(dummy,dummy,dummy,dummy,dummy,dummy,1);
    }

    private void cargarequipolocal(){

        eado= new Equipos_ADO(this);
        equipolocal = new ArrayList<>();
        crearequipolocalvacio();
        equipolocalstrings = arraystringlocal(eado);
        rellenarequipolocal(equipolocalstrings);
    }

    private void clics(ImageView bt,Class cla){

        bt.setOnClickListener(v->{

            intento(cla);
        });

    }

    private void intento(Class clase){

        Intent intent = new Intent(this,clase);
        startActivity(intent);
    }
}