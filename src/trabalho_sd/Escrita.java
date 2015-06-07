package trabalho_sd;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Escrita implements Runnable {

    Semaforo semaforo;
    Semaforo_geral semaforoGeral;
    BufferedWriter escritorArquivo;
    int qntLinhas;
    String texto;
    int idCliente;

    public Escrita(Semaforo semaforo, Semaforo_geral semaforoGeral, BufferedWriter escritorArquivo, int qntLinhas, String texto, int idCliente) {
        this.semaforo = semaforo;
        this.semaforoGeral = semaforoGeral;
        this.escritorArquivo = escritorArquivo;
        this.qntLinhas = qntLinhas;
        this.texto = texto;
        this.idCliente = idCliente;
    }

    @Override
    public void run() {
        try {
            //Tratando a prioridade
            semaforoGeral.downEscrita();
            
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
