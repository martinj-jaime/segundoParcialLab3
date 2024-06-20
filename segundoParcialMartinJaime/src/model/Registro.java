package model;

public class Registro {
    private String dni;
    private Double temperatura;

    public Registro(String dni, Double temperatura) {
        this.dni = dni;
        this.temperatura = temperatura;
    }

    // region Gettres & Setters
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }
    // endregion


    @Override
    public String toString() {
        return String.format("(%s) dni: %s, temperatura: %f", this.getClass().getSimpleName(), this.getDni(), this.getTemperatura());
    }
}
