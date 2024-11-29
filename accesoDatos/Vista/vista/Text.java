package vista;

import java.sql.SQLException;

import modelo.Modelo;

public class Text {
	public static void main(String[] args) throws SQLException {
		Vista vista = new Vista();
		Modelo modelo = new Modelo(vista);
		vista.setVisible(true);
	}
}
