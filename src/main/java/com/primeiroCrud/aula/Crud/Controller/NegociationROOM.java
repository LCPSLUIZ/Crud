package com.primeiroCrud.aula.Crud.Controller;

import com.primeiroCrud.aula.Crud.DAO.ExercicioDAO.DeleteConsult;
import com.primeiroCrud.aula.Crud.DAO.ExercicioDAO.InsertConsult;
import com.primeiroCrud.aula.Crud.DAO.ExercicioDAO.SelectConsult;
import com.primeiroCrud.aula.Crud.DAO.ExercicioDAO.UpdateConsult;
import com.primeiroCrud.aula.Crud.Model.Exercicio;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Scanner;

@Getter
@Setter
public class NegociationROOM {
    private final Scanner inputInt = new Scanner(System.in);
    private final Scanner inputName = new Scanner(System.in);
    private final Scanner inputDificult = new Scanner(System.in);
    private int exerciceNumber;
    private String newName;
    private String newDificult;

    public void ControlPainel() {
        int option;
        do {
            System.out.println("\n\n - Acessor de Consultas ao Banco de Dados -");
            System.out.println("-----------------");
            System.out.println("O que deseja fazer?");
            System.out.println("Ver todo o conteúdo da tabela exercícios? (1) ");
            System.out.println("Ver um registro especifico? (2) ");
            System.out.println("Atualizar algum registro do banco de dados? (3) ");
            System.out.println("Adicionar um registro no banco de dados? (4) ");
            System.out.println("Apagar algum registro do banco de dados? (5) ");
            System.out.println("Selecione qualquer outro valor para finalizar a aplicação! ");

            option = inputInt.nextInt();

            optionPanel(option);

        } while(option >0 && option< 6);
        System.out.println("Finalizando aplicação ...");
    }
    
    private void option1(){
        SelectConsult consult = new SelectConsult();
        List<Exercicio> SelectAllTable = consult.Select();

        System.out.println("Toda a Tabela: ");
        SelectAllTable.forEach(System.out::println);
    }
    
    private void option2(){
        System.out.println("Qual o numero do exercicio que você quer ver? ");
        setExerciceNumber(inputInt.nextInt());

        SelectConsult consult = new SelectConsult();
        Exercicio exercicioSelect = consult.Select(getExerciceNumber());
        System.out.println(exercicioSelect);
    }
    
    private void option3(){
        System.out.println("Qual registro você quer atualizar? ");
        setExerciceNumber(inputInt.nextInt());

        System.out.println("Qual será o novo nome? ");
        setNewName(inputName.nextLine());

        System.out.println("Qual será a nova dificuldade? ");
        setNewDificult(inputDificult.nextLine());

        UpdateConsult Update = new UpdateConsult();
        Update.UpdateMethod(getNewName(), getNewDificult(), getExerciceNumber());
    }
    
    private void option4(){
        System.out.println("Qual o nome do novo registro? ");
        setNewName(inputName.nextLine());

        System.out.println("Qual será a dificuldade? ");
        setNewDificult(inputDificult.nextLine());

        InsertConsult Insert = new InsertConsult();
        Insert.InsertInto(getNewName(), getNewDificult());

    }
    
    private void option5(){
        SelectConsult consult = new SelectConsult();
        List<Exercicio> SelectAllTable = consult.Select();

        System.out.println("Toda a Tabela: ");
        SelectAllTable.forEach(System.out::println);

        System.out.println("Qual o numero do exercicio que você deseja apagar? ");
        setExerciceNumber(inputInt.nextInt());
        DeleteConsult Delete = new DeleteConsult();
        Delete.DeleteMethod(getExerciceNumber());
    }

    private void optionPanel(int option) {
        if(option == 1) {
            option1();
        } else if(option == 2) {
            option2();
        } else if (option == 3) {
            option3();
        } else if (option == 4) {
            option4();
        } else if (option == 5) {
            option5();
        } else {
            System.out.println("Saindo da tela de opções...");
            System.out.println("\n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n  " +
                    "\n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n " +
                    "\n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n ");
        }
    }
}