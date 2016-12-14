package com.eldia3.pagina2.modelo;

import com.orm.SugarRecord;

/**
 * Created by rigobono on 14/12/16.
 */

public class usuario extends SugarRecord {
    String nombre="";
    String telefono="";
    String fotoPerfil="";
    int edad=0;
    String escuela;

    public usuario() {
    }

    public usuario(String nombre, String telefono, String fotoPerfil, int edad, String escuela) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.fotoPerfil = fotoPerfil;
        this.edad = edad;
        this.escuela = escuela;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
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
