package com.eldia3.pagina2;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.eldia3.pagina2.modelo.usuario;
import com.eldia3.pagina2.util.imagen;

import org.w3c.dom.Text;

public class tarjeta_presentacion extends AppCompatActivity {

    ImageView imagenPerfil;
    TextView nombre;
    TextView telefono;
    TextView edad;
    TextView escuela;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarjeta_presentacion);

        imagenPerfil=(ImageView)findViewById(R.id.imagenperfil);
        nombre=(TextView)findViewById(R.id.nombre);
        telefono=(TextView)findViewById(R.id.telefono);
        edad=(TextView)findViewById(R.id.edad);
        escuela=(TextView)findViewById(R.id.escuela);

        Bundle bundle=getIntent().getExtras();
        int idUsuario=bundle.getInt("id");

        usuario usr=usuario.findById(usuario.class,idUsuario);

        nombre.setText(usr.getNombre());
        telefono.setText(usr.getTelefono());
        edad.setText(Integer.toString(usr.getEdad()));
        escuela.setText(usr.getEscuela());



        Bitmap imagendec= imagen.getBitmap(usr.getFotoPerfil());
        imagenPerfil.setImageBitmap(imagendec);



    }
}
