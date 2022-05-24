package com.primeiroCrud.aula.Crud;

import com.primeiroCrud.aula.Crud.Model.SelectConsult;
import com.primeiroCrud.aula.Crud.Repository.ConnectionDataBase;
import com.primeiroCrud.aula.Crud.Repository.Exercicio;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
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
