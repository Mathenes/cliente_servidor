package trabalho_sd;

import java.rmi.Naming;

public class Cliente2 {
    // O objeto LerEscrever "obj" é o objeto que vai referenciar a interface
    static LerEscrever obj = null;
    
    static final int id = 2;

    public static void main(String args[]) {
        try {
            obj = (LerEscrever) Naming.lookup("//localhost" + "/servidor");
            
            obj.ler(1, id);
            obj.escrever(1, "B", id);
            
        } catch (Exception e) {
            System.out.println("HelloClient exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}