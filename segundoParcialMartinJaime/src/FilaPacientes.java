import exceptions.EElPacienteYaExistente;
import model.Paciente;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class FilaPacientes<T> {
    private Queue<T> pacientes = new PriorityQueue<>();

    public Queue<T> obtenerLista() {
        return pacientes;
    }

    private Boolean validarEsPacienteNuevo(T elemento) throws EElPacienteYaExistente {
        for (T paciente : pacientes) {
            if (paciente.equals(elemento)) {
                throw new EElPacienteYaExistente("El paciente com dni " + ((Paciente) paciente).getDni() + " ya existe");
            }
        }
        return true;
    }

    public void agregarPaciente(T elemento) throws EElPacienteYaExistente {
        try {
            if(validarEsPacienteNuevo(elemento)) {
                pacientes.add(elemento);
                Random random = new Random();
                Integer nroDeKit = random.nextInt();
                ((Paciente) elemento).setNumeroDeKit(nroDeKit);
            }
        } catch (EElPacienteYaExistente e) {
            throw e;
        }
    }
}
