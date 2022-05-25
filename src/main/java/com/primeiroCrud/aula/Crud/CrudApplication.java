package com.primeiroCrud.aula.Crud;

import com.primeiroCrud.aula.Crud.DAO.ExercicioDAO.InsertConsult;
import com.primeiroCrud.aula.Crud.DAO.ExercicioDAO.SelectConsult;
import com.primeiroCrud.aula.Crud.Model.Exercicio;

import java.sql.SQLException;
import java.util.List;


public class CrudApplication {

	public static void main(String[] args) throws SQLException{
		SelectConsult consult = new SelectConsult();  //Object Select

		//Select Where number == 1
		Exercicio exercicioSelect = consult.Select(1);
		System.out.println(exercicioSelect);

		//Select to Print All table
		List<Exercicio> SelectAllTable = consult.SelectAllTable();
		SelectAllTable.forEach(System.out::println);

		//--------------------------------------------------------------------
		InsertConsult Insert = new InsertConsult(); //Object Insert

		//Execute Insert
		Insert.InsertInto("Programação", "Hard");



	}

}
