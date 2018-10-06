package home;


import conexao.dao.LogadoDAO;
import conexao.dao.TarefaDAO;
import conexao.tabelas.Tarefa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;
import conexao.dao.UsuarioDAO;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.util.StringConverter;
import login.LoginController;

import javax.swing.text.html.ImageView;
import java.io.IOException;
import java.util.ResourceBundle;

import javafx.scene.control.DatePicker;

import java.time.format.DateTimeFormatter;

import static conexao.dao.LogadoDAO.*;


public class HomeController implements Initializable{
    @FXML
    private ImageView sairHome;
    @FXML
    private ImageView addHome;
    @FXML
    private Label labelUserNameHome;
    @FXML
    private TextField inputTarefaHome;
    @FXML
    private DatePicker inputTerminoHome;
    @FXML
    private TextField inputMarcadorHome;
    @FXML
    private Button buttonCancelarHome;
    @FXML
    private Button buttonCriarTarefaHome;
    @FXML
    private Label labelErroHome;
    @FXML
    private TableView tabela;


    private UsuarioDAO usuarioDAO;
    private LogadoDAO logadoDAO;

    public TarefaDAO tarefaDAO;

    public HomeController() {
        this.tarefaDAO = new TarefaDAO();
    }


    ObservableList<Tarefa> tarefas = FXCollections.observableArrayList();




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        labelUserNameHome.setText("Bem vindo "+ getInstance().obterUsuarioAtual().getNomeUsuario());

        // cria a mascara do dados que sera apresentado em tela
        StringConverter<LocalDate> converter = new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                }else {
                    return "";
                }
            }
            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        };
        this.inputTerminoHome.setConverter(converter);
        this.inputTerminoHome.setPromptText("dd/MM/yyyy");

        // configura o valor inicial
        this.inputTerminoHome.setValue(LocalDate.now());








        tarefas = FXCollections.observableArrayList();
        tarefas =  FXCollections.observableArrayList(tarefaDAO.getTarefas(getInstance().obterUsuarioAtual().getIdUsuario()));
        tabela.setItems(tarefas);
        populaLista();
    }


    private void populaLista(){
        tarefas.clear();
        tarefas.addAll(retornaTarefa());
        tabela.setItems(tarefas);
    }

    private ArrayList<Tarefa> retornaTarefa(){
        TarefaDAO tarefaDAO = new TarefaDAO();
        ArrayList<Tarefa> task = new ArrayList<Tarefa>();
        task = tarefaDAO.getTarefasByIdUsuario(LogadoDAO.getInstance().obterUsuarioAtual().getIdUsuario());
        return task;
    }


    public void addHome(Event mouseEvent){
        try {
            Tarefa tarefa = new Tarefa();

            if (inputTarefaHome.getText().isEmpty()) {
                labelErroHome.setText("Informe a tarefa!");
            } else {
                tarefa.setTarefaTarefa(inputTarefaHome.getText());
                tarefa.setFimTarefa(inputTerminoHome.getValue());
                tarefa.setMarcadorTarefa(inputMarcadorHome.getText());

                tarefa.setIdUsuarioTarefa(getInstance().obterUsuarioAtual().getIdUsuario());
                tarefaDAO.inserirTarefa(tarefa);
                populaLista();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        inputTarefaHome.setText("");
        inputMarcadorHome.setText("");
    }







    public void sairHome(Event mouseEvent) throws IOException {
        LoginController.abrirLogin();
        Stage primaryStage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        primaryStage.hide();
    }




    public static void abrirHome() {
        if (getInstance().isUsuarioLogado()) {
            try {
                Parent root = FXMLLoader.load(Objects.requireNonNull(HomeController.class.getClassLoader().getResource("fxml/home.fxml")));
                Stage stage = new Stage();
                stage.setTitle("DSTM");
                stage.setScene(new Scene(root));
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Usuário não logado");
            LoginController.abrirLogin();
        }
    }






}
