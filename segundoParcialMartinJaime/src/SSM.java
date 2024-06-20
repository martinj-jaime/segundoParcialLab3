import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import exceptions.ECovidPositivo;
import exceptions.EElPacienteYaExistente;
import exceptions.ESinKitParaTestear;
import model.Paciente;
import model.Registro;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Random;

public class SSM {


    private Integer kitsParaTestear = 3;
    private FilaPacientes<Paciente> filaPacientes = new FilaPacientes<>();
    private Hashtable<Integer, Registro> tablaDeRegistros = new Hashtable<>();


    public void init() {
        agregarPaciente(new Paciente("111", "Martin", "Jaime", 20, "Barrio Pompeya", "Programador"));
        agregarPaciente(new Paciente("222", "Martin", "Jaime", 20, "Barrio Pompeya", "Programador"));
        // ya se sobrepasa la cantidad de kits disponible
        agregarPaciente(new Paciente("333", "Martin", "Jaime", 20, "Barrio Pompeya", "Programador"));
        agregarPaciente(new Paciente("333", "Martin", "Jaime", 20, "Barrio Pompeya", "Programador"));
        // paciente con dni repetido
        agregarPaciente(new Paciente("888", "Martin", "Jaime", 20, "Barrio Pompeya", "Programador"));
    }

    private Boolean validarKitsDisponibles() throws ESinKitParaTestear {
        if (this.getKitsParaTestear() == 0) {
            throw new ESinKitParaTestear("Sin kits para testear");
        }
        return true;
    }

    private void agregarPaciente(Paciente paciente) {
        try {
            if (validarKitsDisponibles()) {
                filaPacientes.agregarPaciente(paciente);
                this.setKitsParaTestear(this.getKitsParaTestear() - 1);
            }
        } catch (ESinKitParaTestear e) {
            System.out.println(e);
            System.out.println("Llegaron 5 nuevos kits para testear !");
            agregaMasKits(5);
        } catch (EElPacienteYaExistente e) {
            System.out.println(e);

        }
    }

    private void agregaMasKits(Integer nuevosKits) {
        if (nuevosKits > this.getKitsParaTestear()) {
            this.setKitsParaTestear(nuevosKits);
        }
    }


    public void mostrarFila() {
        for (Paciente p : filaPacientes.obtenerLista()) {
            System.out.println(p);
        }
    }

    // region Getters & Setters
    public Integer getKitsParaTestear() {
        return kitsParaTestear;
    }

    public void setKitsParaTestear(Integer kitsParaTestear) {
        this.kitsParaTestear = kitsParaTestear;
    }
    // endregion

    public void testearPacientes() {
        for (Paciente paciente : filaPacientes.obtenerLista()) {
            testear(paciente);
        }
    }

    public void aislarPacientes() {
        for (Paciente paciente : filaPacientes.obtenerLista()) {
            aislar(paciente);
        }
    }

    private Integer generateRandomTemperatura(Integer min, Integer max) {
        Random random = new Random();
        int randomNumber = random.nextInt(max - min) + min;
        return randomNumber;
    }


    private void testear(Paciente paciente) {
        Integer temperaturaRandom = generateRandomTemperatura(36, 39);
        tablaDeRegistros.put(paciente.getNumeroDeKit(), new Registro(paciente.getDni(), temperaturaRandom.doubleValue()));
    };

    private void aislar(Paciente paciente) {
        try {
            Registro registro = (Registro) tablaDeRegistros.get(paciente.getNumeroDeKit());
            System.out.println(registro);
            validarCovidPositivo(registro);
        } catch (ECovidPositivo e) {
            // TODO
        }
    };

    private void validarCovidPositivo(Registro registro) throws ECovidPositivo {
        if(registro.getTemperatura() >= 38) {
            throw new ECovidPositivo("Es un caso de covid positivo");
        }
    }

    public void guardarEnJson() {
        try {

            File archivo = new File("sanosYSospechosos.json");

            ListaDeSanosYSospechosos lista = new ListaDeSanosYSospechosos();

            for (Paciente paciente : filaPacientes.obtenerLista()) {
                try {
                    Registro registro = (Registro) tablaDeRegistros.get(paciente.getNumeroDeKit());
                    validarCovidPositivo(registro);

                    //
                    lista.agregarSano(paciente);
                } catch (ECovidPositivo e) {
                    lista.agregarAislado(paciente);
                }


            }

            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(archivo, lista);


        } catch (StreamWriteException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
