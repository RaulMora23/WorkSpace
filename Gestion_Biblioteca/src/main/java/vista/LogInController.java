package vista;

import dao.DAO;
import dao.UsuarioDao;
import dto.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LogInController {
    private AdminController adminController;
    private UsuarioController usuarioController;
    private static Stage stage;

    public static void closeWindow() {
        stage.close();
    }
    public static void openWindow() {
        stage.show();
    }

    public void setStage(Stage stage) {
        LogInController.stage = stage;
    }

    @FXML
    private PasswordField contraseña;

    @FXML
    private TextField usuario;

    @FXML
    void acceder(ActionEvent event) throws IOException {
        DAO dao = new UsuarioDao();
        ArrayList<Usuario> lista = dao.readBy(List.of("email","password"),List.of(usuario.getText(),contraseña.getText()));
        if (lista.isEmpty()) {
            Dialog<String> dialog = new Dialog<>();
            dialog.setTitle("Error");
            dialog.setContentText("Usuario no encontrado");
            dialog.getDialogPane().getButtonTypes().add(ButtonType.OK); // Agrega un botón de "Aceptar"
            dialog.showAndWait();
        }
        else{
            Usuario u = lista.getFirst();
            if(u.getTipo().equals("administrador")){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Admin.fxml"));

                // Cargar la interfaz gráfica desde el archivo FXML
                Parent root = loader.load();
                adminController = loader.getController();
                adminController.setUsuario(u);
                adminController.initialize();
                // Configurar la escena con el layout cargado desde el archivo FXML
                Scene scene = new Scene(root);

                Stage stage = new Stage();
                // Configurar el título de la ventana
                stage.setTitle(u.getNombre()+ " (Administrador)");
                stage.setResizable(false);
                // Establecer la escena y mostrar la ventana
                stage.setScene(scene);
                closeWindow();
                stage.show();
            }else {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Usuario.fxml"));

                // Cargar la interfaz gráfica desde el archivo FXML
                Parent root = loader.load();
                usuarioController = loader.getController();
                usuarioController.setUsuario(u);
                // Configurar la escena con el layout cargado desde el archivo FXML
                Scene scene = new Scene(root);

                Stage stage = new Stage();
                // Configurar el título de la ventana
                stage.setTitle(u.getNombre()+ " (Usuario)");
                stage.setResizable(false);
                // Establecer la escena y mostrar la ventana
                stage.setScene(scene);
                closeWindow();
                stage.show();
            }
        }

    }

}
