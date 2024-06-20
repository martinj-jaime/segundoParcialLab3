import model.Paciente;

import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

        SSM ssm = new SSM();

        ssm.init();

        ssm.mostrarFila();

        ssm.testearPacientes();

        ssm.aislarPacientes();

        ssm.guardarEnJson();


    }


}