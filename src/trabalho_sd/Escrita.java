package trabalho_sd;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Escrita implements Runnable {

    Semaforo semaforo;
    BufferedWriter escritorArquivo;
    int qntLinhas;
    String texto;
    int idCliente;

    public Escrita(Semaforo semaforo, BufferedWriter escritorArquivo, int qntLinhas, String texto, int idCliente) {
        this.semaforo = semaforo;
        this.escritorArquivo = escritorArquivo;
        this.qntLinhas = qntLinhas;
        this.texto = texto;
        this.idCliente = idCliente;
    }

    @Override
    public void run() {
        try {
            //Entrando na seção crítica
            semaforo.downEscrita();
            Thread.sleep((long) (Math.random() * 1000));

            //Escrevendo a quantidade de linhas desejada
            System.out.println("|cliente: " + idCliente + "|" + "começou a escrever!");
            for (int j = 0; j < qntLinhas; j++) {
                escritorArquivo.append(texto + "\n");
            }
            escritorArquivo.close();
            System.out.println("|cliente: " + idCliente + "|" + "terminou de escrever!");

            //Saindo da seção crítica
            semaforo.upEscrita();

        } catch (InterruptedException ex) {
            Logger.getLogger(Escrita.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Erro de IO.");
            Logger.getLogger(Escrita.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
