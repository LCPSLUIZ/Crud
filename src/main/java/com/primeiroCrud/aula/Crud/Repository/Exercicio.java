package com.primeiroCrud.aula.Crud.Repository;


public class Exercicio {
    private int exercicio_number;
    private String name;
    private String dificult_level;

    public int getExercicio_number(){
        return this.exercicio_number;
    }

    public void setExercicio_number(int exercicio_number){
        this.exercicio_number = exercicio_number;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDificult_level(){
        return this.dificult_level;
    }

    public void setDificult_level(String dificult_level){
        this.dificult_level = dificult_level;
    }

    @Override
    public String toString(){
        return "Exercicio{" +
                "exercicio_number=" + exercicio_number +
                ", name='" + name + '\'' +
                ", dificult_level='" + dificult_level + '\'' +
                '}';
    }
}
