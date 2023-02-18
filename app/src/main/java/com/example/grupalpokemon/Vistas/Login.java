package com.example.grupalpokemon.Vistas;

import static com.example.grupalpokemon.Controladores.Comunes.mensaje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.grupalpokemon.BBDD.Usuarios_ADO;
import com.example.grupalpokemon.Modelos.Usuario;
import com.example.grupalpokemon.R;

import java.util.ConcurrentModificationException;
import java.util.List;

public class Login extends AppCompatActivity {

    private EditText txtusuario;
    private EditText txtpass;
    private Button btnacceder;
    private Button btnregistrarse;

    private String user;
    private String pass;
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

        userado = new Usuarios_ADO(getApplicationContext());

        btnregistrarse.setOnClickListener(v->{

            user = txtusuario.getText().toString().trim();
            pass = txtpass.getText().toString().trim();



            List<Usuario> todosusers = userado.getAll();

            if (user.equals("") || pass.equals("")){
                mensaje(getString(R.string.campovaciologin), this);
            } else {

                int hola = 0;
                boolean pez = true;

                if(todosusers.size() == 0){
                    objusuario(user, pass);
                } else {

                    do {
                        if (user.equals(todosusers.get(hola).getUser())) {
                            mensaje(getString(R.string.usuariyaregistrado), this);
                            pez = false;
                            break;
                        }

                        hola++;
                    } while (hola < todosusers.size());
                }

                if(pez == true){

                    objusuario(user, pass);
                    mensaje(getString(R.string.registradologin), this);

                    txtusuario.setText("");
                    txtpass.setText("");
                }
            }
        });

        btnacceder.setOnClickListener(v-> {

            user = txtusuario.getText().toString().trim();
            pass = txtpass.getText().toString().trim();

            if (user.equals("") || pass.equals("")) {
                mensaje(getString(R.string.campovaciologin), this);
            } else{

            if (userado.validarLogin(user, pass)) {
                txtusuario.setText("");
                txtpass.setText("");
                useractual = new Usuario(user, pass);
                Intent intent = new Intent(getApplicationContext(), Pantalla_Principal.class);
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
    private static void objusuario(String user, String pass){
        datosuser = new Usuario(user, pass);
        userado.insertar(datosuser);
    }
}