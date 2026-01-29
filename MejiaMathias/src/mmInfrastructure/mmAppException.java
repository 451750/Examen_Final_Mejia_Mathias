package mmInfrastructure;

public class mmAppException extends Exception {
    public mmAppException(String mensaje) {
        super(mensaje);
        mmCMD.mmLog(mmAppMSG.MM_MSG_ERROR, "Excepción controlada: " + mensaje);
    }
}