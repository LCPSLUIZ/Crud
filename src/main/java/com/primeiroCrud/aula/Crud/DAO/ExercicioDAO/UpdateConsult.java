package com.primeiroCrud.aula.Crud.DAO.ExercicioDAO;

import com.primeiroCrud.aula.Crud.ConnectionFactory.ConnectionDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateConsult {

    public void UpdateMethod(String newName, String newDificult, int WhoWillReceiveTheUpdate) {
        int queryExecute;

        try(Connection connection = ConnectionDataBase.getConnection()) {
            String sql = "UPDATE exercicio SET name = ?, dificult_level = ? WHERE exercicio_number = ?";

            PreparedStatement prepare = connection.prepareStatement(sql);
            prepare.setString(1, newName);
            prepare.setString(2, newDificult);
            prepare. setInt(3, WhoWillReceiveTheUpdate);

            queryExecute = prepare.executeUpdate();

            System.out.println("O Update foi realizado com sucesso! " + queryExecute + " Foram atualizados!");
        } catch (SQLException e) {
            System.out.println("O UPDATE deu erro!");
            e.printStackTrace();
        }


    }
}
