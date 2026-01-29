package mmConsoleApp;

import mmApp.mmExoTrooperGUI;
import mmInfrastructure.*;
import javax.swing.SwingUtilities;

public class mmMain {
    public static void main(String[] args) {
        mmCMD.mmImprimir("=== SISTEMA EXOTROOPER ===");
        mmCMD.mmImprimir("Estudiante: Mathías Mejía | Cédula: ...3");

        int intentos = 0;
        boolean acceso = false;

        // Login con validación y 3 intentos 
        while (intentos < 3 && !acceso) {
            String u = mmCMDInput.mmLeerString("Usuario (patmic)");
            String p = mmCMDInput.mmLeerString("Clave (123)");

            if (u.equals("patmic") && p.equals("123")) {
                acceso = true;
                mmCMD.mmLog(mmAppMSG.MM_MSG_GOOD, mmAppMSG.MM_LOGIN_OK); // [cite: 45]
            } else {
                intentos++;
                mmCMD.mmLog(mmAppMSG.MM_MSG_ERROR, mmAppMSG.MM_LOGIN_FAIL + " (" + intentos + "/3)");
            }
        }

        if (acceso) {
            mmCMDProgress.mmMostrarCarga();
            // Lanza la GUI de forma segura
            SwingUtilities.invokeLater(() -> new mmExoTrooperGUI().setVisible(true));
        } else {
            mmCMD.mmImprimir("Sistema bloqueado por seguridad.");
            System.exit(0);
        }
    }
}