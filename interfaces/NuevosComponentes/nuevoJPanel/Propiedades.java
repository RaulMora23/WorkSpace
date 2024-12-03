/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nuevoJPanel;

import java.awt.Image;

/**
 *
 * @author rauln
 */
class Propiedades {
    private Image imagen;
    private float opacidad;
    
    public Propiedades(){
        
    }

    public Propiedades(Image imagen, float opacidad) {
        this.imagen = imagen;
        this.opacidad = opacidad;
    }
    
    

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    public float getOpacidad() {
        return opacidad;
    }

    public void setOpacidad(float opacidad) {
        this.opacidad = opacidad;
    }
    
    
}
