package com.eldia2.dia2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.eldia2.dia2.adapter.adapterUsr;
import com.eldia2.dia2.adapter.tarea;
import com.eldia2.dia2.model.usuario;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    RecyclerView listaDeTareas;
    RecyclerView listaeDeUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaDeTareas=(RecyclerView)findViewById(R.id.listaDeTareas);
        listaeDeUsuarios=(RecyclerView)findViewById(R.id.listaDeUsuarios); 

        Vector<String> misTareas=new Vector<String>();
        misTareas.add("Saludar");
        misTareas.add("Mover cabeza");
        misTareas.add("Avanzar");
        misTareas.add("Caminar");
        misTareas.add("Volar");
        misTareas.add("Programar");

        tarea tr=new tarea();
        tr.setTareas(misTareas);
        tr.setContext(MainActivity.this);

        LinearLayoutManager llm=new LinearLayoutManager(MainActivity.this);
        listaDeTareas.setLayoutManager(llm);
        listaDeTareas.setHasFixedSize(true);
        listaDeTareas.setItemViewCacheSize(5);
        listaDeTareas.setAdapter(tr);


        Vector<usuario> usuarios=new Vector<usuario>();
        usuarios.add(new usuario("Bono",50,"ALGUNA",R.drawable.bono));
        usuarios.add(new usuario("Larry page",50,"ALGUNA en EUA",R.drawable.larry_page));
        usuarios.add(new usuario("linus",50,"ALGUNA",R.drawable.linus));
        usuarios.add(new usuario("Richard",50,"ALGUNA",R.drawable.richard));


        LinearLayoutManager llm2=new LinearLayoutManager(MainActivity.this);
        adapterUsr usra=new  adapterUsr();
        usra.setListaUsuarios(usuarios);
        listaeDeUsuarios.setLayoutManager(llm2);
        listaeDeUsuarios.setHasFixedSize(true);
        listaeDeUsuarios.setItemViewCacheSize(5);
        listaeDeUsuarios.setAdapter(usra);



    }
}
