package controlador;

import java.util.HashSet;
import java.util.Set;

// Gestiona bloqueos de contactos para evitar ediciones simultaneas
public class GestorBloqueos {

    private static Set<String> contactosEnEdicion = new HashSet<>();

    // Intenta bloquear un contacto para edicion
    public synchronized static boolean bloquearContacto(String nombre) {
        if (contactosEnEdicion.contains(nombre)) {
            return false;
        }
        contactosEnEdicion.add(nombre);
        System.out.println("[BLOQUEO] Contacto bloqueado: " + nombre);
        return true;
    }

    // Desbloquea un contacto
    public synchronized static void desbloquearContacto(String nombre) {
        contactosEnEdicion.remove(nombre);
        System.out.println("[BLOQUEO] Contacto desbloqueado: " + nombre);
    }

    // Verifica si un contacto esta bloqueado
    public synchronized static boolean estaEnEdicion(String nombre) {
        return contactosEnEdicion.contains(nombre);
    }
}
