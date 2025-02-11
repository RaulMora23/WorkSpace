package vista;

import dao.*;
import dto.Ejemplar;
import dto.Libro;
import dto.Prestamo;
import dto.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;


import java.time.LocalDate;
import java.util.*;

public class AdminController {

    private DAO dao = new UsuarioDao();
    //Esto está pensado para el caso de usuario no administrador
    private Usuario usuario;

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    private ResourceBundle bundle;

    private void cambiarIdioma(Locale locale) {
        bundle = ResourceBundle.getBundle("idioma", locale);
        buscar.setText(bundle.getString("search"));
        crear.setText(bundle.getString("create"));
        eliminar.setText(bundle.getString("delete"));
        modificar.setText(bundle.getString("update"));
        buscar.setTooltip(new Tooltip(bundle.getString("searchTool")));
        crear.setTooltip(new Tooltip(bundle.getString("createTool")));
        eliminar.setTooltip(new Tooltip(bundle.getString("deleteTool")));
        modificar.setTooltip(new Tooltip(bundle.getString("updateTool")));
    }

    public void initialize() {
        // Idioma inicial (Español por defecto)
        bundle = ResourceBundle.getBundle("idioma", new Locale("es"));

        // Configuración del ComboBox con opciones de idioma
        idioma.getItems().addAll("Español", "English");
        idioma.setValue("Español"); // Idioma inicial

        // Cambiar idioma cuando se selecciona una opción
        idioma.setOnAction(event -> {
            String idiomaSeleccionado = idioma.getValue();
            switch (idiomaSeleccionado) {
                case "English":
                    cambiarIdioma(new Locale("en"));
                    break;
                default:
                    cambiarIdioma(new Locale("es"));
                    break;
            }
        });
        buscar.setTooltip(new Tooltip(bundle.getString("searchTool")));
        crear.setTooltip(new Tooltip(bundle.getString("createTool")));
        eliminar.setTooltip(new Tooltip(bundle.getString("deleteTool")));
        modificar.setTooltip(new Tooltip(bundle.getString("updateTool")));
    }

    @FXML
    private Button buscar;

    @FXML
    private Button crear;

    @FXML
    private Button eliminar;

    @FXML
    private Button modificar;

    @FXML
    private ComboBox<String> idioma;

    String rutaJasper;

    @FXML
    void desplegarEjemplar(ActionEvent event) {
        dao = new EjemplarDao();
        rutaJasper ="src/main/resources/JasperReport/ejemplares.jasper";
    }

    @FXML
    void desplegarLibro(ActionEvent event) {
        dao = new LibroDao();
        rutaJasper ="src/main/resources/JasperReport/libros.jasper";
    }

    @FXML
    void desplegarPrestamo(ActionEvent event) {
        dao = new PrestamoDao();
        rutaJasper ="src/main/resources/JasperReport/prestamos.jasper";
    }

    @FXML
    void desplegarUsuario(ActionEvent event) {
        dao = new UsuarioDao();
        rutaJasper ="src/main/resources/JasperReport/usuarios.jasper";
    }

    @FXML
    private TextArea resultados;

    @FXML
    void buscar(ActionEvent event) {
        Stage stage = new Stage();
        stage.setTitle(bundle.getString("searchTool"));
        HBox hbox = new HBox();
        // Configurar alineación y espaciado
        hbox.setAlignment(Pos.CENTER); // Centra los elementos
        hbox.setSpacing(20);
        stage.setScene(new Scene(hbox));
        for (String campo : dao.getCampos()) {
            TextField tf = new TextField();
            tf.setPromptText(campo);
            hbox.getChildren().add(tf);
        }
        ArrayList<String> campos = new ArrayList<>();
        ArrayList<String> valores = new ArrayList<>();
        Button but = new Button("Buscar");
        but.setDefaultButton(true);
        but.setOnAction(event1 -> {
            for (Node tf : hbox.getChildren()) {
                if (tf instanceof TextField) {
                    if (!Objects.equals(((TextField) tf).getText(), "")) {
                        campos.add(((TextField) tf).getPromptText());
                        valores.add(((TextField) tf).getText());
                    }
                }
            }
            ArrayList<?> array;
            if (campos.size() > 0) {
                array = dao.readBy(campos, valores);
            }else{
                array = dao.readAll();
            }
            campos.clear();
            valores.clear();
            resultados.clear();
            for (int i = 0; i < array.size(); i++) {
                resultados.appendText(array.get(i).toString() + "\n");
            }

            stage.close();
        });

        // Añadir el botón al HBox
        hbox.getChildren().add(but);

        // Mostrar la nueva ventana
        stage.show();
    }

