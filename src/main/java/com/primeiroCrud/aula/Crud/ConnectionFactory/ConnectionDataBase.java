package com.primeiroCrud.aula.Crud.ConnectionFactory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Getter
@Setter
@AllArgsConstructor
public class ConnectionDataBase {
    private static String hostName = "jdbc:postgresql://localhost/Exercicio";
    private static String login = "postgres";
    private static String password = "96787320";
    static Connection connection = null;

    public static Connection getConnection() throws SQLException{
        try {
            connection = DriverManager.getConnection(hostName, login, password);
            System.out.println("Conectado com Sucesso! ");
        } catch(SQLException e) {
            System.out.println("Erro na conexão =(");
            e.printStackTrace();
        }
        return connection;
    }
}
