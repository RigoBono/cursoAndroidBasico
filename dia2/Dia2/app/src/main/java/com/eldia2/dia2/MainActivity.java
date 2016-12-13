package com.eldia2.dia2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.eldia2.dia2.adapter.tarea;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    RecyclerView listaDeTareas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaDeTareas=(RecyclerView)findViewById(R.id.listaDeTareas);

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
    }
}
