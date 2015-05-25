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
    public void ler(int idArq, int idCliente) throws RemoteException;
    public void escrever(int idArq, String letra, int idCliente) throws RemoteException;
}
