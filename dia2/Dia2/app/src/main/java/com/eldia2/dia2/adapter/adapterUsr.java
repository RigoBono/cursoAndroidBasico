package com.eldia2.dia2.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.eldia2.dia2.R;
import com.eldia2.dia2.model.usuario;

import java.util.Vector;

/**
 * Created by rigobono on 13/12/16.
 */

public class adapterUsr extends RecyclerView.Adapter<adapterUsr.UsuarioViewHolder>{

    Vector<usuario> listaUsuarios;

    @Override
    public UsuarioViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.tarjeta_usuario,parent,false);
        UsuarioViewHolder usr=new UsuarioViewHolder(v);
        return usr;
    }

    @Override
    public void onBindViewHolder(UsuarioViewHolder holder, int position) {
        holder.imagen.setImageResource(listaUsuarios.elementAt(position).getImagenRes());
        holder.nombre.setText(listaUsuarios.elementAt(position).getNombre());
        holder.edad.setText(Integer.toString(listaUsuarios.elementAt(position).getEdad()));
        holder.escuela.setText(listaUsuarios.elementAt(position).getEscuela());
        
    }

    @Override
    public int getItemCount() {
        return listaUsuarios.size();
    }

    public class UsuarioViewHolder extends RecyclerView.ViewHolder{
        ImageView imagen;
        TextView nombre;
        TextView edad;
        TextView escuela;
        public UsuarioViewHolder(View itemView) {
            super(itemView);
            imagen=(ImageView)itemView.findViewById(R.id.imagen);
            nombre=(TextView)itemView.findViewById(R.id.nombre);
            edad=(TextView)itemView.findViewById(R.id.edad);
            escuela=(TextView)itemView.findViewById(R.id.escuela);
        }
    }
}
