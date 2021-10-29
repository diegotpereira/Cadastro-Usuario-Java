package br.com.java.factory;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection; 

public class ConnectionFactory {

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/cadastro_usuario_java?serverTimezone=UTC", "root", "root");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
