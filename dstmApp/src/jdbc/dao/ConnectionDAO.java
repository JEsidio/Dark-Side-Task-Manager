package jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDAO {
    private static final String stringConexao = "jdbc:mysql://localhost:3306/banco_hellojdbc?useTimezone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";
    private static final String usuarioBD = "root";
    private static final String senhaBD = "R@@tPassword0402";

    //Obtem uma nova Conexão
    public Connection getConnection() {

        try {
            return DriverManager
                    .getConnection(stringConexao, usuarioBD, senhaBD);

        }catch (Exception e) {
            throw new RuntimeException();
        }

    }
}
