package com.eldia1.holamundo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }


    public void muestraMensaje(View v){
        Toast.makeText(Main2Activity.this,"Octocat",Toast.LENGTH_SHORT).show();
    }


    public void muestraMensaje1(View v){
        Toast.makeText(Main2Activity.this,"tux",Toast.LENGTH_SHORT).show();
    }

    public void muestraMensaje2(View v){
        Toast.makeText(Main2Activity.this," tux 2",Toast.LENGTH_SHORT).show();
    }

    public void muestraMensaje3(View v){
        Toast.makeText(Main2Activity.this,"tux 3",Toast.LENGTH_SHORT).show();
    }
}
