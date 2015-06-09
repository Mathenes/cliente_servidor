package trabalho_sd;

import java.rmi.Naming;
import java.util.List;

public class Cliente3 {
    // O objeto LerEscrever "obj" é o objeto que vai referenciar a interface
    static LerEscrever obj = null;
    
    static int id = 300;

    public static void main(String args[]) {
        try {
            obj = (LerEscrever) Naming.lookup("//localhost" + "/servidor");
            
            for (int i = 0; i < 10; i++) {
                List<String> resultado = obj.ler("arquivo_1",0,1,id++);
                for (String resultado1 : resultado) {
                    System.out.println(resultado1);
                }
            }
            
//            for (int i = 0; i < 30; i++) {
//                Boolean resultado = obj.escrever("arquivo_1", 4,"cccccccc", id++);
//                if(resultado == true)
//                    System.out.println("Escreveu!");
//                else
//                    System.out.println("Não escreveu!");
//            }
            
        } catch (Exception e) {
            System.out.println("HelloClient exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
