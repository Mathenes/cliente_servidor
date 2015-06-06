package trabalho_sd;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Servidor extends UnicastRemoteObject implements LerEscrever {

    private Semaforo semaforoArq1 = new Semaforo();
    private Semaforo semaforoArq2 = new Semaforo();
    private Semaforo semaforoArq3 = new Semaforo();
    
    //TODO: Pensar em um outro nome, pois semaforoGeral está confuso
    private Semaforo_geral semaforoGeralArq1 = new Semaforo_geral();
    private Semaforo_geral semaforoGeralArq2 = new Semaforo_geral();
    private Semaforo_geral semaforoGeralArq3 = new Semaforo_geral();
    private List<String> arq1 = new ArrayList<>();
    private List<String> arq2 = new ArrayList<>();
    private List<String> arq3 = new ArrayList<>();

    int[] indiceLeitores = new int[3];
    int[] indiceEscritores = new int[3];

    public Servidor() throws RemoteException {
        super();
    }

    @Override
    public void ler(int idArq, int idCliente) {
        try {
            Leitura leitura = null;
            indiceLeitores[idCliente - 1]++;

            switch (idArq) {
                case 1:
                    leitura = new Leitura(semaforoArq1, semaforoGeralArq1, arq1, indiceLeitores[idCliente - 1], idCliente);
                    break;
                case 2:
                    leitura = new Leitura(semaforoArq2, semaforoGeralArq2, arq2, indiceLeitores[idCliente - 1], idCliente);
                    break;
                case 3:
                    leitura = new Leitura(semaforoArq3, semaforoGeralArq3, arq3, indiceLeitores[idCliente - 1], idCliente);
                    break;
            }

            Thread thread = new Thread(leitura);

            thread.start();

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Erro no Array");
        }
    }

    @Override
    public void escrever(int idArq, String letra, int idCliente) {
        try {

            Escrita escrita = null;
            indiceEscritores[idCliente - 1]++;

            switch (idArq) {
                case 1:
                    escrita = new Escrita(semaforoArq1, semaforoGeralArq1, arq1, letra, indiceEscritores[idCliente - 1], idCliente);
                    break;
                case 2:
                    escrita = new Escrita(semaforoArq2, semaforoGeralArq2, arq2, letra, indiceEscritores[idCliente - 1], idCliente);
                    break;
                case 3:
                    escrita = new Escrita(semaforoArq3, semaforoGeralArq3, arq3, letra, indiceEscritores[idCliente - 1], idCliente);
                    break;
            }

            Thread thread = new Thread(escrita);

            thread.start();

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Erro no Array");
        }
    }

    public static void main(String[] args) {
        try {

            //Cria o servidor
            Servidor obj = new Servidor();
            //"Liga" o servidor com seu nome de registro
            Naming.rebind("servidor", obj);

            System.out.println("servidor registrado!");

        } catch (Exception ex) {
            System.out.println("erro no servidor: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

}
