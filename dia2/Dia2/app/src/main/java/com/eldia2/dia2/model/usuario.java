package com.eldia2.dia2.model;

/**
 * Created by rigobono on 13/12/16.
 */

public class usuario {
    String nombre;
    int edad;
    String escuela;

    public usuario(String nombre, int edad, String escuela) {
        this.nombre = nombre;
        this.edad = edad;
        this.escuela = escuela;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
}
