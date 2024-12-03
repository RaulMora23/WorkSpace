/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/PropertyEditor.java to edit this template
 */
package nuevoJPanel;

import java.awt.Component;
import java.beans.*;

/**
 *
 * @author rauln
 */
public class FondoPropertyEditor extends PropertyEditorSupport {
    
   private PanelFondo panelEditor = new PanelFondo();

    @Override
    public boolean supportsCustomEditor() {
        return true; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public Component getCustomEditor() {
        return panelEditor; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public String getJavaInitializationString() {
        return null; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public Object getValue() {
        return panelEditor.getSelectedValue(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
}
