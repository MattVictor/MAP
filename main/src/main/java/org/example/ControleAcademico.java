package org.example;

import org.example.Exceptions.AlunoNotFound;
import org.example.Exceptions.ProfessorNotFound;
import org.example.Exceptions.DisciplinaNotFound;
import java.util.ArrayList;

public class ControleAcademico {

    ArrayList<Aluno> alunos;
    ArrayList<Professor> professores;
    ArrayList<Disciplina> disciplinas;

    public ControleAcademico() {
        alunos = new ArrayList<>();
        professores = new ArrayList<>();
        disciplinas = new ArrayList<>();
    }

    public void adicionarAluno(String nomeAluno){
        alunos.add(new Aluno(nomeAluno));
    }
    public void adicionarProfessor(String nomeProfessor){
        professores.add(new Professor(nomeProfessor));
    }
    public void adicionarDisciplina(Disciplina disc, Horario hora){
        disc.setHorario(hora);
        disciplinas.add(disc);
    }

    public void matricularAluno(String nomeAluno, String nomeDisciplina) throws AlunoNotFound, DisciplinaNotFound {

        // procurar aluno e disciplina
        Aluno aluno = procurarAluno(nomeAluno);
        Disciplina disc = procurarDisciplina(nomeDisciplina);

        // relacionar aluno e disciplina
        aluno.addDisciplina(disc);
        disc.addAluno(aluno);
    }

    public void alocarProfessor(String nomeProfessor, String nomeDisciplina) throws ProfessorNotFound, DisciplinaNotFound {

        // procurar professor e disciplina
        Professor prof = procurarProfessor(nomeProfessor);
        Disciplina disc = procurarDisciplina(nomeDisciplina);

        // relacionar professor e disciplina
        prof.addDisciplina(disc);
        disc.setProfessor(prof);
    }

    private Professor procurarProfessor(String nomeProfessor) throws ProfessorNotFound {

        for (Professor professor : professores) {
            if (professor.getNome().equals(nomeProfessor)) {
                return professor;
            }
        }
        throw new ProfessorNotFound("Professor " + nomeProfessor + " nao encontrado.");
    }

    private Disciplina procurarDisciplina(String nomeDisciplina) throws DisciplinaNotFound {

        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getNome().equals(nomeDisciplina)) {
                return disciplina;
            }
        }
        throw new DisciplinaNotFound("Disciplina " + nomeDisciplina + " nao encontrado.");
    }

    private Aluno procurarAluno(String nomeAluno) throws AlunoNotFound {

        for (Aluno aluno : alunos) {
            if (aluno.getNome().equals(nomeAluno)) {
                return aluno;
            }
        }
        throw new AlunoNotFound("Aluno " + nomeAluno + " nao encontrado.");
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }
    public ArrayList<Professor> getProfessores() {
        return professores;
    }
    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }
}
