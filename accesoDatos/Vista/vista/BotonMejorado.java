package vista;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.io.Serializable;

import javax.swing.JButton;

public class BotonMejorado extends JButton implements Serializable {

	private Color color1 = null;
	private Color color2 = null;
	private Color fondo = null;
	private boolean circular = false;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Constructores segun necesidad del desarrollador
	public BotonMejorado(String texto) {
		super(texto);
	}

	public BotonMejorado(String texto, Color color1, Color color2) {
		super(texto);
		this.color1 = color1;
		this.color2 = color2;
	}

	public BotonMejorado(String texto, Color color1, Color color2, boolean circular) {
		super(texto);
		this.color1 = color1;
		this.color2 = color2;
		this.circular = circular;
	}

	public BotonMejorado(String texto, boolean circular) {
		super(texto);
		this.circular = circular;
	}
	public BotonMejorado(String texto, boolean circular, Color fondo) {
		super(texto);
		this.circular = circular;
		this.fondo = fondo;
	}
	
	//Metodo clave que se ejecuta cada vez que instancias o que llamas al metodo repaint()
	//Graphics es una clase abstracta sin hijos que poder instanciar, lo que hace necesario el @Override para poder trabajar con la instancia de Graphics del botón
	@Override
	protected void paintComponent(Graphics g) {
		Graphics gCopy = g.create();
		Graphics2D g2d = (Graphics2D) gCopy;
			//Se definen las caracteristicas
			
			if (circular == true && color1==null) {
				//Hace el borde invisible
				setBorderPainted(false);
				if(fondo==null) {
					//Elige color para pintar
					g2d.setPaint(Color.LIGHT_GRAY);
				}else {
					g2d.setPaint(fondo);
				}
				//Elimina el contenido previo
				g2d.setClip(getVisibleRect());
				//Rellena con el color establecido
				g2d.fill(new Ellipse2D.Double(0, 0, this.getWidth(), this.getHeight()));
				//Vuelve a aplicar la pintura por defecto (Para el texto)
				g2d.setPaint(g.getColor());
				//Evita problemas con el fondo de los botones circulares
				setOpaque(false);
				
			}
			if (color1 != null && circular==false) {
				g2d.setPaint(new GradientPaint(0, 0, color1, getWidth(), getHeight(), color2));
				g2d.fill(getVisibleRect());
				g2d.setPaint(g.getColor());
			}
			if(color1!=null && circular==true) {
				setBorderPainted(false);
				g2d.setPaint(new GradientPaint(0, 0, color1, getWidth(), getHeight(), color2));
				g2d.clip(getVisibleRect());
				g2d.fill(new Ellipse2D.Double(0, 0, this.getWidth(), this.getHeight()));
				g2d.setPaint(g.getColor());
				setOpaque(false);
			}
			//Se escribe el texto del botón
			if (!getText().isEmpty()) {
				while(g2d.getFontMetrics().stringWidth(getText())>this.getWidth()) {
					g2d.getFont().deriveFont(g2d.getFont().getSize()-0.1f);
				}
				g2d.drawString(getText(), getWidth() / 2 - g2d.getFontMetrics().stringWidth(getText()) / 2,
						getHeight() / 2 + g2d.getFontMetrics().getHeight() / 2);
			}
		
		gCopy.dispose();
		g2d.dispose();
	}

	

	public Color getColor1() {
		return color1;
	}

	public Color getColor2() {
		return color2;
	}

	public void setDegradado(Color color1,Color color2) {
		this.color1 = color1;
		this.color2 = color2;
		//Aplicar cambios
		repaint();
	}

	public Color getFondo() {
		return fondo;
	}

	public void setFondo(Color fondo) {
		this.fondo = fondo;
		repaint();
	}

	public boolean isCircular() {
		return circular;
	}

	public void setCircular(boolean circular) {
		this.circular = circular;
		repaint();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
