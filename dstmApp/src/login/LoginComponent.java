package login;
import conexao.dao.LogadoDAO;
import conexao.dao.LoginDAO;
import conexao.tabelas.Usuario;
import uteis.Strings;

public class LoginComponent {
    private LoginDAO dao;

    LoginComponent(){
        dao = new LoginDAO();
    }

    Usuario realizarLogin(String email, String password) throws Exception {
        if(Strings.isNullOrEmpty(email) || Strings.isNullOrEmpty(password)){
            throw new Exception("Favor informar usuário e senha");
        }
        Usuario usuario = dao.obterUsuarioPeloNomeOuFalha(email);

        if(!usuario.getSenhaUsuario().equals(password)){
            throw new Exception("Usuário ou senha inválidos");
        }

        LogadoDAO.getInstance().setUsuarioAtual(usuario);

        return usuario;
    }
}
