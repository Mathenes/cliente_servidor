package trabalho_sd;

import java.rmi.Naming;

public class Cliente3 {
    // O objeto LerEscrever "obj" é o objeto que vai referenciar a interface
    static LerEscrever obj = null;
    
    static final int id = 3;

    public static void main(String args[]) {
        try {
            obj = (LerEscrever) Naming.lookup("//localhost" + "/servidor");
            
            obj.ler("arquivo_1",3,1,id);
            obj.escrever("arquivo_1", 1,"cccccccc", id);
            
        } catch (Exception e) {
            System.out.println("HelloClient exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
