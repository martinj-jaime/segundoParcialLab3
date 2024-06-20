import com.fasterxml.jackson.annotation.JsonProperty;
import model.Paciente;

import java.util.ArrayList;
import java.util.List;

public class ListaDeSanosYSospechosos {

    @JsonProperty("sanos")
    private List<Paciente> sanos = new ArrayList<>();
    @JsonProperty("aislados")
    private List<Paciente> aislados = new ArrayList<>();


    // region Getters & Setters
    public List<Paciente> getSanos() {
        return sanos;
    }

    public void setSanos(List<Paciente> sanos) {
        this.sanos = sanos;
    }

    public List<Paciente> getAislados() {
        return aislados;
    }

    public void setAislados(List<Paciente> aislados) {
        this.aislados = aislados;
    }
    // endregion

    public void agregarSano(Paciente paciente) {
        sanos.add(paciente);
    }

    public void agregarAislado(Paciente paciente) {
        aislados.add(paciente);
    }

}
