package trabalho_sd;

import java.rmi.Naming;

public class Cliente2 {
    // O objeto LerEscrever "obj" é o objeto que vai referenciar a interface
    static LerEscrever obj = null;
    
    static int id = 200;

    public static void main(String args[]) {
        try {
            obj = (LerEscrever) Naming.lookup("//localhost" + "/servidor");
            
            for (int i = 0; i < 30; i++) {
                Boolean resultado = obj.escrever("arquivo_1", 1,"bbbbbbbb", id++);
                if(resultado == true)
                    System.out.println("Escreveu!");
                else
                    System.out.println("Não escreveu!");
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