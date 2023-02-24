package com.example.grupalpokemon.Controladores;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grupalpokemon.Modelos.EquipoModelo;
import com.example.grupalpokemon.Modelos.Pokemon;
import com.example.grupalpokemon.R;
import com.example.grupalpokemon.Vistas.Datos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Adaptador_Lista_Equipos extends RecyclerView.Adapter<Adaptador_Lista_Equipos.ViewHolder>{

    List<EquipoModelo> todosequipos = new ArrayList<>();

    public Adaptador_Lista_Equipos(List<EquipoModelo> todosequipos) {
        this.todosequipos = todosequipos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View vista = inflater.inflate(R.layout.lista_layout, parent, false);

        return new Adaptador_Lista_Equipos.ViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nombre.setText(todosequipos.get(position).getUser().getUser());
        holder.type.setText(todosequipos.get(position).getPokemon1().getName());

        holder.itemView.setOnClickListener(v->{

            AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
            builder.setTitle("Equipo seleccionado");
            LayoutInflater inflater = LayoutInflater.from(v.getContext());

            View vista = inflater.inflate(R.layout.datosequiposelected, null);
            builder.setView(vista);

            TextView txtpokeunoequiposelected = vista.findViewById(R.id.txtpokeunoequiselected);
            TextView txtpokedosequiposelected = vista.findViewById(R.id.txtpokedosequiselected);
            TextView txtpoketresequiposelected = vista.findViewById(R.id.txtpoketresequiselected2);
            TextView txtpokecuatroequiposelected = vista.findViewById(R.id.txtpokecuatroequiselected);
            TextView txtpokecincoequiposelected = vista.findViewById(R.id.txtpokecincoequiselected3);
            TextView txtpokeseisequiposelected = vista.findViewById(R.id.txtpokeseisequiselected3);

            txtpokeunoequiposelected.setText(todosequipos.get(position).getPokemon1().getName());
            txtpokedosequiposelected.setText(todosequipos.get(position).getPokemon2().getName());
            txtpoketresequiposelected.setText(todosequipos.get(position).getPokemon3().getName());
            txtpokecuatroequiposelected.setText(todosequipos.get(position).getPokemon4().getName());
            txtpokecincoequiposelected.setText(todosequipos.get(position).getPokemon5().getName());
            txtpokeseisequiposelected.setText(todosequipos.get(position).getPokemon6().getName());

            txtpokeunoequiposelected.setOnClickListener(v2->{
                intentos(v2.getContext(),todosequipos.get(position).getPokemon1());
            });

            txtpokedosequiposelected.setOnClickListener(v2->{
                intentos(v2.getContext(),todosequipos.get(position).getPokemon2());
            });

            txtpoketresequiposelected.setOnClickListener(v2->{
                intentos(v2.getContext(),todosequipos.get(position).getPokemon3());
            });

            txtpokecuatroequiposelected.setOnClickListener(v2->{
                intentos(v2.getContext(),todosequipos.get(position).getPokemon4());
            });

            txtpokecincoequiposelected.setOnClickListener(v2->{
                intentos(v2.getContext(),todosequipos.get(position).getPokemon5());
            });

            txtpokeseisequiposelected.setOnClickListener(v2->{
                intentos(v2.getContext(),todosequipos.get(position).getPokemon6());
            });

            builder.show();
        });
    }

    private void intentos(Context context, Pokemon pokemon){

        Intent intent = new Intent(context, Datos.class);
        intent.putExtra("pokemon",pokemon);
        intent.putExtra("ruta",1);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return todosequipos.size() ;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView nombre;
        TextView type;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.txtnombre);
            type = itemView.findViewById(R.id.txttype);
        }
    }
}
