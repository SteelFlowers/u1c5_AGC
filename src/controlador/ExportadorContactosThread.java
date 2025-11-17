package controlador;

import modelo.persona;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

// Exporta contactos a CSV en thread separado
public class ExportadorContactosThread extends Thread {

    private List<persona> contactos;
    private String ruta;
    private boolean exitoso;
    private String mensaje;

    public ExportadorContactosThread(List<persona> contactos, String ruta) {
        this.contactos = contactos;
        this.ruta = ruta;
        this.exitoso = false;
        this.mensaje = "";
    }

    @Override
    public void run() {
        System.out.println("[EXPORTADOR] Iniciando exportacion a: " + ruta);

        synchronized (this) {
            try {
                FileWriter fw = new FileWriter(ruta);
                fw.write("Nombre,Telefono,Email,Categoria,Favorito\n");

                for (persona p : contactos) {
                    if (!p.getNombre().equals("NOMBRE")) {
                        fw.write(p.datosContacto().replace(";", ",") + "\n");
                    }
                }

                fw.close();
                exitoso = true;
                mensaje = "Archivo exportado correctamente";
                System.out.println("[EXPORTADOR] Exportacion completada");

            } catch (IOException e) {
                exitoso = false;
                mensaje = "Error al exportar: " + e.getMessage();
                System.out.println("[EXPORTADOR] Error: " + e.getMessage());
            }
        }
    }

    public boolean esExitoso() {
        return exitoso;
    }

    public String getMensaje() {
        return mensaje;
    }
}
