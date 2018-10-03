import login.LoginController;
import splash.SplashController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        SplashController.start(primaryStage);
    }

    /*@Override
    public void start(Stage primaryStage) throws IOException {
        LoginController.abrirLogin();
    }*/

    public static void main(String[] args) {
        launch(args);
    }

}