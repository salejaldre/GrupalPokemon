package com.example.grupalpokemon.Controladores;

import static com.example.grupalpokemon.Controladores.Comunes.colores;
import static com.example.grupalpokemon.Controladores.Comunes.compcampodos;
import static com.example.grupalpokemon.Controladores.Comunes.intentosdos;
import static com.example.grupalpokemon.Controladores.Comunes.pintar;
import static com.example.grupalpokemon.Vistas.MainActivity.listafiltrada;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grupalpokemon.Modelos.Pokemon;
import com.example.grupalpokemon.R;
import com.example.grupalpokemon.Vistas.Datos;

import java.util.List;

public class Adaptador_Listado extends RecyclerView.Adapter<Adaptador_Listado.ViewHolder> {
    List<Pokemon> lista;

    public Adaptador_Listado(List<Pokemon> listita) {
        this.lista = listita;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View vista = inflater.inflate(R.layout.lista_layout, parent, false);

        return new ViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.nombre.setText(lista.get(position).getName());
        holder.type.setText(lista.get(position).getType1());
        pintar(holder.type,colores(lista.get(position).getType1()));
        if(compcampodos(lista.get(position))){
            holder.type2.setText(lista.get(position).getType2());
            pintar(holder.type2,colores(lista.get(position).getType2()));
        } else {
            holder.type2.setText("");
        }

        holder.itemView.setOnClickListener(v->{
            if(lista.size() != listafiltrada.size()){
                intentosdos(v.getContext(),position,0,Datos.class);
            }else{
                intentosdos(v.getContext(),position,2,Datos.class);
            }
        });
    }

    @Override
    public int getItemCount() {return lista.size();}

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView nombre;
        TextView type;
        TextView type2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.txtnombre);
            type = itemView.findViewById(R.id.txttype);
            type2 = itemView.findViewById(R.id.txttype2);
        }
    }
}