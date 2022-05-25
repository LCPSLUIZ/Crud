package com.primeiroCrud.aula.Crud.DAO.ExercicioDAO;

import com.primeiroCrud.aula.Crud.ConnectionFactory.ConnectionDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteConsult {

    public void DeleteMethod(int exercicio_number) {
        int queryExecute;
        try(Connection Connection = ConnectionDataBase.getConnection()) {
            String sql = "DELETE FROM exercicio WHERE exercicio_number = ?";

            PreparedStatement prepare = Connection.prepareStatement(sql);
            prepare.setInt(1, exercicio_number);

            queryExecute = prepare.executeUpdate();

            System.out.println("Registro removido com secesso! Foram " + queryExecute + " registro(s) removidos.");
        } catch (SQLException e) {
            System.out.println("O Delete deu erro");
            e.printStackTrace();
        }
    }
}
