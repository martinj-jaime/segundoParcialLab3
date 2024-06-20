package model;

import java.util.Objects;

public class Persona {
    private String dni;
    private String nombre;
    private String apellido;
    private Integer edad;

    public Persona() {

    }

    public Persona(String dni, String nombre, String apellido, Integer edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    // region Getters & Setters
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    // endregion

    @Override
    public String toString() {
        return String.format("(%s) dni: %s, nombre: %s, apellido: %s, edad: %d", this.getClass().getSimpleName(), this.getDni(), this.getNombre(), this.getApellido(), this.getEdad());
    }


    @Override
    public int hashCode() {
        return Objects.hashCode(dni);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof Persona)) return false;
        Persona p = (Persona) obj;
        return p.getDni().equals(this.getDni());
    }

}
