package conexao.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    private static final String stringConexao = "jdbc:mysql://localhost:3306/dstmdatabase?useTimezone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";
    private static final String userDatabase = "root";
    private static final String passwordDatabase = "R@@tPassword0402";


    static Connection getConnection() {
        try {
            return DriverManager
                    .getConnection(stringConexao, userDatabase, passwordDatabase);

        }catch (Exception e) {
            throw new RuntimeException();
        }
    }
}