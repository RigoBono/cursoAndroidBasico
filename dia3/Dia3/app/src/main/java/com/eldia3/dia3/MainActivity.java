package com.eldia3.dia3;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText nombreEdt;
    EditText telefonoEdt;
    EditText direccionEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nombreEdt=(EditText)findViewById(R.id.nombreEdt);
        telefonoEdt=(EditText)findViewById(R.id.telefonoEdt);
        direccionEdt=(EditText)findViewById(R.id.direccionEdt);
        

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambiaPantalla();
            }
        });
    }

    public void cambiaPantalla(){
        Intent intento=new Intent(MainActivity.this,paso2.class);
        intento.putExtra("nombre",nombreEdt.getText().toString());
        intento.putExtra("telefono",telefonoEdt.getText().toString());
        intento.putExtra("direccion",direccionEdt.getText().toString());
        startActivity(intento);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
