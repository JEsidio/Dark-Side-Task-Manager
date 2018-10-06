package conexao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import conexao.dao.BaseDAO;
import conexao.tabelas.Usuario;
import uteis.Strings;

public class LoginDAO extends BaseDAO{
    public Usuario obterUsuarioPeloNomeOuFalha(String nomeUsuario) throws Exception{
        Usuario usuario = null;
        if(Strings.isNullOrEmpty(nomeUsuario)){
            throw new Exception("Usuário inválido");
        }

        try(
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("select idUser, userName, userEmail, userPassword from user where userEmail = ?")
        ){
            // Informa o user_id na query
            statement.setString(1,nomeUsuario);

            // Executa a query
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                // Cria um novo objeto usuario
                usuario = new Usuario();

                // Obtem os valores dos campos, deve ser na mesma ordem informada na query
                usuario.setIdUsuario(resultSet.getInt(1));
                usuario.setNomeUsuario(resultSet.getString(2));
                usuario.setEmailUsuario(resultSet.getString(3));
                usuario.setSenhaUsuario(resultSet.getString(4));
            }

        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        if(usuario == null){
            throw new Exception("Usuário informado não foi localizado.");
        }
        return usuario;
    }
}
