package splash;

import home.HomeController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import login.LoginController;
import uteis.AsyncTask;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;


public class SplashController implements Initializable {

    @FXML
    private Pane backgroundSplash;

    public static void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(SplashController.class.getClassLoader().getResource("fxml/splash.fxml")));
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Media media = new Media(Objects.requireNonNull(getClass().getClassLoader().getResource("assets/audio/saberon.mp3")).toString());
        MediaPlayer mp = new MediaPlayer(media);
        mp.play();
        CountDownTask task = new CountDownTask();
        task.execute();
    }

    private class CountDownTask extends AsyncTask {
        @Override
        public void onPreExecute() {
        }

        @Override
        public Object doInBackground(Object[] params)  {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public void onPostExecute(Object params) {
            LoginController.abrirLogin();
            Scene scene = backgroundSplash.getParent().getScene();
            scene.getWindow().hide();
        }

        @Override
        public void progressCallback(Object[] params) {
        }
    }
}