package conexao.dao;

import conexao.tabelas.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LogadoDAO {
    /*public void usuarioLogado(int idUsuario) {
        try {
            Connection conn = (new ConnectionFactory()).getConnection();
            PreparedStatement comando = conn.prepareStatement("INSERT logado(user_idUser) VALUES (?)");
            comando.setLong(1, idUsuario);
            comando.execute();
            comando.close();
            conn.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static long getIdUsuarioLogado() {
        int id = 0;
        try {
            Connection conn = (new ConnectionFactory()).getConnection();
            PreparedStatement comando = conn.prepareStatement("SELECT user_idUser FROM logado ORDER BY idLogado DESC LIMIT 1");
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()){
                id = resultado.getInt(1);
            }
            comando.close();
            conn.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return id;
    }*/


    private Usuario usuarioAtual;

    private final static LogadoDAO logadoDAO = new LogadoDAO();

    public LogadoDAO(){

    }

    public static LogadoDAO getInstance(){
        return logadoDAO;
    }

    public boolean isUsuarioLogado(){
        return usuarioAtual != null;
    }

    public void setUsuarioAtual(Usuario usuario){
        usuarioAtual = usuario;
    }

    public void removerUsuarioAtual(){
        usuarioAtual = null;
    }

    public Usuario obterUsuarioAtual(){
        return  usuarioAtual;
    }
}
