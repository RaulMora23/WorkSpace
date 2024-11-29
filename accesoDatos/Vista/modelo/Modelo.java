package modelo;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;

import controlador.ControladorBBDD;
import sql.SQL;
import sql.conexionSingleton;
import vista.BotonMejorado;
import vista.Vista;

public class Modelo {
	private ArrayList<JButton> bbdds = new ArrayList<JButton>();
	private Vista vista;
	private static Connection conx=null;
	
	public Modelo(Vista vista) throws SQLException {
		this.vista=vista;
		try {
			this.conx = conexionSingleton.getMysql();
		} catch (SQLException e) {
			System.out.println("Error de conexión al servicio");
		}
		
		// CONSULTA BASES DE DATOS
				ResultSet databases = SQL.obtenerBBDD(conx);
				boolean empleados = false;
				boolean equipos = false;
				boolean educativa = false;
				boolean biblioteca = false;
				Integer indiceEmpleados = -1;
				Integer indiceEquipos = -2;
				Integer indiceEducativa = -3;
				Integer indiceBiblioteca = -4;
				String nombreEmpleados = null;
				String nombreEquipos = null;
				String nombreEducativa = null;
				String nombreBiblioteca = null;
				int i = 1;
				while (databases.next()) {
					String nombreBD;
					nombreBD = databases.getString(1); // Obtener el nombre de la base de datos

					// Comprobar si la base de datos contiene "empleados"
					if (nombreBD.toLowerCase().contains("empleados")) {
						empleados = true;
						indiceEmpleados = i;
						nombreEmpleados = nombreBD;
					}

					// Comprobar si la base de datos contiene "equipos"
					if (nombreBD.toLowerCase().contains("equipos")) {
						equipos = true;
						indiceEquipos = i;
						nombreEquipos = nombreBD;
					}

					// Comprobar si la base de datos contiene "educativa"
					if (nombreBD.toLowerCase().contains("educativa")) {
						educativa = true;
						indiceEducativa = i;
						nombreEducativa = nombreBD;
					}
					// Comprobar si la base de datos contiene "Biblioteca"
					if (nombreBD.toLowerCase().contains("biblioteca")) {
						biblioteca = true;
						indiceBiblioteca = i;
						nombreBiblioteca = nombreBD;
					}
					i++;
				}
				databases.close();
				if (empleados) {
				    JButton botonEmpleados = new JButton(nombreEmpleados.toUpperCase().replace("_", " "));
				    botonEmpleados.setFont(botonEmpleados.getFont().deriveFont(10f));
				    botonEmpleados.setToolTipText(nombreEmpleados);
				    bbdds.add(botonEmpleados);
				}
				if (equipos) {
					JButton botonEquipos = new JButton(nombreEquipos.toUpperCase().replace("_", " "));
					botonEquipos.setFont(botonEquipos.getFont().deriveFont(10f));
					botonEquipos.setToolTipText(nombreEquipos);
				    bbdds.add(botonEquipos);
				}
				if (educativa) {
					JButton botonEducativa = new JButton(nombreEducativa.toUpperCase().replace("_", " "));
					botonEducativa.setFont(botonEducativa.getFont().deriveFont(10f));
					botonEducativa.setToolTipText(nombreEducativa);;
				    bbdds.add(botonEducativa);
				}
				if (biblioteca) {
					JButton botonBiblioteca = new JButton(nombreBiblioteca.toUpperCase().replace("_", " "));
					botonBiblioteca.setFont(botonBiblioteca.getFont().deriveFont(10f));
					botonBiblioteca.setToolTipText(nombreBiblioteca);
				    bbdds.add(botonBiblioteca);
				}
				ControladorBBDD.setListeners(this);
				vista.actualizarBBDD(bbdds);
	}

	public ArrayList<JButton> getBbdds() {
		return bbdds;
	}

	public Vista getVista() {
		return vista;
	}

	public static Connection getConx() {
		return conx;
	}
	
	
}
