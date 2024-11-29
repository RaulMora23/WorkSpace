package vista;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;

public class VistaMenu extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public VistaMenu() {
		setLayout(new GridLayout(1, 0, 20, 20));
		
		JButton btnNewButton = new JButton("New button");
		add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("New button");
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		add(btnNewButton_3);
		
		JButton btnNewButton_1 = new JButton("New button");
		add(btnNewButton_1);
		
	}

}
