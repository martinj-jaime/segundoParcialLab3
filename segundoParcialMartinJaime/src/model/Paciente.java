package model;

public class Paciente extends Persona implements Comparable {

    private String barrio;
    private String ocupacion;

    private Integer numeroDeKit;

    public Paciente() {
        super();
    }

    public Paciente(String dni, String nombre, String apellido, Integer edad, String barrio, String ocupacion) {
        super(dni, nombre, apellido, edad);
        this.barrio = barrio;
        this.ocupacion = ocupacion;
    }


    // region Getters & Setters
    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public Integer getNumeroDeKit() {
        return numeroDeKit;
    }

    public void setNumeroDeKit(Integer numeroDeKit) {
        this.numeroDeKit = numeroDeKit;
    }


    /// TODO
    @Override
    public int compareTo(Object o) {
        return 0;
    }
    // endregion

    @Override
    public String toString() {
        return String.format("%s barrio: %s, ocupacion: %s, numeroDeKit: %d ", super.toString(), this.getBarrio(), this.getOcupacion(), this.getNumeroDeKit());
    }
}
