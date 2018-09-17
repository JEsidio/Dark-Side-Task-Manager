package conexao.dao;

import conexao.tabelas.Tarefa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TarefaDAO {
    public void inserirTarefa(Tarefa tarefa) {
        try {
            Connection conn = (new ConnectionFactory()).getConnection();
            PreparedStatement comando = conn.prepareStatement("INSERT INTO task(task, taskEnd, marker, inFinished, inStatus, user_idUSer) values(?, ?, ?, ?, ?, ?) ");
            comando.setString(1, tarefa.getTarefaTarefa());
            comando.setDate(2, tarefa.getFimTarefa());
            comando.setString(3, tarefa.getMarcadorTarefa());
            comando.setInt(4, 0);
            comando.setInt(5, 0);
            comando.setInt(6, tarefa.getIdUsuarioTarefa());
            comando.execute();
            comando.close();
            conn.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void editarTarefa(Tarefa tarefa) {
        try {
            Connection conn = (new ConnectionFactory()).getConnection();
            PreparedStatement comando = conn.prepareStatement("UPDATE task SET task = ?, taskEnd = ?, marker = ? WHERE idTask = ?");
            comando.setString(1, tarefa.getTarefaTarefa());
            comando.setDate(2, tarefa.getFimTarefa());
            comando.setString(3, tarefa.getMarcadorTarefa());
            comando.setLong(4, tarefa.getIdTarefa());
            comando.execute();
            comando.close();
            conn.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void finalizarTarefa(int terminadaTarefa, int idTarefa) {
        try {
            Connection conn = (new ConnectionFactory()).getConnection();
            PreparedStatement comando = conn.prepareStatement("UPDATE task SET inFinished = ? WHERE idTask = ?");
            comando.setInt(1, terminadaTarefa);
            comando.setInt(2, idTarefa);
            comando.execute();
            comando.close();
            conn.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void deletarTarefa(int idTarefa) {
        try {
            Connection conn = (new ConnectionFactory()).getConnection();
            PreparedStatement comando = conn.prepareStatement("DELETE FROM task WHERE idTask = ?");
            comando.setInt(1, idTarefa);
            comando.execute();
            comando.close();
            conn.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public Tarefa getTarefaById(Integer idTarefa) {
        Tarefa tarefa = null;
        try {
            Connection conn = (new ConnectionFactory()).getConnection();
            PreparedStatement comando = conn.prepareStatement("SELECT task, taskEnd FROM task WHERE idTask = ?");
            comando.setInt(1, idTarefa);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()){
                tarefa = new Tarefa();

                tarefa.setTarefaTarefa(resultado.getString(1));
                tarefa.setFimTarefa(resultado.getDate(2));
            }
            comando.close();
            conn.close();
        }catch(Exception e) {
            e.printStackTrace();
        }

        return tarefa;
    }

    public List getTarefasByIdUsuario(int idUsuario) {
        List<Tarefa> listaTarefas = new ArrayList<Tarefa>();
        try {
            Connection conn = (new ConnectionFactory()).getConnection();
            PreparedStatement comando = conn.prepareStatement("SELECT idTask, task, taskEnd, inFinished, inStatus FROM task WHERE users_idUser = ?");
            comando.setInt(1, idUsuario);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()){
                Tarefa tarefas = new Tarefa();

                tarefas.setIdTarefa(resultado.getInt(1));
                tarefas.setTarefaTarefa(resultado.getString(2));
                tarefas.setFimTarefa(resultado.getDate(3));
                tarefas.setStatusTerminadaTarefa(resultado.getInt(4));
                tarefas.setStatusDeletadaTarefa(resultado.getInt(5));
                listaTarefas.add(tarefas);
            }
            comando.close();
            conn.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return listaTarefas;
    }
}
