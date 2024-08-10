package org.example;

import java.util.ArrayList;

public class Disciplina {
    private String nome;
    private Horario horario;
    private ArrayList<Aluno> alunos;
    private Professor professor;

    void alocarAluno(Aluno aluno){

    }

    void alocarProfessor(Professor prof){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
