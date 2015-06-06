package trabalho_sd;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Leitura implements Runnable {

    Semaforo semaforo;
    Semaforo_geral semaforoGeral;
    List<String> arq;
    int id;
    int idCliente;

    public Leitura(Semaforo semaforo, Semaforo_geral semaforoGeral, List<String> arq, int id, int idCliente) {
        this.semaforo = semaforo;
        this.semaforoGeral = semaforoGeral;
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
                String letras = new String( );
                semaforoGeral.downLeitura();
                semaforo.downLeitura();
                
                System.out.println("|cliente: " + idCliente + "|" + "leitura: " + id + "|" + "começou a ler!");
                for (String string : arq) {
                    letras += string;
                }
                System.out.println("INICIO" + letras + "FIM");
                System.out.println("|cliente: " + idCliente + "|" + "leitura: " + id + "|" + "terminou de ler!");
                
                semaforo.upLeitura();
                semaforoGeral.up();
                
                Thread.sleep(i % 190);
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(Leitura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
