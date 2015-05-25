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
public class Leitura implements Runnable {

    Semaforo semaforo;
    List<String> arq;
    int id;
    int idCliente;

    public Leitura(Semaforo semaforo, List<String> arq, int id, int idCliente) {
        this.semaforo = semaforo;
        this.arq = arq;
        this.id = id;
        this.idCliente = idCliente;
    }

    @Override
    public void run() {
        try {
            
            int i = 0;
            while (true) {
                i++;
                String letras = new String();
                
                semaforo.downLeitura();
                
                System.out.println("|cliente: " + idCliente + "|" + "leitura: " + id + "|" + "começou a ler!");
                for (String string : arq) {
                    letras += string;
                }
                System.out.println("INICIO" + letras + "FIM");
                System.out.println("|cliente: " + idCliente + "|" + "leitura: " + id + "|" + "terminou de ler!");
                
                semaforo.upLeitura();
                
                Thread.sleep(i % 190);
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(Leitura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
