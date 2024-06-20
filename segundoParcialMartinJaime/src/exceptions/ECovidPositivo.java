package exceptions;

public class ECovidPositivo extends Exception {
    private Double temperatura;

    public ECovidPositivo(String message) {
        super(message);
    }

    public ECovidPositivo(String message, Double temperatura) {
        super(message);
        this.temperatura = temperatura;

    }

    public Double getTemperatura() {
        return this.temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }
}
