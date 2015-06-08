/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho_sd;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author matheusenes
 */
public interface LerEscrever extends Remote{
    public List<String> ler(String nomeArquivo, int numeroLinha, int qntLinhas, int idCliente) throws RemoteException;
    public Boolean escrever(String nomeArquivo, int qntLinhas, String texto, int idCliente) throws RemoteException;
}
