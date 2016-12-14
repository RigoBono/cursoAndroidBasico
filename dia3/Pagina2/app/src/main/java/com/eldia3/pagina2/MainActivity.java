package com.eldia3.pagina2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

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
    }


    public void tomaFoto(){
        Intent tomaF=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(tomaF,REQUEST_CAMERA);
    }
}
