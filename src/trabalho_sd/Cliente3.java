package trabalho_sd;

import java.rmi.Naming;

public class Cliente3 {
    // O objeto LerEscrever "obj" é o objeto que vai referenciar a interface
    static LerEscrever obj = null;
    
    static int id = 300;

    public static void main(String args[]) {
        try {
            obj = (LerEscrever) Naming.lookup("//localhost" + "/servidor");
            
//            obj.ler("arquivo_1",3,1,id);
//            obj.escrever("arquivo_2", 1,"cccccccc", id);
            for (int i = 0; i < 30; i++) {
                Boolean resultado = obj.escrever("arquivo_2", 4,"cccccccc", id++);
                if(resultado == true)
                    System.out.println("Escreveu!");
                else
                    System.out.println("Não escreveu!");
            }
            
        } catch (Exception e) {
            System.out.println("HelloClient exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
