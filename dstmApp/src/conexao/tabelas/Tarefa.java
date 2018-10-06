package conexao.tabelas;


import conexao.dao.LogadoDAO;

import java.time.LocalDate;

public class Tarefa {
    private int idTarefa;
    private String tarefaTarefa;
    private LocalDate fimTarefa;
    private String marcadorTarefa;
    private int statusTerminadaTarefa;
    private int statusDeletadaTarefa;
    private int idUsuarioTarefa;

    public int getIdTarefa() {
        return idTarefa;
    }
    public void setIdTarefa(int idTarefa) {
        this.idTarefa = idTarefa;
    }

    public String getTarefaTarefa() {
        return tarefaTarefa;
    }
    public void setTarefaTarefa(String tarefaTarefa) {
        this.tarefaTarefa = tarefaTarefa;
    }

    public LocalDate getFimTarefa() {
        return fimTarefa;
    }
    public void setFimTarefa(LocalDate fimTarefa) {
        this.fimTarefa = fimTarefa;
    }

    public String getMarcadorTarefa() {
        return marcadorTarefa;
    }
    public void setMarcadorTarefa(String marcadorTarefa) {
        this.marcadorTarefa = marcadorTarefa;
    }

    public int isStatusTerminadaTarefa() {
        return statusTerminadaTarefa;
    }
    public void setStatusTerminadaTarefa(int statusTerminadaTarefa) {
        this.statusTerminadaTarefa = statusTerminadaTarefa;
    }

    public int isStatusDeletadaTarefa() {
        return statusDeletadaTarefa;
    }
    public void setStatusDeletadaTarefa(int statusDeletadaTarefa) {
        this.statusDeletadaTarefa = statusDeletadaTarefa;
    }

    public int getIdUsuarioTarefa() {
        return idUsuarioTarefa;
    }
    public void setIdUsuarioTarefa(int idUsuarioTarefa) {
        this.idUsuarioTarefa = LogadoDAO.getInstance().obterUsuarioAtual().getIdUsuario();
    }



    class modelTable{
        String tarefa, termino, data;

        public modelTable(String tarefa, String termino, String data) {
            this.tarefa = tarefa;
            this.termino = termino;
            this.data = data;
        }

        public String getTarefa() {
            return tarefa;
        }

        public void setTarefa(String tarefa) {
            this.tarefa = tarefa;
        }

        public String getTermino() {
            return termino;
        }

        public void setTermino(String termino) {
            this.termino = termino;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
    }
}
