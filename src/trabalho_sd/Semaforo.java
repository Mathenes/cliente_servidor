/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_sd;

/**
 *
 * @author matheusenes
 */
public class Semaforo {

    private int mutex = 1;
    private int leitores = 0;

    public synchronized void upLeitura() {
        leitores--;
        notifyAll();
    }

    public synchronized void downLeitura() throws InterruptedException {
        while (mutex <= 0) {
            System.out.println("####### LEITURA BLOQUEADA #######");
            wait();
        }
        
        System.out.println("###### LEITURA DESBLOQUEADA ######");
        leitores++;
    }
    
    public synchronized void upEscrita() {
        mutex++;
        notifyAll();
    }

    public synchronized void downEscrita() throws InterruptedException {
        while (mutex <= 0 || leitores > 0) {
            System.out.println("###### ESCRITA BLOQUEADA #####");
            wait();
        }
        
        System.out.println("##### ESCRITA DESBLOQUEADA #####");
        mutex--;
    }
}
