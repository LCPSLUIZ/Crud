package com.primeiroCrud.aula.Crud.Controller;

import com.primeiroCrud.aula.Crud.DAO.ExercicioDAO.DeleteConsult;
import com.primeiroCrud.aula.Crud.DAO.ExercicioDAO.InsertConsult;
import com.primeiroCrud.aula.Crud.DAO.ExercicioDAO.SelectConsult;
import com.primeiroCrud.aula.Crud.DAO.ExercicioDAO.UpdateConsult;
import com.primeiroCrud.aula.Crud.Model.Exercicio;

import java.util.List;
import java.util.Scanner;

public class NegociationROOM {
    private Scanner input = new Scanner(System.in);
    private int option;
    private int exerciceNumber;
    private String newName;
    private String newDificult;

    public void ControlPainel() {
        do {
            System.out.println("/n /n /n /n /n /n /n /n /n /n /n /n /n /n /n " +
                    "/n /n /n /n /n /n /n /n /n /n /n /n /n /n /n /n /n /n /n " +
                    "/n /n /n /n /n /n /n /n /n /n /n /n /n /n /n /n /n /n /n " +
                    "/n /n /n /n /n /n /n /n /n /n /n /n /n /n /n /n /n /n /n ");
            System.out.println("- Acessor de Consultas ao Banco de Dados -");
            System.out.println("-----------------");
            System.out.println("O que deseja fazer?");
            System.out.println("Ver todo o conteúdo da tabela exercícios? (1) ");
            System.out.println("Ver um registro especifico? (2) ");
            System.out.println("Atualizar algum registro do banco de dados? (3) ");
            System.out.println("Adicionar um registro no banco de dados? (4) ");
            System.out.println("Apagar algum registro do banco de dados? (5) ");
            System.out.println("Selecione qualquer outro valor para finalizar a aplicação! ");

            option = input.nextInt();

            if(option == 1) {
                SelectConsult consult = new SelectConsult();
                List<Exercicio> SelectAllTable = consult.SelectAllTable();
                System.out.println("Toda a Tabela: ");
                SelectAllTable.forEach(System.out::println);
            } else if(option == 2) {
                System.out.println("Qual o numero do exercicio que você quer ver? ");
                exerciceNumber = input.nextInt();
                SelectConsult consult = new SelectConsult();
                Exercicio exercicioSelect = consult.Select(exerciceNumber);
                System.out.println(exercicioSelect);
            } else if (option == 3) {
                System.out.println("Qual registro você quer atualizar? ");
                exerciceNumber = input.nextInt();
                System.out.println("Qual será o novo nome? ");
                newName = input.next();
                System.out.println("Qual será a nova dificuldade? ");
                newDificult = input.next();
                UpdateConsult Update = new UpdateConsult();
                Update.UpdateMethod(newName, newDificult, exerciceNumber);
            } else if (option == 4) {
                System.out.println("Qual o nome do novo registro? ");
                newName = input.next();
                System.out.println("Qual será a dificuldade? ");
                newDificult = input.next();
                InsertConsult Insert = new InsertConsult(); //Object Insert
                Insert.InsertInto(newName, newDificult);
            } else if (option == 5) {
                SelectConsult consult = new SelectConsult();
                List<Exercicio> SelectAllTable = consult.SelectAllTable();
                System.out.println("Toda a Tabela: ");
                SelectAllTable.forEach(System.out::println);

                System.out.println("Qual o numero do exercicio que você deseja apagar? ");
                exerciceNumber = input.nextInt();
                DeleteConsult Delete = new DeleteConsult();
                Delete.DeleteMethod(exerciceNumber);
            } else {
                System.out.println("Saindo da tela de opções...");
                System.out.println("/n /n /n /n /n /n /n /n /n /n /n /n /n /n /n /n /n " +
                        "/n /n /n /n /n /n /n /n /n /n /n /n /n /n /n /n /n /n /n /n /n" +
                        "/n /n /n /n /n /n /n /n /n /n /n /n /n /n /n /n /n /n /n /n /n" +
                        "/n /n /n /n /n /n /n /n /n /n /n /n /n /n /n /n /n /n /n /n /n ");
            }
        } while(option > 0 && option < 6);
        System.out.println("Finalizando aplicação ...");
    }
}
