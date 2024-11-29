package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import nuevoBoton.BotonMejorado;
import vista.Vista;

public class Main {

	public static void main(String[] args) {
		Vista vista = new Vista();
		vista.setVisible(true);
		//Posibles cambios aplicados por el usuario
		//vista.getBotonUsuario().setDegradado(Color.green, Color.white);
		//vista.getBotonUsuario().setSize(120,120);
	}

}
