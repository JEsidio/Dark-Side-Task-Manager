package conexao.dao;

import conexao.tabelas.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UsuarioDAO {
    private LogadoDAO logadoDAO = new LogadoDAO();

    public void inserirUsuario(Usuario usuario) {
        try {
            Connection conn = (new ConnectionFactory()).getConnection();
            PreparedStatement comando = conn.prepareStatement("INSERT INTO user(userName, userEmail, userPassword) values(?, ?, ?) ");
            comando.setString(1, usuario.getNomeUsuario());
            comando.setString(2, usuario.getEmailUsuario());
            comando.setString(3, usuario.getSenhaUsuario());
            comando.execute();
            comando.close();
            conn.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public Usuario getByEmailUsuario(String email) {
        Usuario usuario = null;
        try {
            Connection conn = (new ConnectionFactory()).getConnection();
            PreparedStatement comando = conn.prepareStatement("SELECT idUser, userName, userEmail, userPassword FROM user WHERE userEmail LIKE ?");
            comando.setString(1, email);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()){
                usuario = new Usuario();

                usuario.setIdUsuario(resultado.getInt(1));
                usuario.setNomeUsuario(resultado.getString(2));
                usuario.setEmailUsuario(resultado.getString(3));
                usuario.setSenhaUsuario(resultado.getString(4));
            }
            comando.close();
            conn.close();
        }catch(Exception e) {
            e.printStackTrace();
        }

        return usuario;
    }

    public boolean verificarUsuario(String emailUsuario, String senhaUsuario) {
        boolean cadastrado = false;
        try {
            Connection conn = (new ConnectionFactory()).getConnection();
            PreparedStatement comando = conn.prepareStatement("SELECT idUser, userEmail, userPassword FROM user WHERE userEmail LIKE ? AND userPassword LIKE ?");
            comando.setString(1, emailUsuario);
            comando.setString(2, senhaUsuario);

            ResultSet resultado = comando.executeQuery();

            if (resultado.next()){
                cadastrado = true;
                this.logadoDAO.setUsuarioAtual((Usuario) resultado);
            }
            comando.close();
            conn.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return cadastrado;
    }
}