    @FXML
    void reporte(ActionEvent event) {
        Stage stage = new Stage();
        stage.setTitle(bundle.getString("searchTool"));
        HBox hbox = new HBox();
        // Configurar alineación y espaciado
        hbox.setAlignment(Pos.CENTER); // Centra los elementos
        hbox.setSpacing(20);
        stage.setScene(new Scene(hbox));
        for (String campo : dao.getCampos()) {
            TextField tf = new TextField();
            tf.setPromptText(campo);
            hbox.getChildren().add(tf);
        }
        ArrayList<String> campos = new ArrayList<>();
        ArrayList<String> valores = new ArrayList<>();
        Button but = new Button("Buscar");
        but.setDefaultButton(true);
        but.setOnAction(event1 -> {
            for (Node tf : hbox.getChildren()) {
                if (tf instanceof TextField) {
                    if (!Objects.equals(((TextField) tf).getText(), "")) {
                        campos.add(((TextField) tf).getPromptText());
                        valores.add(((TextField) tf).getText());
                    }
                }
            }
            ArrayList<?> array;
            if (campos.size() > 0) {
                array = dao.readBy(campos, valores);
                ArrayList<?> arraySimple = new ArrayList<>();
                for (int i = 0; i < array.size(); i++) {
                    arraySimple.add(dao.getSimpleData(array.get(i)));
                }
                // Convertir lista en un JRBeanCollectionDataSource
                JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(arraySimple);

                // Parámetros del reporte
                Map<String, Object> parametros = new HashMap<>();
                parametros.put("Fecha", "Fecha: " + LocalDate.now());

                // Cargar el archivo .jasper
                JasperPrint jasperPrint = null;
                try {
                    jasperPrint = JasperFillManager.fillReport(rutaJasper, parametros, dataSource);
                } catch (JRException e) {
                    throw new RuntimeException(e);
                }

                // Mostrar el reporte
                JasperViewer.viewReport(jasperPrint, false);
            }else{
                array = dao.readAll();
                ArrayList<?> arraySimple = new ArrayList<>();
                for (int i = 0; i < array.size(); i++) {
                    arraySimple.add(dao.getSimpleData(array.get(i)));
                }
                // Convertir lista en un JRBeanCollectionDataSource
                JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(arraySimple);

                // Parámetros del reporte
                Map<String, Object> parametros = new HashMap<>();
                parametros.put("Fecha", "Fecha: " + LocalDate.now());

                // Cargar el archivo .jasper
                JasperPrint jasperPrint = null;
                try {
                    jasperPrint = JasperFillManager.fillReport(rutaJasper, parametros, dataSource);
                } catch (JRException e) {
                    throw new RuntimeException(e);
                }

                // Mostrar el reporte
                JasperViewer.viewReport(jasperPrint, false);
            }
            campos.clear();
            valores.clear();
            stage.close();
        });

        // Añadir el botón al HBox
        hbox.getChildren().add(but);

        // Mostrar la nueva ventana
        stage.show();
    }
    @FXML
    void crear(ActionEvent event) {
        Stage stage = new Stage();
        stage.setTitle(bundle.getString("createTool"));
        HBox hbox = new HBox();
        // Configurar alineación y espaciado
        hbox.setAlignment(Pos.CENTER); // Centra los elementos
        hbox.setSpacing(20);
        stage.setScene(new Scene(hbox));
        for (int i = 1; i < dao.getCampos().size(); i++) {
            TextField tf = new TextField();
            tf.setPromptText(dao.getCampos().get(i));
            hbox.getChildren().add(tf);
        }
        ArrayList<String> valores = new ArrayList<>();
        Button but = new Button("Crear");
        but.setDefaultButton(true);
        but.setOnAction(event1 -> {
            try {
                for (Node tf : hbox.getChildren()) {
                    if (tf instanceof TextField) {
                        valores.add(((TextField) tf).getText());
                    }
                }
                if (dao.getClase().equals(Ejemplar.class)) {
                    Ejemplar e = new Ejemplar(valores);
                    dao.insert(new ObjetoGenerico(e, e.getClass()));
                }

                if (dao.getClase().equals(Usuario.class)) {
                    Usuario u = new Usuario(valores);
                    dao.insert(new ObjetoGenerico(u, u.getClass()));
                }

                if (dao.getClase().equals(Libro.class)) {
                    Libro l = new Libro(valores);
                    dao.insert(new ObjetoGenerico(l, l.getClass()));
                }

                if (dao.getClase().equals(Prestamo.class)) {
                    Prestamo p = new Prestamo(valores);
                    dao.insert(new ObjetoGenerico(p, p.getClass()));
                }
                stage.close();
                Dialog dialog = new Dialog();
                dialog.setTitle("Correcto");
                dialog.setContentText(dao.getClase().getSimpleName() + " creado");
                dialog.getDialogPane().getButtonTypes().add(ButtonType.OK); // Agrega un botón de "Aceptar"
                dialog.showAndWait();
            } catch (Exception e) {
                Dialog dialog = new Dialog();
                dialog.setTitle("Error");
                dialog.setContentText("Error al crear el " + dao.getClase().getSimpleName());
                dialog.getDialogPane().getButtonTypes().add(ButtonType.OK); // Agrega un botón de "Aceptar"
                dialog.showAndWait();
            } finally {
                valores.clear();
            }
            // Añadir los nuevos elementos
        });

        // Añadir el botón al HBox
        hbox.getChildren().add(but);

        // Mostrar la nueva ventana
        stage.show();
    }

