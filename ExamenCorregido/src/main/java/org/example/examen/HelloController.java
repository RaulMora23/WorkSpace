package org.example.examen;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import javax.swing.*;

import javafx.event.ActionEvent;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * Controlador de la aplicación JavaFX para generar y exportar reportes en formato PDF.
 * Utiliza JasperReports para generar los reportes y se conecta a una base de datos MySQL.
 *
 * @Author Raul
 */
public class HelloController {
    //El primer error era del fxml al utilizar id en lugar de fx:id
    @FXML
    private DatePicker inicio;
    @FXML
    private DatePicker fin;
    @FXML
    private HBox contenedor;

    private JasperPrint jasperPrint;

    /**
     * Método para generar un reporte de pedidos basado en las fechas seleccionadas.
     *
     * @param event Evento de acción que desencadena este método.
     * @throws SQLException Si ocurre un error al conectarse a la base de datos.
     * @throws JRException Si ocurre un error al generar el reporte con JasperReports.
     */
    @FXML
    public void pedido(ActionEvent event) throws SQLException, JRException {
        System.out.println("Pedido");
        if (inicio != null || fin != null) {
            //Por aquí dejaba de compilar null.toString()
            //Use sql.Data o util.data para pasar por parámetro mala idea, lo mas resultón es String y parsearlo con comillas o lo que fuera
            String inicio = this.inicio.getValue().toString();
            String fin = this.fin.getValue().toString();
            System.out.println(inicio);
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("inicio", inicio);
            parametros.put("fin", fin);
            //No había fecha en los parámetros, tampoco llegue a ver el pdf.
            parametros.put("fecha", LocalDate.now().toString());
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tiendajuegosmesa", "root", "contraseña");
            jasperPrint = JasperFillManager.fillReport("src/main/resources/JaspertReport/pedido.jasper", parametros, con);
            //Esto lo cociné la noche anterior porque en la implementación de jasper que hago en la app de biblioteca
            // uso JasperViewer para mostrar y guardar pero no tiene para pdf
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar PDF");
            fileChooser.setSelectedFile(new File("reporte.pdf"));

            int userSelection = fileChooser.showSaveDialog(null);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                if (!fileToSave.getName().toLowerCase().endsWith(".pdf")) {
                    fileToSave = new File(fileToSave.getAbsolutePath() + ".pdf");
                }

                // Guardar el PDF en la ubicación elegida
                byte[] pdfBytes = null;
                try {
                    pdfBytes = JasperExportManager.exportReportToPdf(jasperPrint);
                } catch (JRException e) {
                    throw new RuntimeException(e);
                }
                try (FileOutputStream fos = new FileOutputStream(fileToSave)) {
                    fos.write(pdfBytes);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                con.close();
                System.out.println("PDF guardado en: " + fileToSave.getAbsolutePath());
            }
        }
    }
    /**
     * Método para generar un reporte de juegos
     *
     * @param event Evento de acción que desencadena este método.
     * @throws SQLException Si ocurre un error al conectarse a la base de datos.
     * @throws JRException Si ocurre un error al generar el reporte con JasperReports.
     */
    @FXML
    public void juego(ActionEvent event) throws SQLException, JRException {
        System.out.println("Juego");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tiendajuegosmesa", "root", "contraseña");
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("fecha", LocalDate.now().toString());
        jasperPrint = JasperFillManager.fillReport("src/main/resources/JaspertReport/juego.jasper", parametros, con);

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar PDF");
        fileChooser.setSelectedFile(new File("reporte.pdf"));

        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            if (!fileToSave.getName().toLowerCase().endsWith(".pdf")) {
                fileToSave = new File(fileToSave.getAbsolutePath() + ".pdf");
            }

            // Guardar el PDF en la ubicación elegida
            byte[] pdfBytes = null;
            try {
                pdfBytes = JasperExportManager.exportReportToPdf(jasperPrint);
            } catch (JRException e) {
                throw new RuntimeException(e);
            }
            try (FileOutputStream fos = new FileOutputStream(fileToSave)) {
                fos.write(pdfBytes);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            //No cerraba BBDD
            con.close();
            System.out.println("PDF guardado en: " + fileToSave.getAbsolutePath());
        }
    }
    /**
     * Método para abrir un archivo de ayuda en el navegador predeterminado del sistema.
     *
     * @throws IOException Si ocurre un error al abrir el archivo de ayuda.
     */
    //No había ayuda ni documentación suficiente
    public void ayuda() throws IOException {
        System.out.println(LocalDate.now());
        Desktop.getDesktop().open(new File("src/main/resources/ayuda.html"));
    }


}