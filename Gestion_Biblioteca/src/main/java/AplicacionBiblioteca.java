import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import vista.LogInController;

public class AplicacionBiblioteca extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Cargar el archivo FXML desde el classpath
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/LogIn.fxml"));

        // Cargar la interfaz gráfica desde el archivo FXML
        Parent LogIn = loader.load();
        LogInController logInController = loader.getController();

        // Configurar la escena con el layout cargado desde el archivo FXML
        Scene scene = new Scene(LogIn);


        // Configurar el título de la ventana
        primaryStage.setTitle("Biblioteca");
        primaryStage.setResizable(false);
        // Establecer la escena y mostrar la ventana
        primaryStage.setScene(scene);
        primaryStage.show();
        logInController.setStage(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
