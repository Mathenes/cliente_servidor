package trabalho_sd;

import java.rmi.Naming;

public class Cliente2 {
    // O objeto LerEscrever "obj" é o objeto que vai referenciar a interface
    static LerEscrever obj = null;
    
    static final int id = 2;

    public static void main(String args[]) {
        try {
            obj = (LerEscrever) Naming.lookup("//localhost" + "/servidor");
            
            for (int i = 0; i < 50; i++) {
                obj.escrever("arquivo_1", 1,"bbbbbbbb", id);
            }
            
//            for (int i = 0; i < 100; i++) {
//                obj.ler("arquivo_1",1,1,id);
//            }
            
        } catch (Exception e) {
            System.out.println("HelloClient exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}