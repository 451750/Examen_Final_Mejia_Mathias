package mmInfrastructure;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class mmCMD {

    // ESTE ES EL MÉTODO QUE TE FALTABA
    public static void mmImprimir(String mensaje) {
        System.out.println(mensaje);
    }

    public static void mmLog(String tipo, String mensaje) {
        String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String logLine = String.format("%s: %s - %s", tipo, fecha, mensaje);
        
        System.out.println(logLine); // Traza en consola
        
        // Traza en archivo
        try (FileWriter fw = new FileWriter(mmAppConfig.MM_LOG_FILE, true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(logLine);
        } catch (Exception e) {
            System.err.println("Error crítico escribiendo Log: " + e.getMessage());
        }
    }
}