package com.primeiroCrud.aula.Crud.ConnectionFactory;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionDataBase {
    private final static String hostName = "jdbc:postgresql://localhost/Exercicio";
    private final static String login = "postgres";
    private final static String password = "96787320";
    static Connection connection = null;

    public static Connection getConnection() throws SQLException{
        try {
            connection = DriverManager.getConnection(hostName, login, password);
        } catch(SQLException e) {
            System.out.println("Erro na conexão =(");
            e.printStackTrace();
        }
        return connection;
    }
}
