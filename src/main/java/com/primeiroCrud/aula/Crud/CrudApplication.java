package com.primeiroCrud.aula.Crud;

import com.primeiroCrud.aula.Crud.DAO.ExercicioDAO.SelectConsult;
import com.primeiroCrud.aula.Crud.Model.Exercicio;

import java.sql.SQLException;


public class CrudApplication {

	public static void main(String[] args) throws SQLException{
		SelectConsult consult = new SelectConsult();

		Exercicio exercicioSelect = consult.Select(1);
		System.out.println(exercicioSelect);

		exercicioSelect = consult.Select("Calculo 4");
		System.out.println(exercicioSelect);

	}

}
