package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.SwingWorker;

import dao.GestionAlumno;
import dao.GestionAsignatura;
import dao.GestionAutor;
import dao.GestionDepartamento;
import dao.GestionEmpleado;
import dao.GestionEquipo;
import dao.GestionJugador;
import dao.GestionLibro;
import dao.GestionLibroAutor;
import dao.GestionMatricula;
import dao.GestionPrestamo;
import dao.GestionUsuario;
import modelo.Modelo;
import sql.BBDD;

public class ControladorBBDD {

	public static void setListeners(Modelo modelo) {
//		SwingWorker<ArrayList<JButton>, Void> worker = new SwingWorker<>() {
//			@Override
//			protected ArrayList<JButton> doInBackground() throws SQLException {
				for (JButton jButton : modelo.getBbdds()) {
					jButton.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							modelo.getVista().getTablas().removeAll();;
							BBDD bbdd = null;
							try {
								bbdd = new BBDD(modelo.getConx(), jButton.getToolTipText());
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							ArrayList<JButton> listaBotones = new ArrayList<JButton>();
							for (String tabla : bbdd.getTablas()) {
								JButton botonTabla = new JButton(tabla.toUpperCase().replace("_", " "));
								botonTabla.setFont(botonTabla.getFont().deriveFont(10f));
								botonTabla.setToolTipText(tabla);
								listaBotones.add(botonTabla);
							}
							for (JButton botonTabla : listaBotones) {
								botonTabla.addActionListener(new ActionListener() {
									@Override
									public void actionPerformed(ActionEvent e) {
										// TODAS LAS POSIBLES TABLAS DE TODAS LAS BBDD. EN CASO DE ELEGIR UNA TABLA DE
										// OTRA BBDD: NO SE HA EJECUTADO UN USE BBDD(INSTANCIANDO BBDD) ASI QUE TAN SOLO DA ERROR
										packageDAO.DAO daoGenerico = null;
										if (botonTabla.getToolTipText().contains("jugador")) {
											// INSTANCIA CONCRETA DE DAO
											daoGenerico = new GestionJugador(Modelo.getConx());
										}
										if (botonTabla.getToolTipText().contains("equipo")) {
											daoGenerico = new GestionEquipo(Modelo.getConx());
											
										}
										if (botonTabla.getToolTipText().contains("departamento")) {
											daoGenerico = new GestionDepartamento(Modelo.getConx());
											
										}
										if (botonTabla.getToolTipText().contains("empleado")) {
											daoGenerico = new GestionEmpleado(Modelo.getConx());
											
										}
										if (botonTabla.getToolTipText().contains("alumno")) {
											daoGenerico = new GestionAlumno(Modelo.getConx());
											
										}
										if (botonTabla.getToolTipText().contains("asignatura")) {
											daoGenerico = new GestionAsignatura(Modelo.getConx());
											
										}
										if (botonTabla.getToolTipText().contains("matricula")) {
											daoGenerico = new GestionMatricula(Modelo.getConx());
											
										}
										if (botonTabla.getToolTipText().equalsIgnoreCase("Usuario")) {
											System.out.println("holiiis");
											daoGenerico = new GestionUsuario(Modelo.getConx());
											
										}
										if (botonTabla.getToolTipText().equalsIgnoreCase("Autor")) {
											daoGenerico = new GestionAutor(Modelo.getConx());
											
										}
										if (botonTabla.getToolTipText().equalsIgnoreCase("Libro")) {
											daoGenerico = new GestionLibro(Modelo.getConx());
											
										}
										if (botonTabla.getToolTipText().equalsIgnoreCase("Prestamo")) {
											daoGenerico = new GestionPrestamo(Modelo.getConx());
											
										}
										if (botonTabla.getToolTipText().equalsIgnoreCase("Libro_Autor")) {
											daoGenerico = new GestionLibroAutor(Modelo.getConx());
										}
										modelo.getVista().actualizarMenu(daoGenerico);
										modelo.getVista().actualizarRegistros(daoGenerico);
									}
								});
							}
							modelo.getVista().actualizarTabla(listaBotones);
							modelo.getVista().actualizarMenu(bbdd);

						}
					});
	
		};
	}
}
