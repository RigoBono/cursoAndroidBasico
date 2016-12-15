package com.eldia4.archivos;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    Button creaArchivos;
    Button leerArchivos;
    TextView contenido;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checapermisos();

        creaArchivos=(Button)findViewById(R.id.creaArchivos);
        leerArchivos=(Button)findViewById(R.id.leerArchivos);
        contenido=(TextView) findViewById(R.id.contenido);

        creaArchivos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                escribeArchivo();
            }
        });


        leerArchivos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                leerArchivo();
            }
        });
    }






    public void checapermisos()
    {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED  &&

                ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED
                )
        {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE},
                    1);
            return;
        }
    }


    public void escribeArchivo(){
        try
        {
            File ruta_sd = Environment.getExternalStorageDirectory();

            File f = new File(ruta_sd.getAbsolutePath(), "prueba_sd.txt");

            OutputStreamWriter fout =
                    new OutputStreamWriter(
                            new FileOutputStream(f));

            fout.write("Texto de prueba.");
            fout.close();

            Toast.makeText(MainActivity.this,"Mensaje escrito correctamente",Toast.LENGTH_SHORT).show();

        }
        catch (Exception ex)
        {
            Log.e("Ficheros", "Error al escribir fichero a tarjeta SD");
        }
    }

    public void leerArchivo(){
        try
        {
            File ruta_sd = Environment.getExternalStorageDirectory();
            File f = new File(ruta_sd.getAbsolutePath(), "prueba_sd.txt");
            BufferedReader fin = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            String texto = fin.readLine();
            contenido.setText(texto);
            fin.close();

            Toast.makeText(MainActivity.this,"Lectura correcta",Toast.LENGTH_SHORT).show();
        }
        catch (Exception ex)
        {
            Log.e("Ficheros", "Error al leer fichero desde tarjeta SD");
        }
    }


}
