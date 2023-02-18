package com.example.grupalpokemon.Controladores;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grupalpokemon.Json.Json;
import com.example.grupalpokemon.Modelos.Pokemon;
import com.example.grupalpokemon.R;
import com.example.grupalpokemon.Vistas.Datos;

import java.io.Serializable;
import java.util.List;

public class Adaptador_Listado extends RecyclerView.Adapter<Adaptador_Listado.ViewHolder> {
    List<Pokemon> lista;

    public Adaptador_Listado(List<Pokemon> listita) {
        this.lista = listita;
    }

    private static CardView card;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View vista = inflater.inflate(R.layout.lista_layout, parent, false);

        card = vista.findViewById(R.id.card);

        return new ViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

            /*if (position % 2 == 0) {
                card.setCardBackgroundColor(Color.RED);
            } else {
                card.setCardBackgroundColor(Color.BLUE);
            }*/

        holder.nombre.setText(lista.get(position).getName());
        if(lista.get(position).getType2().equals("null")){
            holder.type.setText(lista.get(position).getType1());
        } else {
            holder.type.setText(lista.get(position).getType1() + " " + lista.get(position).getType2());
        }

        holder.itemView.setOnClickListener(v->{
            Intent intent = new Intent(v.getContext(), Datos.class);
            intent.putExtra("posicion", position);
            intent.putExtra("array", (Serializable) lista);
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {return lista.size();}

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