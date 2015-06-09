package trabalho_sd;

//PRIORIDADE DE ESCRITA!!!
public class Semaforo {

    private int mutex = 1;
    private int leitores = 0;
    private int escritoresEsperando = 0;

    public synchronized void upLeitura() {
        leitores--;
        notifyAll();
    }

    public synchronized void downLeitura() throws InterruptedException {
        while (mutex <= 0 || escritoresEsperando > 0) {
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
        escritoresEsperando++;
        while ( mutex <= 0 || leitores > 0) {
            System.out.println("###### ESCRITA BLOQUEADA #####");
            wait();
        }
        escritoresEsperando--;
        System.out.println("##### ESCRITA DESBLOQUEADA #####");
        mutex--;
    }
}
