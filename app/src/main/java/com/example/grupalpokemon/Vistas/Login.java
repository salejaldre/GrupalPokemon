package com.example.grupalpokemon.Vistas;

import static com.example.grupalpokemon.Controladores.Comunes.mensaje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.grupalpokemon.Modelos.Usuario;
import com.example.grupalpokemon.R;

import java.util.List;

public class Login extends AppCompatActivity {

    private EditText txtusuario;
    private EditText txtpass;
    private Spinner spinfaccion;
    private ImageView btnacceder;
    private ImageView btnregistrarse;

    private String user;
    private String pass;
    private String faccion;
    private static Usuario datosuser;
    private static Usuarios_ADO userado;
    public static Usuario useractual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtusuario = findViewById(R.id.txtusuario);
        txtpass = findViewById(R.id.txtpass);
        btnacceder = findViewById(R.id.btnacceder);
        btnregistrarse = findViewById(R.id.btnregistrarse);
        spinfaccion = findViewById(R.id.spinerfaccion);

        userado = new Usuarios_ADO(getApplicationContext());
        useractual = new Usuario();
        btnregistrarse.setOnClickListener(v->{

            recogerdatos();


            List<Usuario> todosusers = userado.getAll();

            if (user.equals("") || pass.equals("")|| spinfaccion.getSelectedItemPosition()==0){
                mensaje(getString(R.string.campovaciologin), this);
            } else {

                int posicion = 0;
                boolean comprobarregistrar = true;

                if(todosusers.size() == 0){
                    faccion = spinfaccion.getSelectedItem().toString();
                    objusuario(user, pass,faccion);
                } else {

                    do {
                        if (user.equals(todosusers.get(posicion).getUser())) {
                            mensaje(getString(R.string.usuariyaregistrado), this);
                            comprobarregistrar = false;
                            break;
                        }

                        posicion++;
                    } while (posicion < todosusers.size());
                }

                if(comprobarregistrar == true){
                    faccion = spinfaccion.getSelectedItem().toString();
                    objusuario(user, pass,faccion);
                    mensaje(getString(R.string.registradologin), this);
                    limpiar();
                }
            }
        });

        btnacceder.setOnClickListener(v-> {

            recogerdatos();

            if (user.equals("") || pass.equals("")) {
                mensaje(getString(R.string.campovaciologin), this);
            } else{

                if (userado.validarLogin(user, pass)) {
                    limpiar();
                    useractual.setUser(user);
                    useractual = userado.getUno();
                    Intent intent = new Intent(getApplicationContext(), Pantalla_principal.class);
                    startActivity(intent);
                } else {
                    if (Usuarios_ADO.datosusuario.size() == 0) {
                        mensaje(getString(R.string.loginsindatos), this);

                    } else {
                        mensaje(getString(R.string.errorlogin), this);
                    }

                }
            }

        });

    }

    private void recogerdatos() {
        user = txtusuario.getText().toString().trim();
        pass = txtpass.getText().toString().trim();

    }

    private void limpiar() {
        spinfaccion.setSelection(0);
        txtusuario.setText("");
        txtpass.setText("");
    }


    private static void objusuario(String user, String pass,String faccion){
        datosuser = new Usuario(user, pass,faccion);
        userado.insertar(datosuser);
    }
}