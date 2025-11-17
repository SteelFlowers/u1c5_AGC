package controlador;

import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;
import vista.ventana;

// Muestra notificaciones en tiempo real sin bloquear UI
public class NotificadorUI {

    private ventana delegado;

    public NotificadorUI(ventana delegado) {
        this.delegado = delegado;
    }

    // Notificacion de exito
    public void notificacionExito(String titulo, String mensaje) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JOptionPane.showMessageDialog(delegado, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
                System.out.println("[NOTIFICACION] Exito: " + titulo);
            }
        });
    }

    // Notificacion de error
    public void notificacionError(String titulo, String mensaje) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JOptionPane.showMessageDialog(delegado, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
                System.out.println("[NOTIFICACION] Error: " + titulo);
            }
        });
    }

    // Notificacion de advertencia
    public void notificacionAdvertencia(String titulo, String mensaje) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JOptionPane.showMessageDialog(delegado, mensaje, titulo, JOptionPane.WARNING_MESSAGE);
                System.out.println("[NOTIFICACION] Advertencia: " + titulo);
            }
        });
    }
}
