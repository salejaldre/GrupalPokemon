package com.example.grupalpokemon.Vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.grupalpokemon.R;

import java.util.concurrent.atomic.AtomicInteger;

public class Creditos_Oak extends AppCompatActivity {


    int pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creditos_oak);

        pos = 0;
        View constraint = findViewById(R.id.fondito);
        ImageView next = findViewById(R.id.oaksiguiente);
        TextView texto = findViewById(R.id.texto);
        texto.setText(getString(R.string.textouno));


        next.setOnClickListener(v->{
      if(pos==0){
          constraint.setBackgroundResource(R.drawable.oak2);
          texto.setText(getString(R.string.textodos));
      pos=1;}
      else if(pos ==1){
          constraint.setBackgroundResource(R.drawable.oak3);
          texto.setText(getString(R.string.textotres));
          pos=2;}
     else if(pos==2){
          Intent intent = new Intent(this,Pantalla_principal.class);
          startActivity(intent);
     }

        });

    }
}