    @FXML
    void eliminar(ActionEvent event) {
        Stage stage = new Stage();
        stage.setTitle(bundle.getString("deleteTool"));
        HBox hbox = new HBox();
        // Configurar alineación y espaciado
        hbox.setAlignment(Pos.CENTER); // Centra los elementos
        hbox.setSpacing(20);
        stage.setScene(new Scene(hbox));
        for (String campo : dao.getCampos()) {
            TextField tf = new TextField();
            tf.setPromptText(campo);
            hbox.getChildren().add(tf);
        }
        ArrayList<String> campos = new ArrayList<>();
        ArrayList<String> valores = new ArrayList<>();
        Button but = new Button("Eliminar");
        but.setDefaultButton(true);
        but.setOnAction(event1 -> {
            for (Node tf : hbox.getChildren()) {
                if (tf instanceof TextField) {
                    if (!Objects.equals(((TextField) tf).getText(), "")) {
                        campos.add(((TextField) tf).getPromptText());
                        valores.add(((TextField) tf).getText());
                    }
                }
            }
            System.out.println(campos);
            System.out.println(valores);
            ArrayList<?> array = dao.readBy(campos, valores);
            campos.clear();
            valores.clear();
            try {
                for (int i = 0; i < array.size(); i++) {
                    dao.delete(new ObjetoGenerico(array.get(i), dao.getClase()));
                }
                stage.close();
                Dialog dialog = new Dialog();
                dialog.setTitle("Correcto");
                dialog.setContentText("Se han eliminado " + array.size() + " elementos");
                dialog.getDialogPane().getButtonTypes().add(ButtonType.OK); // Agrega un botón de "Aceptar"
                dialog.showAndWait();
            } catch (Exception e) {
                Dialog dialog = new Dialog();
                dialog.setTitle("Error");
                dialog.setContentText("No se han eliminado elementos");
                dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
                dialog.showAndWait();
            }
        });

        // Añadir el botón al HBox
        hbox.getChildren().add(but);

        // Mostrar la nueva ventana
        stage.show();
    }

