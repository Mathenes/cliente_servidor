package trabalho_sd;

public class Semaforo_geral {

    private int qntLeitores = 0;

    public synchronized void up() throws InterruptedException {
        qntLeitores--;
        notifyAll();
    }

    public synchronized void downLeitura() throws InterruptedException {
        qntLeitores++;
    }

    public synchronized void downEscrita() throws InterruptedException {
        while (qntLeitores > 0) {
            System.out.println("###### BLOQUEIO DA ESCRITA (PRIORIDADE DE LEITURA) #####");
            wait();
        }
        System.out.println("##### DESBLOQUEIO DA ESCRITA (PRIORIDADE DE LEITURA) #####");
    }

}
