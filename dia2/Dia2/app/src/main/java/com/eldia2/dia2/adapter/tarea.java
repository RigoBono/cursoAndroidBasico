package com.eldia2.dia2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.eldia2.dia2.R;

import java.util.Vector;

/**
 * Created by rigobono on 13/12/16.
 */

public class tarea  extends  RecyclerView.Adapter<tarea.TareaViewHolder>{

    Vector<String> tareas;
    Context context;

    public void setContext(Context context){
        this.context=context;
    }

    public void setTareas(Vector<String> tareas){
        this.tareas=tareas;
    }

    @Override
    public TareaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_tarea,parent,false);
        TareaViewHolder vh=new TareaViewHolder(v);
        return  vh;
    }

    @Override
    public void onBindViewHolder(TareaViewHolder holder, final int position) {
            holder.tarea.setText(tareas.elementAt(position));

            holder.tarea.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context,"Diste click en el elemento número "+Integer.toString(position),Toast.LENGTH_SHORT).show();
                }
            });
    }

    @Override
    public int getItemCount() {
        return tareas.size();
    }

    public class TareaViewHolder extends RecyclerView.ViewHolder{

        TextView tarea;
        public TareaViewHolder(View itemView) {
            super(itemView);
            tarea=(TextView)itemView.findViewById(R.id.tarea);
        }
    }
}