    @FXML
    void modificar(ActionEvent event) {
        Stage stage = new Stage();
        stage.setTitle(bundle.getString("updateTool"));
        HBox hbox = new HBox();
        // Configurar alineación y espaciado
        hbox.setAlignment(Pos.CENTER); // Centra los elementos
        hbox.setSpacing(20);
        stage.setScene(new Scene(hbox));
        TextField tf = new TextField();
        tf.setPromptText(dao.getCampos().get(0));
        hbox.getChildren().add(tf);
        Button but = new Button("Buscar");
        but.setDefaultButton(true);
        but.setOnAction(event1 -> {
            try {
                if (dao.getClase().equals(Libro.class)) {
                    Libro libro = dao.read(tf.getText());
                    stage.close();
                    Stage stage2 = new Stage();
                    stage2.setTitle(bundle.getString("updateTool"));
                    HBox hbox2 = new HBox();
                    // Configurar alineación y espaciado
                    hbox2.setAlignment(Pos.CENTER); // Centra los elementos
                    hbox2.setSpacing(20);
                    stage2.setScene(new Scene(hbox2));
                    ArrayList<String> valores = libro.getValores();
                    for (int i = 1; i < dao.getCampos().size(); i++) {
                        TextField tf2 = new TextField();
                        tf2.setPromptText(dao.getCampos().get(i));
                        tf2.setText(valores.get(i - 1));
                        hbox2.getChildren().add(tf2);
                    }
                    Button but2 = new Button("Modificar");
                    but2.setDefaultButton(true);
                    but2.setOnAction(event2 -> {
                        for (Node nodo : hbox2.getChildren()) {
                            if (nodo instanceof TextField) {
                                valores.add(((TextField) nodo).getText());
                            }
                        }
                        Libro l = new Libro(valores);
                        l.setIsbn(libro.getIsbn());
                        dao.update(new ObjetoGenerico(l, l.getClass()));
                        stage2.close();
                        Dialog dialog = new Dialog();
                        dialog.setTitle("Correcto");
                        dialog.setContentText(dao.getClase().getSimpleName()+" modificado");
                        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
                        dialog.showAndWait();
                    });
                    hbox2.getChildren().add(but2);
                    stage2.show();
                }
                if (dao.getClase().equals(Prestamo.class)) {
                    Prestamo prestamo = dao.read(Integer.parseInt(tf.getText()));
                    stage.close();
                    Stage stage3 = new Stage();
                    stage3.setTitle(bundle.getString("updateTool"));
                    HBox hbox3 = new HBox();
                    // Configurar alineación y espaciado
                    hbox3.setAlignment(Pos.CENTER); // Centra los elementos
                    hbox3.setSpacing(20);
                    stage3.setScene(new Scene(hbox3));
                    ArrayList<String> valores = prestamo.getValores();
                    for (int i = 1; i < dao.getCampos().size(); i++) {
                        TextField tf3 = new TextField();
                        tf3.setPromptText(dao.getCampos().get(i));
                        tf3.setText(valores.get(i - 1));
                        hbox3.getChildren().add(tf3);
                    }
                    Button but3 = new Button("Modificar");
                    but3.setDefaultButton(true);
                    but3.setOnAction(event3 -> {
                        for (Node nodo : hbox3.getChildren()) {
                            if (nodo instanceof TextField) {
                                valores.add(((TextField) nodo).getText());
                            }
                        }
                        Prestamo p = new Prestamo(valores);

                        p.setId(prestamo.getId());

                        dao.update(new ObjetoGenerico(p, p.getClass()));
                        stage3.close();
                        Dialog dialog = new Dialog();
                        dialog.setTitle("Correcto");
                        dialog.setContentText(dao.getClase().getSimpleName()+" modificado");
                        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
                        dialog.showAndWait();
                    });
                    hbox3.getChildren().add(but3);
                    stage3.show();
                }
                if (dao.getClase().equals(Usuario.class)) {
                    Usuario usuario = dao.read(Integer.parseInt(tf.getText()));
                    stage.close();
                    Stage stage4 = new Stage();
                    stage4.setTitle(bundle.getString("updateTool"));
                    HBox hbox4 = new HBox();
                    // Configurar alineación y espaciado
                    hbox4.setAlignment(Pos.CENTER); // Centra los elementos
                    hbox4.setSpacing(20);
                    stage4.setScene(new Scene(hbox4));
                    ArrayList<String> valores = usuario.getValores();
                    for (int i = 1; i < dao.getCampos().size(); i++) {
                        TextField tf3 = new TextField();
                        tf3.setPromptText(dao.getCampos().get(i));
                        tf3.setText(valores.get(i - 1));
                        hbox4.getChildren().add(tf3);
                    }
                    Button but4 = new Button("Modificar");
                    but4.setDefaultButton(true);
                    but4.setOnAction(event3 -> {
                        valores.clear();
                        for (Node nodo : hbox4.getChildren()) {
                            if (nodo instanceof TextField) {
                                valores.add(((TextField) nodo).getText());
                            }
                        }
                        Usuario u = new Usuario(valores);
                        valores.clear();
                        u.setId(usuario.getId());
                        dao.update(new ObjetoGenerico(u, u.getClass()));
                        stage4.close();
                        Dialog dialog = new Dialog();
                        dialog.setTitle("Correcto");
                        dialog.setContentText(dao.getClase().getSimpleName()+" modificado");
                        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
                        dialog.showAndWait();
                    });
                    hbox4.getChildren().add(but4);
                    stage4.show();
                }
                if (dao.getClase().equals(Ejemplar.class)) {
                    Ejemplar ejemplar = dao.read(Integer.parseInt(tf.getText()));
                    stage.close();
                    Stage stage5 = new Stage();
                    stage5.setTitle(bundle.getString("updateTool"));
                    HBox hbox5 = new HBox();
                    // Configurar alineación y espaciado
                    hbox5.setAlignment(Pos.CENTER); // Centra los elementos
                    hbox5.setSpacing(20);
                    stage5.setScene(new Scene(hbox5));
                    ArrayList<String> valores = ejemplar.getValores();
                    for (int i = 1; i < dao.getCampos().size(); i++) {
                        TextField tf5 = new TextField();
                        tf5.setPromptText(dao.getCampos().get(i));
                        tf5.setText(valores.get(i - 1));
                        hbox5.getChildren().add(tf5);
                    }
                    Button but5 = new Button("Modificar");
                    but5.setDefaultButton(true);
                    but5.setOnAction(event3 -> {
                        for (Node nodo : hbox5.getChildren()) {
                            if (nodo instanceof TextField) {
                                valores.add(((TextField) nodo).getText());
                            }
                        }
                        Ejemplar e = new Ejemplar(valores);
                        e.setId(ejemplar.getId());
                        dao.update(new ObjetoGenerico(e, e.getClass()));
                        stage5.close();
                        Dialog dialog = new Dialog();
                        dialog.setTitle("Correcto");
                        dialog.setContentText(dao.getClase().getSimpleName()+" modificado");
                        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
                        dialog.showAndWait();
                    });
                    hbox5.getChildren().add(but5);
                    stage5.show();
                }

            } catch (Exception e) {
                Dialog dialog = new Dialog();
                dialog.setTitle("Error");
                dialog.setContentText("Error al modificar el " + dao.getClase().getSimpleName());
                dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
                dialog.showAndWait();
            }
        });

        // Añadir el botón al HBox
        hbox.getChildren().add(but);

        // Mostrar la nueva ventana
        stage.show();

    }
}



