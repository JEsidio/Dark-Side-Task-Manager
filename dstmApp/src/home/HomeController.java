package home;

import conexao.dao.LogadoDAO;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import conexao.dao.UsuarioDAO;
import conexao.tabelas.Usuario;
import home.HomeController;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import login.LoginController;
import javax.swing.*;
import javax.swing.text.html.ImageView;
import java.io.IOException;
import java.util.ResourceBundle;


public class HomeController {
    @FXML
    private ImageView sairHome;
    @FXML
    private Label labelUserNameHome;


    private UsuarioDAO usuarioDAO;
    private LogadoDAO logadoDAO;

    public HomeController() {
        /*this.usuarioDAO = new UsuarioDAO();*/
        /*this.logadoDAO = new LogadoDAO();*/

        labelUserNameHome.setText("Bem vindo " + LogadoDAO.getInstance().obterUsuarioAtual().getNomeUsuario());
    }

    public void imgSairHome(Event mouseEvent) throws IOException {
        LoginController.abrirLogin();
        Stage primaryStage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        primaryStage.hide();
    }

    public static void abrirHome() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(HomeController.class.getClassLoader().getResource("fxml/home.fxml")));
            Stage stage = new Stage();
            stage.setTitle("DSTM");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
