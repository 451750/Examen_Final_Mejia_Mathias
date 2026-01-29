package mmBusinessLogic;
import mmInfrastructure.mmAppMSG;
import mmInfrastructure.mmCMD;

public abstract class mmExobot extends mmIAEXO {
    protected int mmIdExobot;
    protected String mmTipoExobot;
    protected boolean mmEntreno;
    protected int mmNoAccion;
    protected String mmExtremidad; // Requisito de extremidad

    public mmExobot(int id, String tipo) {
        this.mmIdExobot = id;
        this.mmTipoExobot = tipo;
        this.mmEntreno = false;
        this.mmNoAccion = 0;
        this.mmExtremidad = "Brazo Derecho"; // Definición por defecto
    }

    @Override
    public void mmEntrenar() {
        this.mmEntreno = true;
        // Formato Log [cite: 51]
        mmCMD.mmLog(mmAppMSG.MM_MSG_GOOD, "SoldadoExperto " + mmTipoExobot + " ENTRENADO");
    }

    public int mmGetId() { return mmIdExobot; }
    public String mmGetTipo() { return mmTipoExobot; }
    public String mmIsEntrenado() { return mmEntreno ? "SI" : "NO"; }
    public int mmGetAcciones() { return mmNoAccion; }

    public abstract void mmAccionArma();
}