package com.primeiroCrud.aula.Crud.DAO.ExercicioDAO;

import com.primeiroCrud.aula.Crud.ConnectionFactory.ConnectionDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertConsult {

    public void InsertInto(String name, String Dificul_level){
        int queryExecute;
        try (Connection ConnectionInsert = ConnectionDataBase.getConnection()) {
            String sql = "INSERT INTO exercicio(name, dificult_level) VALUES (?, ?)";

            PreparedStatement prepare = ConnectionInsert.prepareStatement(sql);
            prepare.setString(1, name);
            prepare.setString(2, Dificul_level);

            queryExecute = prepare.executeUpdate();

            System.out.println("Inserção realizada, " + queryExecute + " Registro(s) foram adicionados");
        } catch (SQLException e) {
            System.out.println("O Insert falhou!");
            e.printStackTrace();
        }
    }
}
