package com.primeiroCrud.aula.Crud.Model;

import com.primeiroCrud.aula.Crud.Repository.ConnectionDataBase;
import com.primeiroCrud.aula.Crud.Repository.Exercicio;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectConsult {

    public Exercicio Select(int number) throws SQLException{

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

    public Exercicio Select(String name) throws SQLException{

        Exercicio exercicios = new Exercicio();

        try(Connection connectionSelect = ConnectionDataBase.getConnection()) {
            String sql = "SELECT * FROM exercicio WHERE name ILIKE ?";

            PreparedStatement statement = connectionSelect.prepareStatement(sql);
            statement.setString(1, name);

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
}
