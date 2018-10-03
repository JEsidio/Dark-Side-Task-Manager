package login;

import conexao.dao.LogadoDAO;
import conexao.dao.UsuarioDAO;
import conexao.tabelas.Usuario;
import home.HomeController;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import novaConta.NovaContaController;

import java.io.IOException;
import java.util.Objects;

public class LoginController {
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

    /*private UsuarioDAO usuarioDAO;*/

    UsuarioDAO usuarioDAO = new UsuarioDAO();

    Usuario usuario = new Usuario();

    public LoginController() {
        /*this.usuarioDAO = new UsuarioDAO();*/
    }

    public void botaoCadastrar(Event mouseEvent) throws IOException {
        NovaContaController.abrirNovaConta();
        Stage primaryStage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        primaryStage.hide();
    }

    public void botaoLogin(Event mouseEvent) throws Exception {
        if (inputEmailLogin.getText().isEmpty()) {
            labelErroLogin.setText("Informe o e-mail!");
        } else if (inputSenhaLogin.getText().isEmpty()) {
            labelErroLogin.setText("Informe a senha!");
        } else {
            if (/*this.*/usuarioDAO.verificarUsuario(inputEmailLogin.getText(), inputSenhaLogin.getText())) {
                LogadoDAO.getInstance().setUsuarioAtual(usuario);
                HomeController.abrirHome();
                Stage primaryStage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
                primaryStage.hide();
            } else {
                labelErroLogin.setText("Usuário ou Senha incorretos. Verifique!");
            }
        }
    }

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
}
