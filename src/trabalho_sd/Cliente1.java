package trabalho_sd;

import java.rmi.Naming;

public class Cliente1 {
    // O objeto LerEscrever "obj" é o objeto que vai referenciar a interface
    static LerEscrever obj = null;
    
    static final int id = 1;

    public static void main(String args[]) {
        try {
            obj = (LerEscrever) Naming.lookup("//localhost" + "/servidor");
            
            for (int i = 0; i < 10000; i++) {
                obj.ler("arquivo_1",0,1,id);
            }
            
//            for (int i = 0; i < 100; i++) {
//                obj.escrever("arquivo_1", 1,"aaaaaaaa", id);
//            }
            
            
        } catch (Exception e) {
            System.out.println("HelloClient exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
