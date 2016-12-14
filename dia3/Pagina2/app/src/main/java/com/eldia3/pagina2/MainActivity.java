package com.eldia3.pagina2;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.eldia3.pagina2.modelo.usuario;
import com.eldia3.pagina2.util.imagen;
import com.orm.query.Condition;
import com.orm.query.Select;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_CAMERA=1;
    Button botonVerPresentacion;
    Button botonTomarFoto;
    EditText nombreEdt;
    EditText telefonoEdt;
    EditText edadEdt;
    EditText escuelaEdt;

    usuario usr;


    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == REQUEST_CAMERA && resultCode == Activity.RESULT_OK){
            Bundle bundle= data.getExtras();
            Bitmap imagenResultado= (Bitmap) bundle.get("data");
            usr.setFotoPerfil(imagen.toBase64(imagenResultado));
            botonVerPresentacion.setVisibility(View.VISIBLE);
        }
    }



    public void checapermisos()
    {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED &&

                ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED)

        {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.CAMERA},
                    1);
            return;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checapermisos();

        usr=new usuario();
        nombreEdt=(EditText)findViewById(R.id.nombreEdt);
        telefonoEdt=(EditText)findViewById(R.id.telefonoEdt);
        botonVerPresentacion=(Button)findViewById(R.id.verPresentacion);
        botonTomarFoto=(Button)findViewById(R.id.botonFoto);
        edadEdt=(EditText)findViewById(R.id.edadEdt);
        escuelaEdt=(EditText)findViewById(R.id.escuelaEdt);

        botonTomarFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tomaFoto();
            }
        });

        botonVerPresentacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verPresentacion();
            }
        });

    }

    public void verPresentacion(){
        Intent intent=new Intent(MainActivity.this,tarjeta_presentacion.class);

        usr.setNombre(nombreEdt.getText().toString());
        usr.setTelefono(telefonoEdt.getText().toString());
        usr.setEdad(Integer.parseInt(edadEdt.getText().toString()));
        usr.setEscuela(escuelaEdt.getText().toString());
        usr.save();

        intent.putExtra("id",usr.getId().intValue());


        startActivity(intent);

    }


    public void tomaFoto(){
        Intent tomaF=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(tomaF,REQUEST_CAMERA);
    }
}
