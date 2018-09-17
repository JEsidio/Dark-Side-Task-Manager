package conexao.tabelas;

import java.sql.Date;

public class Tarefa {
    private int idTarefa;
    private String tarefaTarefa;
    private Date fimTarefa;
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

    public Date getFimTarefa() {
        return fimTarefa;
    }
    public void setFimTarefa(Date fimTarefa) {
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
        this.idUsuarioTarefa = idUsuarioTarefa;
    }
}
