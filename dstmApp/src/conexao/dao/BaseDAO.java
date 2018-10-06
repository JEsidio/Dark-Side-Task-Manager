package conexao.dao;

import java.sql.Connection;

public class BaseDAO {
    protected Connection getConnection(){
        return ConnectionFactory.getConnection();
    }
}
