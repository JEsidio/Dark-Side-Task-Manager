package conexao.dao;

import conexao.tabelas.Usuario;


public class LogadoDAO {
    private Usuario usuarioAtual;

    private final static LogadoDAO sessao = new LogadoDAO();

    public LogadoDAO(){

    }

    public static LogadoDAO getInstance(){
        return sessao;
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
