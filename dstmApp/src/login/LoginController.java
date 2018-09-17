package login;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Objects;

public class LoginController {
    @FXML
    private TextField emailLogin;
    @FXML
    private TextField senhaLogin;
    @FXML
    private Button loginLogin;
    @FXML
    private Button criarContaLogin;

    /*public void clickDoBotao(Event event){
        String texto = campoTexto.getText();
        label.setText(texto);
    }*/

    public static void start(){
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(LoginController.class.getClassLoader().getResource("fxml/login.fxml")));
            Stage stage = new Stage();
            stage.setTitle("DSTM");
            stage.setScene(new Scene(root));
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
