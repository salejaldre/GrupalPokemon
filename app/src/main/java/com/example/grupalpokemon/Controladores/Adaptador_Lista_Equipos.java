package com.example.grupalpokemon.Controladores;

import static com.example.grupalpokemon.Controladores.Comunes.colores;
import static com.example.grupalpokemon.Controladores.Comunes.pintar;
import static com.example.grupalpokemon.Controladores.Controlador_AlertDialogs.mostraralertaequipo;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grupalpokemon.Modelos.EquipoModelo;
import com.example.grupalpokemon.R;

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
        holder.faccion.setText(todosequipos.get(position).getUser().getFaccion());
        pintar(holder.faccion,colores(todosequipos.get(position).getUser().getFaccion()));
        holder.itemView.setOnClickListener(v->{

            AlertDialog.Builder alerta = new AlertDialog.Builder(v.getContext());
            LayoutInflater inflater = LayoutInflater.from(v.getContext());

            mostraralertaequipo(v.getContext(),alerta,inflater,position,todosequipos);

        });
    }

    @Override
    public int getItemCount() {
        return todosequipos.size() ;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView nombre;
        TextView faccion;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.txtnombre);
            faccion = itemView.findViewById(R.id.txttype);
        }
    }
}
