package Package;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("/Package/FXML/LoginScreen.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("First JavaFX Application");
        primaryStage.show();
    }

    public void changeScene(String fxml) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource(fxml));
        stage.getScene().setRoot(parent);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
