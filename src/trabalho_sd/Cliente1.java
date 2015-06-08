package trabalho_sd;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.List;

public class Cliente1 {
    // O objeto LerEscrever "obj" é o objeto que vai referenciar a interface
    static LerEscrever obj = null;
    
    static int id = 100;

    public static void main(String args[]) {
        try {
            obj = (LerEscrever) Naming.lookup("//localhost" + "/servidor");
            
            for (int i = 0; i < 10; i++) {
                List<String> resultado = obj.ler("arquivo_1",0,1,id++);
                for (String resultado1 : resultado) {
                    System.out.println(resultado1);
                }
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
