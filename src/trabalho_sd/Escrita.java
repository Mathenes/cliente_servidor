package trabalho_sd;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Escrita implements Runnable {

    Semaforo semaforo;
    Semaforo_geral semaforoGeral;
    List<String> arq;
    String letra;
    int id;
    int idCliente;

    public Escrita(Semaforo semaforo,Semaforo_geral semaforoGeral, List<String> arq, String letra, int id, int idCliente) {
        this.semaforo = semaforo;
        this.semaforoGeral = semaforoGeral;
        this.arq = arq;
        this.letra = letra;
        this.id = id;
        this.idCliente = idCliente;
    }

    @Override
    public void run() {
        try {
            int i = 0;
            while (true) {
                i++;
                semaforoGeral.downEscrita();
                semaforo.downEscrita();
                
                System.out.println("|cliente: " + idCliente + "|" + "escrita: " + id + "|" + "começou a escrever!");
                arq.add(letra);
                System.out.println("|cliente: " + idCliente + "|" + "escrita: " + id + "|" + "escreveu " + letra);
                System.out.println("|cliente: " + idCliente + "|" + "escrita: " + id + "|" + "terminou de escrever!");
                
                semaforo.upEscrita();
                semaforoGeral.up();
                Thread.sleep(i % 200);
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(Escrita.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
