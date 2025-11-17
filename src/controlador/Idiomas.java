package controlador;

import java.util.Locale;
import java.util.ResourceBundle;

public class Idiomas {

	private static ResourceBundle bundle;
	private static Locale localeActual;

	static {
		localeActual = new Locale("es", "ES");
		cargarIdioma();
	}

	public static void cargarIdioma(String idioma, String pais) {
		localeActual = new Locale(idioma, pais);
		cargarIdioma();
	}

	private static void cargarIdioma() {
		try {
			bundle = ResourceBundle.getBundle("idiomas.Mensajes", localeActual);
		} catch (Exception e) {
			localeActual = new Locale("es", "ES");
			bundle = ResourceBundle.getBundle("idiomas.Mensajes", localeActual);
		}
	}

	public static String obtener(String clave) {
		try {
			return bundle.getString(clave);
		} catch (Exception e) {
			return clave;
		}
	}

	public static Locale getLocaleActual() {
		return localeActual;
	}

	public static void cambiarAlEspanol() {
		cargarIdioma("es", "ES");
	}

	public static void cambiarAlIngles() {
		cargarIdioma("en", "US");
	}

	public static void cambiarAlFrances() {
		cargarIdioma("fr", "FR");
	}
}
