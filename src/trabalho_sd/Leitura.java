package trabalho_sd;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Leitura implements Runnable {

    Semaforo semaforo;
    BufferedReader leitorArquivo;
    int numeroLinha;
    int qntLinhas;
    int idCliente;
    volatile List<String> resultado  = new ArrayList<>();
    volatile Boolean terminou = false;

    public Leitura(Semaforo semaforo, BufferedReader leitorArquivo, int numeroLinha, int qntLinhas, int idCliente) {
        this.semaforo = semaforo;
        this.leitorArquivo = leitorArquivo;
        this.numeroLinha = numeroLinha;
        this.qntLinhas = qntLinhas;
        this.idCliente = idCliente;
    }

    @Override
    public void run() {
        try {
            //Entrando na seção crítica
            semaforo.downLeitura();
            Thread.sleep((long) (Math.random() * 1000));

            //Para se chegar na linha desejada
            for (int j = 0; j < numeroLinha - 1; j++) {
                leitorArquivo.readLine();
            }

            //Lendo a quantidade de linhas desejada
            System.out.println("|cliente: " + idCliente + "|" + "começou a ler!");
            int contadorLinhas = 0;
            String linha = leitorArquivo.readLine();
            while ((linha != null) && (contadorLinhas != qntLinhas)) {
                resultado.add(linha);
                linha = leitorArquivo.readLine();
                contadorLinhas++;
            }
            leitorArquivo.close();
            System.out.println("|cliente: " + idCliente + "|" + "terminou de ler!");

            //Saindo da seção crítica
            semaforo.upLeitura();
            
            terminou = true;
            
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Leitura.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Erro de IO.");
            Logger.getLogger(Leitura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
