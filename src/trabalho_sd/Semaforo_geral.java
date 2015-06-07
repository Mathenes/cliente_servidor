package trabalho_sd;

public class Semaforo_geral {

    private int qntEscritores = 0;

    public synchronized void up() throws InterruptedException {
        qntEscritores--;
        notifyAll();
    }

    public synchronized void downLeitura() throws InterruptedException {
        while (qntEscritores > 0) {
            System.out.println("###### BLOQUEIO DA LEITURA (PRIORIDADE DE ESCRITA) #####");
            wait();
        }
        System.out.println("##### DESBLOQUEIO DA LEITURA (PRIORIDADE DE ESCRITA) #####");
    }

    public synchronized void downEscrita() throws InterruptedException {
        qntEscritores++;
    }

}
