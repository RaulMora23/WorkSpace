package nuevoJPanel;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.Serial;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Fondo extends JPanel implements Serializable {
	/**
	 * 
	 */
	@Serial
	private static final long serialVersionUID = 1L;
        private Propiedades propiedades = new Propiedades();
        
        public Fondo(){
            
        }
        
	public Fondo(String ruta,float opacidad){
		propiedades.setImagen(new ImageIcon(ruta).getImage());
                propiedades.setOpacidad(opacidad);	
	}
	@Override
	protected void paintComponent(Graphics g) {
		//super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, propiedades.getOpacidad()));
		if(propiedades.getImagen()!=null) {
		g2d.drawImage(propiedades.getImagen(),0,0,getWidth(),getHeight(), this);
		}
		g2d.dispose();
	}

    public Propiedades getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(Propiedades propiedades) {
        this.propiedades = propiedades;
        this.repaint();
    }

    
    
        
}
