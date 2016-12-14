package com.eldia3.dia3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class paso2 extends AppCompatActivity {

    TextView nombreParametro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paso2);
        Bundle bundle=getIntent().getExtras();
        nombreParametro = (TextView) findViewById(R.id.nombrePaso);
        nombreParametro.setText(bundle.getString("nombre"));


    }
}
