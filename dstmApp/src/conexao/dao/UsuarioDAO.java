package conexao.dao;

import conexao.tabelas.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class UsuarioDAO {
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
}
