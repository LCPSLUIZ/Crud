package com.primeiroCrud.aula.Crud.DAO.ExercicioDAO;

import com.primeiroCrud.aula.Crud.ConnectionFactory.ConnectionDataBase;
import com.primeiroCrud.aula.Crud.Model.Exercicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectConsult {

    public Exercicio Select(int number) {  //Method with id parameter

        Exercicio exercicios = new Exercicio();

        try(Connection connectionSelect = ConnectionDataBase.getConnection()) {
            String sql = "SELECT * FROM exercicio WHERE exercicio_number = ?";

            PreparedStatement statement = connectionSelect.prepareStatement(sql);
            statement.setInt(1, number);

            ResultSet resultSelect = statement.executeQuery();


            if (resultSelect.next()) {
                exercicios.setExercicio_number(resultSelect.getInt("exercicio_number"));
                exercicios.setName(resultSelect.getString("name"));
                exercicios.setDificult_level(resultSelect.getString("dificult_level"));
            }
        } catch (SQLException e) {
            System.out.println("A consulta falhou!");
            e.printStackTrace();
        }
        return exercicios;
    }

    public List<Exercicio> SelectAllTable() { //Method to print all the table

        List<Exercicio> exercicios = new ArrayList<>();

        try(Connection connectionSelect = ConnectionDataBase.getConnection()) {
            String sql = "SELECT * FROM exercicio ORDER BY exercicio_number";

            PreparedStatement statement = connectionSelect.prepareStatement(sql);

            ResultSet resultSelect = statement.executeQuery();

            while (resultSelect.next()) {
                Exercicio exercicio = new Exercicio();

                exercicio.setExercicio_number(resultSelect.getInt("exercicio_number"));
                exercicio.setName(resultSelect.getString("name"));
                exercicio.setDificult_level(resultSelect.getString("dificult_level"));

                exercicios.add(exercicio);
            }
        } catch (SQLException e) {
            System.out.println("A consulta falhou!");
            e.printStackTrace();
        }
        return exercicios;
    }
}
