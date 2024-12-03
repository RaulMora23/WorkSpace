/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nuevoBoton;

import java.awt.Component;
import java.beans.PropertyEditorSupport;

/**
 *
 * @author Raul Mora
 */
// Clase para enlazar el nuevo componente con el nuevo panel de edicion que he creado:
public class DegradadoPropertyEditor extends PropertyEditorSupport {
    
    private PanelDegradado panelEditor = new PanelDegradado();

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
