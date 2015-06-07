package trabalho_sd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor extends UnicastRemoteObject implements LerEscrever {

    private Semaforo semaforoArq1 = new Semaforo();
    private Semaforo semaforoArq2 = new Semaforo();
    private Semaforo semaforoArq3 = new Semaforo();

    private BufferedReader leitor_arquivo_1;
    private BufferedReader leitor_arquivo_2;
    private BufferedReader leitor_arquivo_3;
    
    private BufferedWriter escritor_arquivo_1;
    private BufferedWriter escritor_arquivo_2;
    private BufferedWriter escritor_arquivo_3;
    
    String caminho_arq_1 = "arquivo_1.txt";
    String caminho_arq_2 = "arquivo_2.txt";
    String caminho_arq_3 = "arquivo_3.txt";

    public Servidor() throws RemoteException {
        super();
    }

    @Override
    public void ler(String nomeArquivo, int numeroLinha, int qntLinhas, int idCliente) {
        try {
            Leitura leitura = null;

            switch (nomeArquivo) {
                case "arquivo_1":
                    leitor_arquivo_1 = new BufferedReader(new FileReader(caminho_arq_1));
                    leitura = new Leitura(semaforoArq1, leitor_arquivo_1, numeroLinha, qntLinhas, idCliente);
                    break;
                case "arquivo_2":
                    leitor_arquivo_2 = new BufferedReader(new FileReader(caminho_arq_2));
                    leitura = new Leitura(semaforoArq2, leitor_arquivo_2, numeroLinha, qntLinhas, idCliente);
                    break;
                case "arquivo_3":
                    leitor_arquivo_3 = new BufferedReader(new FileReader(caminho_arq_3));
                    leitura = new Leitura(semaforoArq3, leitor_arquivo_3, numeroLinha, qntLinhas, idCliente);
                    break;
            }

            Thread thread = new Thread(leitura);

            thread.start();

        } catch (FileNotFoundException ex) {
            System.out.println("Erro de arquivo não encontrado no método ler");
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void escrever(String nomeArquivo, int qntLinhas, String texto, int idCliente) {
        try {
            Escrita escrita = null;

            switch (nomeArquivo) {
                case "arquivo_1":
                    escritor_arquivo_1 = new BufferedWriter(new FileWriter(caminho_arq_1, true));
                    escrita = new Escrita(semaforoArq1, escritor_arquivo_1, qntLinhas, texto, idCliente);
                    break;
                case "arquivo_2":
                    escritor_arquivo_2 = new BufferedWriter(new FileWriter(caminho_arq_2, true));
                    escrita = new Escrita(semaforoArq2, escritor_arquivo_2, qntLinhas, texto, idCliente);
                    break;
                case "arquivo_3":
                    escritor_arquivo_3 = new BufferedWriter(new FileWriter(caminho_arq_3, true));
                    escrita = new Escrita(semaforoArq3, escritor_arquivo_3, qntLinhas, texto, idCliente);
                    break;
            }

            Thread thread = new Thread(escrita);

            thread.start();

        } catch (IOException ex) {
            System.out.println("Erro de IO no método escrever.");
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        try {
            //Cria o servidor
            Servidor obj = new Servidor();
            //"Liga" o servidor com seu nome de registro
            Naming.rebind("servidor", obj);

            System.out.println("servidor registrado!");

        } catch (IOException e){
            System.out.println("Erro no arquivo.");
        } catch (Exception ex) {
            System.out.println("erro no servidor: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

}
