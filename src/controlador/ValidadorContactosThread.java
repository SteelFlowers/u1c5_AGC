package controlador;

import modelo.persona;
import java.util.List;

// Valida si un contacto es duplicado en thread separado
public class ValidadorContactosThread implements Runnable {

    private persona contactoNuevo;
    private List<persona> listaContactos;
    private boolean esDuplicado;
    private String mensajeDuplicado;

    public ValidadorContactosThread(persona contactoNuevo, List<persona> listaContactos) {
        this.contactoNuevo = contactoNuevo;
        this.listaContactos = listaContactos;
        this.esDuplicado = false;
        this.mensajeDuplicado = "";
    }

    @Override
    public void run() {
        System.out.println("[VALIDADOR] Validando: " + contactoNuevo.getNombre());

        synchronized(listaContactos) {
            for (persona p : listaContactos) {
                if (p.getNombre().equals("NOMBRE")) {
                    continue;
                }

                // Validar nombre
                if (p.getNombre().equalsIgnoreCase(contactoNuevo.getNombre())) {
                    esDuplicado = true;
                    mensajeDuplicado = "El nombre '" + contactoNuevo.getNombre() + "' ya existe.";
                    return;
                }

                // Validar email
                if (p.getEmail().equalsIgnoreCase(contactoNuevo.getEmail())) {
                    esDuplicado = true;
                    mensajeDuplicado = "El email '" + contactoNuevo.getEmail() + "' ya existe.";
                    return;
                }

                // Validar teléfono
                if (p.getTelefono().equals(contactoNuevo.getTelefono())) {
                    esDuplicado = true;
                    mensajeDuplicado = "El teléfono '" + contactoNuevo.getTelefono() + "' ya existe.";
                    return;
                }
            }
        }

        System.out.println("[VALIDADOR] Validación OK");
    }

    public boolean esDuplicado() {
        return esDuplicado;
    }

    public String getMensajeDuplicado() {
        return mensajeDuplicado;
    }
}
