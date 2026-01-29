package mmDataAccess;

import mmInfrastructure.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class mmExobotDAC {

    // Busca recursos en el archivo limpiando comas y espacios
    public List<String> mmLeerRecursos(String filtro) {
        List<String> encontrados = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(mmAppConfig.MM_MUNICION_FILE))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Parsing manual del CSV irregular
                String[] items = linea.split(",");
                for (String item : items) {
                    String dato = item.trim();
                    if (!dato.isEmpty() && dato.contains(filtro)) {
                        encontrados.add(dato);
                    }
                }
            }
        } catch (Exception e) {
            mmCMD.mmLog(mmAppMSG.MM_MSG_ERROR, "Error leyendo archivo munición: " + e.getMessage());
        }
        return encontrados;
    }
}