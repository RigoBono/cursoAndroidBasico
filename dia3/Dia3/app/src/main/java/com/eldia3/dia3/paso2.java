package com.eldia3.dia3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class paso2 extends AppCompatActivity {

    
    TextView nombre;
    TextView telefono;
    TextView direccion;
    
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paso2);
        Bundle bundle=getIntent().getExtras();
        nombre = (TextView) findViewById(R.id.nombreEdt);
        nombre.setText(bundle.getString("nombre"));

        telefono = (TextView) findViewById(R.id.telefonoEdt);
        telefono.setText(bundle.getString("telefono"));

        direccion = (TextView) findViewById(R.id.direccionEdt);
        direccion.setText(bundle.getString("direccion"));


    }
}
