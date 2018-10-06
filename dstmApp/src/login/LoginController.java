package login;

import conexao.dao.LogadoDAO;
import conexao.dao.UsuarioDAO;
import conexao.tabelas.Usuario;
import home.HomeController;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import novaConta.NovaContaController;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private TextField inputEmailLogin;
    @FXML
    private TextField inputSenhaLogin;
    @FXML
    private Button loginLogin;
    @FXML
    private Button criarContaLogin;
    @FXML
    private Label labelErroLogin;




    private LoginComponent component;

    public static void abrirLogin(){
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(LoginController.class.getClassLoader().getResource("fxml/login.fxml")));
            Stage stage = new Stage();
            stage.setTitle("Dark Side Task Manager");
            stage.setScene(new Scene(root));
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        component = new LoginComponent();
    }

    public void botaoLogin(Event mouseEvent) throws Exception {
        try {
            component.realizarLogin(inputEmailLogin.getText(), inputSenhaLogin.getText());
            HomeController.abrirHome();
            Stage primaryStage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
            primaryStage.hide();
        }catch (Exception e){
            labelErroLogin.setText(e.getMessage());
        }
    }


    public void botaoCadastrar(Event mouseEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml/novaConta.fxml")));
            Parent root = loader.load();
            NovaContaController controller = loader.getController();
            Stage primaryStage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
            controller.setPreviousScene(primaryStage.getScene());
            primaryStage.setScene(new Scene(root));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
