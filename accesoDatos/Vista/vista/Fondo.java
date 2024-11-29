package vista;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Fondo extends JPanel implements Serializable {
	/**
	 * 
	 */
	public Fondo (){
		
	}
	private static final long serialVersionUID = 1L;
	private Image imagen;
	private float opacidad;
	public Fondo(String ruta,float opacidad){
		this.imagen = new ImageIcon(ruta).getImage();
		this.opacidad= opacidad;
	}
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacidad));
		if(imagen!=null) {
		g2d.drawImage(imagen,0,0,getWidth(),getHeight(), this);
		}
		g2d.dispose();
	}
}
