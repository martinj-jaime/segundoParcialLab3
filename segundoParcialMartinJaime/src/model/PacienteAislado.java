package model;

public class PacienteAislado {
    private Integer kit;
    private Double temperatura;
    private String barrio;

    public PacienteAislado(Integer kit, Double temperatura, String barrio) {
        this.kit = kit;
        this.temperatura = temperatura;
        this.barrio = barrio;
    }

    // region Getters & Setters
    public Integer getKit() {
        return kit;
    }

    public void setKit(Integer kit) {
        this.kit = kit;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }
    // endregion
}
