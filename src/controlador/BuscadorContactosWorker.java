package controlador;

import modelo.persona;
import vista.ventana;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import java.util.List;

// Busca en segundo plano sin bloquear la UI
public class BuscadorContactosWorker extends SwingWorker<Void, Void> {

    private List<persona> contactos;
    private String busqueda;
    private DefaultTableModel modeloTabla;
    private ventana delegado;

    public BuscadorContactosWorker(List<persona> contactos, String busqueda,
                                   DefaultTableModel modeloTabla, ventana delegado) {
        this.contactos = contactos;
        this.busqueda = busqueda.toLowerCase();
        this.modeloTabla = modeloTabla;
        this.delegado = delegado;
    }

    @Override
    protected Void doInBackground() throws Exception {
        return null;
    }

    @Override
    protected void done() {
        try {
            modeloTabla.setRowCount(0);

            for (persona p : contactos) {
                if (!p.getNombre().equals("NOMBRE")) {
                    if (p.getNombre().toLowerCase().contains(busqueda) ||
                        p.getTelefono().contains(busqueda) ||
                        p.getEmail().toLowerCase().contains(busqueda)) {
                        Object[] fila = {
                            p.getNombre(),
                            p.getTelefono(),
                            p.getEmail(),
                            p.getCategoria(),
                            p.isFavorito() ? "Si" : "No"
                        };
                        modeloTabla.addRow(fila);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
