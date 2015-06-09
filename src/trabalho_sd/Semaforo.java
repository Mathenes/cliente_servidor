package trabalho_sd;

//PRIORIDADE DE LEITURA!!!
public class Semaforo {

    private int mutex = 1;
    private int leitores = 0;
    private int leitoresEsperando = 0;

    public synchronized void upLeitura() {
        leitores--;
        notifyAll();
    }

    public synchronized void downLeitura() throws InterruptedException {
        leitoresEsperando++;
        while (mutex <= 0) {
            System.out.println("####### LEITURA BLOQUEADA #######");
            wait();
        }
        
        System.out.println("###### LEITURA DESBLOQUEADA ######");
        leitoresEsperando--;
        leitores++;
    }
    
    public synchronized void upEscrita() {
        mutex++;
        notifyAll();
    }

    public synchronized void downEscrita() throws InterruptedException {
        while ( mutex <= 0 || leitoresEsperando > 0 || leitores > 0) {
            System.out.println("###### ESCRITA BLOQUEADA #####");
            wait();
        }
        
        System.out.println("##### ESCRITA DESBLOQUEADA #####");
        mutex--;
    }
}
