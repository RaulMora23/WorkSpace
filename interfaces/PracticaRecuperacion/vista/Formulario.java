package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;

import controlador.Controlador;

import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;
import java.awt.Dimension;
import javax.swing.JSlider;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;

public class Formulario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JSlider slider = new JSlider();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario frame = new Formulario();
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
	public Formulario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 150, 750, 500);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel.setBounds(247, 11, 205, 40);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("FORMULARIO");
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel_1.setBounds(26, 62, 434, 376);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignOnBaseline(true);
		flowLayout.setVgap(15);
		panel_1.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBackground(SystemColor.activeCaption);
		panel_2.add(lblNewLabel_1);
		
		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(15);
		
		JPanel panel_2_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_2_1.getLayout();
		flowLayout_1.setVgap(15);
		panel_1.add(panel_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Apellido:");
		lblNewLabel_1_1.setBackground(SystemColor.activeCaption);
		panel_2_1.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(15);
		panel_2_1.add(textField_1);
		
		JPanel panel_2_2 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_2_2.getLayout();
		flowLayout_2.setVgap(15);
		panel_1.add(panel_2_2);
		
		JLabel lblNewLabel_2 = new JLabel("Genero:");
		panel_2_2.add(lblNewLabel_2);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Hombre");
		panel_2_2.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Mujer");
		panel_2_2.add(chckbxNewCheckBox_1);
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(chckbxNewCheckBox);
		grupo.add(chckbxNewCheckBox_1);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 15));
		
		JLabel lblNewLabel_3 = new JLabel("Turno");
		panel_3.add(lblNewLabel_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Mañana", "Tarde", "Noche"}));
		comboBox.setSelectedIndex(0);
		comboBox.setMaximumRowCount(3);
		panel_3.add(comboBox);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_4.getLayout();
		flowLayout_3.setVgap(15);
		panel_1.add(panel_4);
		
		JLabel lblNewLabel_4 = new JLabel("Numero de reservas:");
		panel_4.add(lblNewLabel_4);
		
		JSpinner spinner = new JSpinner();
		panel_4.add(spinner);
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5);
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_5 = new JLabel("Duracion: ");
		panel_5.add(lblNewLabel_5);
		
		
		slider.setMaximum(10);
		slider.setMajorTickSpacing(1);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		panel_5.add(slider);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(474, 11, 89, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0), 6, true));
		scrollPane.setBounds(495, 119, 177, 113);
		contentPane.add(scrollPane);
		
		JTextArea txtrSfgjsfgjhasgfdhjasgjhsafgdjsfgjsfgjsfgjsfgjsfgjsfgjsfgjsgfjsgfjsfgjSfgjsfgjsfgjSfgjsfgjsfgjsfgjsfgj = new JTextArea();
		scrollPane.setViewportView(txtrSfgjsfgjhasgfdhjasgjhsafgdjsfgjsfgjsfgjsfgjsfgjsfgjsfgjsgfjsgfjsfgjSfgjsfgjsfgjSfgjsfgjsfgjsfgjsfgj);
		txtrSfgjsfgjhasgfdhjasgjhsafgdjsfgjsfgjsfgjsfgjsfgjsfgjsfgjsgfjsgfjsfgjSfgjsfgjsfgjSfgjsfgjsfgjsfgjsfgj.setText("sfgjsfgjhasgfdhjasgjhsafgdjsfgjsfgjsfgjsfgjsfgjsfgjsfgjsgfjsgfjsfgj\r\n\r\nsfgjsfgjsfgj\r\nsfgjsfgjsfgjsfgjsfgj\r\nsgfjsgfj");
		btnNewButton.addActionListener(e ->{
			Controlador.mostrarResumen(this);
		});
		
	}
	public int getDuracion() {
		return (int) slider.getValue();
	}
}
