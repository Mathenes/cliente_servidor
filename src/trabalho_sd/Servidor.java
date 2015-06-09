package trabalho_sd;

import java.rmi.Naming;

public class Servidor {

    public static void main(String[] args) {
        try {
            //Cria o objeto remoto
            LerEscrever obj = new LerEscreverImpl();
            
            //"Linka" o objeto remoto com seu nome de registro
            Naming.rebind("servidor", obj);

            System.out.println("servidor registrado!");

        } catch (Exception ex) {
            System.out.println("erro no servidor: " + ex.getMessage());
            ex.printStackTrace();
        }
        
    }
}
