package demo;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class DragDrop extends Application {

    private static final int GRID_SIZE = 3; // Tamaño del grid (3x3)

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();

        // Cargar imagen
        Image image = new Image("file:imagen.png"); // Cambia la ruta según tu imagen

        // Crear celdas del grid
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                StackPane cell = new StackPane();
                cell.setMinSize(100, 100);
                cell.setStyle("-fx-border-color: black; -fx-background-color: lightgray;");
                gridPane.add(cell, col, row);

                // Solo una celda inicia con la imagen
                if (row == 0 && col == 0) {
                    ImageView imageView = new ImageView(image);
                    imageView.setFitWidth(80);
                    imageView.setFitHeight(80);
                    configureDragAndDrop(imageView, cell, gridPane);
                    cell.getChildren().add(imageView);
                }

                configureCellDragOver(cell, gridPane);
            }
        }

        primaryStage.setScene(new Scene(gridPane, 300, 300));
        primaryStage.setTitle("Drag & Drop en GridPane");
        primaryStage.show();
    }

    private void configureDragAndDrop(ImageView imageView, StackPane sourceCell, GridPane gridPane) {
        imageView.setOnDragDetected(event -> {
            Dragboard db = imageView.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            content.putImage(imageView.getImage());
            db.setContent(content);
            sourceCell.getChildren().remove(imageView);
            event.consume();
        });

        imageView.setOnDragDone(event -> {
            if (event.getTransferMode() != TransferMode.MOVE) {
                sourceCell.getChildren().add(imageView);
            }
            event.consume();
        });
    }

    private void configureCellDragOver(StackPane targetCell, GridPane gridPane) {
        targetCell.setOnDragOver(event -> {
            if (event.getGestureSource() != targetCell && event.getDragboard().hasImage()) {
                event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
        });

        targetCell.setOnDragDropped(event -> {
            Dragboard db = event.getDragboard();
            if (db.hasImage()) {
                ImageView newImageView = new ImageView(db.getImage());
                newImageView.setFitWidth(80);
                newImageView.setFitHeight(80);
                configureDragAndDrop(newImageView, targetCell, gridPane);
                targetCell.getChildren().add(newImageView);
                event.setDropCompleted(true);
            } else {
                event.setDropCompleted(false);
            }
            event.consume();
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}

