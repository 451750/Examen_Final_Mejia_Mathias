package mmInfrastructure;

public class mmCMDProgress {
    public static void mmMostrarCarga() {
        System.out.print("Iniciando Sistema ExoTrooper: [");
        for (int i = 0; i < 20; i++) {
            System.out.print("=");
            try { Thread.sleep(30); } catch (Exception e) {}
        }
        System.out.println("] 100%");
    }
}