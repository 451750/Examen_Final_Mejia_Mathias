package mmInfrastructure;
import java.util.Scanner;

public class mmCMDInput {
    private static Scanner scanner = new Scanner(System.in);

   
    public static String mmLeerString(String etiqueta) {
        String entrada = "";
        while (entrada.trim().isEmpty()) {
            System.out.print(etiqueta + ": ");
            entrada = scanner.nextLine();
            if (entrada.trim().isEmpty()) {
                System.out.println("(!) El dato no puede estar vacío.");
            }
        }
        return entrada;
    }
}