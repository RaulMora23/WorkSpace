package nuevoJPanel;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Test {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        File file = null;// Muestra el cuadro de diálogo de apertura
        if (result == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile(); // Obtiene el archivo seleccionado
        }
        Fondo contentPane = new Fondo(file.getAbsolutePath(), 0.5f);
        frame.setTitle("Fondo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(contentPane);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setMinimumSize(new Dimension(200,250));
        frame.pack();
    }
}
