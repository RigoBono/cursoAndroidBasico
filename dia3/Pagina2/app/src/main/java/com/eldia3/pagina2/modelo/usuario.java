package com.eldia3.pagina2.modelo;

import com.orm.SugarRecord;

/**
 * Created by rigobono on 14/12/16.
 */

public class usuario extends SugarRecord {
    String nombre="";
    String telefono="";
    String fotoPerfil="";

    public usuario() {
    }

    public usuario(String nombre, String telefono, String fotoPerfil) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.fotoPerfil = fotoPerfil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }
}
