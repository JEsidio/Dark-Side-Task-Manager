package novaTarefa;

import conexao.dao.TarefaDAO;
import conexao.tabelas.Tarefa;
import home.HomeController;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class NovaTarefaController {
    @FXML
    private Label nrNovaTarefa;
    @FXML
    private TextField inputTarefaNovaTarefa;
    @FXML
    private DatePicker inputTerminoNovaTarefa;
    @FXML
    private TextField inputMarcadorNovaTarefa;
    @FXML
    private Button buttonCancelarNovaTarefa;
    @FXML
    private Button buttonCriarTarefaNovaTarefa;
    @FXML
    private Label labelErroNovaTarefa;

    private TarefaDAO tarefaDAO;

    public NovaTarefaController() {
        this.tarefaDAO = new TarefaDAO();
    }

    public void botaoCancelar(Event mouseEvent) throws IOException {
        HomeController.abrirHome();
        Stage primaryStage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        primaryStage.hide();
    }

    public void botaoCriarTarefa(Event mouseEvent) throws Exception {
        Tarefa tarefa = new Tarefa();

        if (inputTarefaNovaTarefa.getText().isEmpty()) {
            labelErroNovaTarefa.setText("Informe a tarefa!");
        } else if (inputTerminoNovaTarefa.getValue().equals("")) {
            labelErroNovaTarefa.setText("Informe a data!");
        }
    }

}
