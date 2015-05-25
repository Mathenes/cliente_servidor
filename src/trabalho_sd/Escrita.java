/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_sd;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author matheusenes
 */
public class Escrita implements Runnable {

    Semaforo semaforo;
    List<String> arq;
    String letra;
    int id;
    int idCliente;

    public Escrita(Semaforo semaforo, List<String> arq, String letra, int id, int idCliente) {
        this.semaforo = semaforo;
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
                semaforo.downEscrita();
                
                System.out.println("|cliente: " + idCliente + "|" + "escrita: " + id + "|" + "começou a escrever!");
                arq.add(letra);
                System.out.println("|cliente: " + idCliente + "|" + "escrita: " + id + "|" + "escreveu " + letra);
                System.out.println("|cliente: " + idCliente + "|" + "escrita: " + id + "|" + "terminou de escrever!");
                
                semaforo.upEscrita();
                
                Thread.sleep(i % 200);
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(Escrita.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
