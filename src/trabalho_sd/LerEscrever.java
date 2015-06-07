/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho_sd;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author matheusenes
 */
public interface LerEscrever extends Remote{
    public void ler(String nomeArquivo, int numeroLinha, int qntLinhas, int idCliente) throws RemoteException;
    public void escrever(String nomeArquivo, int qntLinhas, String texto, int idCliente) throws RemoteException;
}
