package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import nuevoBoton.BotonMejorado;

import javax.swing.JButton;

public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private BotonMejorado botonUsuario;


	/**
	 * Create the frame.
	 */
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		botonUsuario = new BotonMejorado("Boton Aleatorio... Púlsame!",true);
		botonUsuario.setBounds(52, 17, 228, 131);
		contentPane.add(botonUsuario);
		
		botonUsuario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				botonUsuario.setDegradado(new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255)), new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255)));
				if(Math.random()<0.5) {
					botonUsuario.setCircular(false);
				}else {
					botonUsuario.setCircular(true);
				}
			}
		});
		
		BotonMejorado btnNewButton_1 = new BotonMejorado("New button",true,Color.yellow);
		btnNewButton_1.setBounds(263, 159, 161, 91);
		contentPane.add(btnNewButton_1);
		
		BotonMejorado btnNewButton_2 = new BotonMejorado("New button",Color.blue,Color.green);
		btnNewButton_2.setBounds(317, 17, 107, 52);
		contentPane.add(btnNewButton_2);
		
		BotonMejorado btnNewButton_3 = new BotonMejorado("New button",Color.blue,Color.green,true);
		btnNewButton_3.setBounds(10, 159, 129, 91);
		contentPane.add(btnNewButton_3);
		//Se pueden alterar botones una vez instanciados
		btnNewButton_3.setDegradado(Color.black,Color.red);
	}


	public BotonMejorado getBotonUsuario() {
		return botonUsuario;
	}


	public void setBotonUsuario(BotonMejorado botonUsuario) {
		this.botonUsuario = botonUsuario;
	}
	
	
}
