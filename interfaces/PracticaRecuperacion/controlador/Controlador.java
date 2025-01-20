package controlador;

import vista.Formulario;
import vista.Resumen;

public class Controlador {

	public static void mostrarResumen(Formulario formulario) {
		formulario.setVisible(false);
		System.out.println(formulario.getDuracion());
		Resumen resumen = new Resumen();
		resumen.setVisible(true);
	}

}
