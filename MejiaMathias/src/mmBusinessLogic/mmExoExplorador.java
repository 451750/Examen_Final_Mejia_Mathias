package mmBusinessLogic;

import mmDataAccess.mmExobotDAC;
import mmInfrastructure.mmAppMSG;
import mmInfrastructure.mmCMD;
import java.util.List;

public class mmExoExplorador extends mmExobot {

    public mmExoExplorador(int id) {
        super(id, "ExoExplorador");
    }

    @Override
    public boolean mmGarantizarAccion(String tipo) {
        return mmEntreno; // Solo funciona si está entrenado
    }

    @Override
    public void mmAccionArma() {
        // Validación: Debe estar entrenado en GPS [cite: 48]
        if (!mmGarantizarAccion("GPS")) {
            mmCMD.mmLog(mmAppMSG.MM_MSG_ERROR, "ExoExplorador (GPS) detectar - NO ENTRENADO");
            return;
        }

        mmExobotDAC dac = new mmExobotDAC();
        // Cédula 3 busca ENERGÍA [cite: 27]
        List<String> recursos = dac.mmLeerRecursos("Energía");
        
        // Validación si no encuentra recursos
        String usado = recursos.isEmpty() ? "Energía_Reserva" : recursos.get(0);
        this.mmNoAccion++;

        // Log final [cite: 55]
        mmCMD.mmLog(mmAppMSG.MM_MSG_GOOD, "GPS detectar " + usado + " usando " + this.mmExtremidad);
    }
}