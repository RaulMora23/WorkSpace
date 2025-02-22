package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Modelo;
import packageDAO.DAO;
import sql.BBDD;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.FlowLayout;
import javax.swing.JTextArea;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;
	private Fondo contentPane;
	private Fondo tablas;
	private Fondo bbdds;
	private JPanel menu;
	private Fondo registros;
	private JButton btnNewButton;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Vista() {
		setTitle("Gestor JDBC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 600, 450);
		contentPane = new Fondo("\\Users\\rauln\\Desktop\\Curso\\Workspace\\accesoDatos\\Recursos\\FondoBBDD.png", 0.85f);
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestor BBDD");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(217, 11, 150, 30);
		contentPane.add(lblNewLabel);
		
		menu = new Fondo(null,0);
		menu.setBounds(297, 52, 277, 60);
		contentPane.add(menu);
		menu.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		registros = new Fondo(null,0);
		registros.setBounds(297, 123, 277, 277);
		contentPane.add(registros);
		registros.setLayout(new BorderLayout(0, 0));
		
		
		tablas = new Fondo(null,0);
		tablas.setBounds(157, 52, 130, 348);
		contentPane.add(tablas);
		tablas.setLayout(new GridLayout(0, 1, 0, 10));
		
		bbdds = new Fondo(null,0);
		bbdds.setBounds(10, 52, 130, 348);
		contentPane.add(bbdds);
		bbdds.setLayout(new GridLayout(0, 1, 0, 20));
	}

	public void actualizarMenu(BBDD bbdd) {
		menu.removeAll();
		
		JButton btnNewButton = new JButton("Eliminar "+bbdd.getNombreBbdd());
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					bbdd.eliminarBBDD(Modelo.getConx());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
			}
		});
		menu.add(btnNewButton);	
		menu.updateUI();
		contentPane.updateUI();
	}
	public void actualizarMenu(DAO daoGenerico) {
		menu.removeAll();
		
		JButton btnNewButton = new JButton("Añadir "+daoGenerico.getMetaDatos().getNombre());
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//AQUI FALTA QUE SE ABRA UNA NUEVA VENTANA, TOME DATOS Y DESPUES UTILIZE EL DAO GENERICO
			}
		});
		menu.add(btnNewButton);	
		menu.updateUI();
		contentPane.updateUI();
		
	}
	public void actualizarRegistros(DAO daoGenerico) {
		registros.removeAll();
		scrollPane = new JScrollPane();
		registros.add(scrollPane, BorderLayout.CENTER);
		System.out.println(daoGenerico.mostrarTabla(daoGenerico.obtenerTabla(Modelo.getConx(), daoGenerico.getMetaDatos())));
		scrollPane.add(new JTextArea(daoGenerico.mostrarTabla(daoGenerico.obtenerTabla(Modelo.getConx(), daoGenerico.getMetaDatos()))));
		registros.updateUI();
		scrollPane.updateUI();
		contentPane.updateUI();
	}

	public void actualizarBBDD(ArrayList<JButton> botones) {
		for (JButton jButton : botones) {
			bbdds.add(jButton);
		}
		bbdds.updateUI();
		contentPane.repaint();
	}

	
	public void actualizarTabla(ArrayList<JButton> botones) {
		for (JButton jButton : botones) {
			tablas.add(jButton);
		}
		tablas.updateUI();
		contentPane.repaint();
	}

	public Fondo getBbdds() {
		return bbdds;
	}

	public void setBbdds(Fondo bbdds) {
		this.bbdds = bbdds;
	}

	public Fondo getTablas() {
		return tablas;
	}

	public void setTablas(Fondo tablas) {
		this.tablas = tablas;
	}

	public JPanel getMenu() {
		return menu;
	}

	public void setMenu(Fondo menu) {
		this.menu = menu;
	}

	public Fondo getRegistros() {
		return registros;
	}

	public void setRegistros(Fondo registros) {
		this.registros = registros;
	}
}
