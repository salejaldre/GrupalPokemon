package com.example.grupalpokemon.Controladores;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grupalpokemon.R;
import com.example.grupalpokemon.Vistas.Datos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Adaptador_Lista_Equipos extends RecyclerView.Adapter<Adaptador_Lista_Equipos.ViewHolder>{

    List<String> todosequipos = new ArrayList<>();

    public Adaptador_Lista_Equipos(List<String> todosequipos) {
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
        holder.nombre.setText(todosequipos.get(0));
        holder.type.setText(todosequipos.get(1));

        holder.itemView.setOnClickListener(v->{
            Intent intent = new Intent(v.getContext(), Datos.class);
            intent.putExtra("posicion", position);
            v.getContext().startActivity(intent);
        });
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
