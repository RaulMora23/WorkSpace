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

import java.util.ArrayList;
import java.util.Objects;

public class AdminController {

    private DAO dao = new UsuarioDao();

    private Usuario usuario;

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @FXML
    private TextArea resultados;

    @FXML
    void buscar(ActionEvent event) {
        Stage stage = new Stage();
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
            resultados.clear();
            for (int i = 0; i < array.size(); i++) {
                resultados.appendText(array.get(i).toString() + "\n");
            }

            // Añadir los nuevos elementos
        });

        // Añadir el botón al HBox
        hbox.getChildren().add(but);

        // Mostrar la nueva ventana
        stage.show();
    }

    @FXML
    void crear(ActionEvent event) {
        Stage stage = new Stage();
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
                dialog.setContentText(dao.getClase().getSimpleName()+" creado");
                dialog.getDialogPane().getButtonTypes().add(ButtonType.OK); // Agrega un botón de "Aceptar"
                dialog.showAndWait();
            }catch (Exception e){
                Dialog dialog = new Dialog();
                dialog.setTitle("Error");
                dialog.setContentText("Error al crear el "+dao.getClase().getSimpleName());
                dialog.getDialogPane().getButtonTypes().add(ButtonType.OK); // Agrega un botón de "Aceptar"
                dialog.showAndWait();
            }finally {
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
    void desplegarEjemplar(ActionEvent event) {
        dao = new EjemplarDao();
    }

    @FXML
    void desplegarLibro(ActionEvent event) {
        dao = new LibroDao();
    }

    @FXML
    void desplegarPrestamo(ActionEvent event) {
        dao = new PrestamoDao();
    }

    @FXML
    void desplegarUsuario(ActionEvent event) {
        dao = new UsuarioDao();
    }

    @FXML
    void eliminar(ActionEvent event) {

    }

    @FXML
    void modificar(ActionEvent event) {

    }


}
