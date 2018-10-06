package novaConta;

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
import login.LoginController;

import javax.swing.*;
import java.io.IOException;
import java.util.Objects;

public class NovaContaController {
    @FXML
    private TextField inputNomeNovaConta;
    @FXML
    private TextField inputEmailNovaConta;
    @FXML
    private TextField inputSenhaNovaConta;
    @FXML
    private Button cancelarNovaConta;
    @FXML
    private Button criarNovaConta;
    @FXML
    private Label labelErroNovaConta;

    private Scene previousScene;

    private UsuarioDAO usuarioDAO;

    public NovaContaController() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public void botaoCancelar(Event mouseEvent) throws IOException {
        LoginController.abrirLogin();
        Stage primaryStage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        primaryStage.hide();
    }

    public void botaoCriar(Event mouseEvent) throws Exception {
        Usuario usuario = new Usuario();

        if (inputNomeNovaConta.getText().isEmpty()) {
            labelErroNovaConta.setText("Informe o nome!");
        } else if (inputEmailNovaConta.getText().isEmpty()) {
            labelErroNovaConta.setText("Informe o e-mail!");
        } else if (inputSenhaNovaConta.getText().isEmpty()) {
            labelErroNovaConta.setText("Informe a senha!");
        } else {
            usuario.setNomeUsuario(inputNomeNovaConta.getText());
            usuario.setEmailUsuario(inputEmailNovaConta.getText());
            usuario.setSenhaUsuario(inputSenhaNovaConta.getText());

            if (this.usuarioDAO.getByEmailUsuario(inputEmailNovaConta.getText()) == null) {
                this.usuarioDAO.inserirUsuario(usuario);
                LoginController.abrirLogin();
                Stage primaryStage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
                primaryStage.hide();
            } else {
                labelErroNovaConta.setText("Usuário já cadastrado!");
            }
        }
    }

    public static void abrirNovaConta(){
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(NovaContaController.class.getClassLoader().getResource("fxml/novaConta.fxml")));
            Stage stage = new Stage();
            stage.setTitle("DSTM");
            stage.setScene(new Scene(root));
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setPreviousScene(Scene previousScene) {
        this.previousScene = previousScene;
    }
}
