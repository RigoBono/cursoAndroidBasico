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
import android.widget.ImageView;

import com.eldia3.pagina2.modelo.usuario;
import com.orm.query.Condition;
import com.orm.query.Select;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_CAMERA=1;

    ImageView imagen;
    Button boton;

    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == REQUEST_CAMERA && resultCode == Activity.RESULT_OK){
            Bundle bundle= data.getExtras();
            Bitmap imagenResultado= (Bitmap) bundle.get("data");
            imagen.setImageBitmap(imagenResultado);
        }

    }



    public void checapermisos()
    {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)

        {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE},
                    1);
            return;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagen=(ImageView)findViewById(R.id.imagen);
        boton=(Button)findViewById(R.id.boton);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tomaFoto();
            }
        });

        usuario usr=new usuario();
        usr.setNombre("Pablo");
        usr.setTelefono("3543453453");
        usr.save();

        usuario dataobten=usuario.findById(usuario.class,1);


        List<usuario> query= Select.from(usuario.class).
                where(Condition.prop("telefono").eq("3543453453")).list();

        for( usuario res:query){
            Log.i("PruebaSUGAR",res.getNombre()+ " "+res.getTelefono());

        }


    }


    public void tomaFoto(){
        Intent tomaF=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(tomaF,REQUEST_CAMERA);
    }
}
