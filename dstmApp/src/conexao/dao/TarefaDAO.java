package conexao.dao;

import conexao.tabelas.Tarefa;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static conexao.dao.ConnectionFactory.getConnection;

public class TarefaDAO {
    public void inserirTarefa(Tarefa tarefa) {
        try {
            Connection conn = (new ConnectionFactory()).getConnection();
            PreparedStatement comando = conn.prepareStatement("INSERT INTO task(task, taskEnd, marker, inFinished, inStatus, user_idUSer) values(?, ?, ?, ?, ?, ?) ");
            comando.setString(1, tarefa.getTarefaTarefa());
            comando.setDate(2, Date.valueOf(tarefa.getFimTarefa()));
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
            comando.setDate(2, Date.valueOf(tarefa.getFimTarefa()));
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

    public Tarefa getTarefaById(String tarefaNome) {
        Tarefa tarefa = null;
        try {
            Connection conn = (new ConnectionFactory()).getConnection();
            PreparedStatement comando = conn.prepareStatement("SELECT task, taskEnd FROM task WHERE idTask = ?");
            comando.setInt(1, Integer.parseInt(tarefaNome));
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()){
                tarefa = new Tarefa();

                tarefa.setTarefaTarefa(resultado.getString(1));
                Date d = resultado.getDate(2);
                tarefa.setFimTarefa(d.toLocalDate());
            }
            comando.close();
            conn.close();
        }catch(Exception e) {
            e.printStackTrace();
        }

        return tarefa;
    }

    public ArrayList<Tarefa> getTarefasByIdUsuario(int idUsuario) {
        ArrayList<Tarefa> listaTarefas = new ArrayList<Tarefa>();
        try {
            Connection conn = (new ConnectionFactory()).getConnection();
            PreparedStatement comando = conn.prepareStatement("SELECT idTask, task, taskEnd, marker, inFinished, inStatus FROM task WHERE user_idUser = ?");
            comando.setInt(1, idUsuario);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()){
                Tarefa tarefas = new Tarefa();

                tarefas.setIdTarefa(resultado.getInt(1));
                tarefas.setTarefaTarefa(resultado.getString(2));
                Date d = resultado.getDate(3);
                tarefas.setMarcadorTarefa(resultado.getString(4));
                tarefas.setFimTarefa(d.toLocalDate());
                tarefas.setStatusTerminadaTarefa(resultado.getInt(5));
                tarefas.setStatusDeletadaTarefa(resultado.getInt(6));
                listaTarefas.add(tarefas);
            }
            comando.close();
            conn.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return listaTarefas;
    }


    public ArrayList<Tarefa> getTarefas(int usuario){
        ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>();

        try{

            Connection connection = getConnection();

            PreparedStatement stmt = connection.prepareStatement("select idTask, task, taskEnd, marker, inFinished, inStatus, user_idUser from task where user_idUser = ?");
            stmt.setInt(1, usuario);

            ResultSet resultSet = stmt.executeQuery();

            while(resultSet.next()){
                Tarefa task = new Tarefa();

                task.setIdTarefa(resultSet.getInt(1));
                task.setTarefaTarefa(resultSet.getString(2));
                Date d = resultSet.getDate(3);
                task.setFimTarefa(d.toLocalDate());
                task.setMarcadorTarefa(resultSet.getString(4));
                task.setStatusTerminadaTarefa(resultSet.getInt(5));
                task.setStatusDeletadaTarefa(resultSet.getInt(6));
                task.setIdUsuarioTarefa(resultSet.getInt(7));

                tarefas.add(task);

            }


        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

        return tarefas;
    }


}
