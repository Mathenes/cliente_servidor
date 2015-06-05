/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho_sd;

/**
 *
 * @author giova_000
 */
public class Semaforo_geral {
    
    private int mutex = 0;
    
    public synchronized void up() throws InterruptedException{
        mutex--;
        notifyAll();
    } 
    
    public synchronized void downLeitura() throws InterruptedException{
        while (mutex > 0){
            System.out.println("###### BLOQUEIO DE PRIORIDADE #####");
            wait();
        }
        System.out.println("##### DESBLOQUEIO DE PRIORIDADE #####");
    }
    
    public synchronized void downEscrita() throws InterruptedException{
        mutex++;
    }
    
}
