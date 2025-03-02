package org.example;

import org.example.Exceptions.AlunoNotFound;
import org.example.Exceptions.ProfessorNotFound;
import org.example.Exceptions.DisciplinaNotFound;
import org.junit.function.ThrowingRunnable;

import java.util.ArrayList;

public class ControleAcademico {

    ArrayList<Aluno> alunos;
    ArrayList<Professor> professores;
    ArrayList<Disciplina> disciplinas;
    ArrayList<AlunoDisciplina> RelacaoAlunoDisciplina;
    ArrayList<ProfessorDisciplina> RelacaoProfessorDisciplina;

    public ControleAcademico() {
        alunos = new ArrayList<>();
        professores = new ArrayList<>();
        disciplinas = new ArrayList<>();
        RelacaoAlunoDisciplina = new ArrayList<>();
        RelacaoProfessorDisciplina = new ArrayList<>();
    }

    public void adicionarAluno(String nomeAluno) {
        alunos.add(new Aluno(nomeAluno));
    }

    public void adicionarProfessor(String nomeProfessor){
        professores.add(new Professor(nomeProfessor));
    }

    public void adicionarDisciplina(String nomeDaDisc){
        Disciplina disc = new Disciplina(nomeDaDisc);
        disciplinas.add(disc);
    }

    public void matricularAluno(String nomeAluno, String nomeDisciplina, String horaDaDisc) throws AlunoNotFound, DisciplinaNotFound {
        // procurar aluno e disciplina
        Aluno aluno = procurarAluno(nomeAluno);
        Disciplina disc = procurarDisciplina(nomeDisciplina);

        // relacionar aluno e disciplina
        RelacaoAlunoDisciplina.add(new AlunoDisciplina(aluno,disc,horaDaDisc));
    }

    public void alocarProfessor(String nomeProfessor, String nomeDisciplina, String horaDaDisc) throws ProfessorNotFound, DisciplinaNotFound {

        // procurar professor e disciplina
        Professor prof = procurarProfessor(nomeProfessor);
        Disciplina disc = procurarDisciplina(nomeDisciplina);

        // relacionar professor e disciplina
        RelacaoProfessorDisciplina.add(new ProfessorDisciplina(prof,disc,horaDaDisc));
    }

    public Professor procurarProfessor(String nomeProfessor) throws ProfessorNotFound {

        for (Professor professor : professores) {
            if (professor.getNome().equals(nomeProfessor)) {
                return professor;
            }
        }
        throw new ProfessorNotFound("Professor " + nomeProfessor + " nao encontrado.");
    }

    public Disciplina procurarDisciplina(String nomeDisciplina) throws DisciplinaNotFound {

        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getNome().equals(nomeDisciplina)) {
                return disciplina;
            }
        }
        throw new DisciplinaNotFound("Disciplina " + nomeDisciplina + " nao encontrado.");
    }

    public Aluno procurarAluno(String nomeAluno) throws AlunoNotFound {

        for (Aluno aluno : alunos) {
            if (aluno.getNome().equals(nomeAluno)) {
                return aluno;
            }
        }
        throw new AlunoNotFound("Aluno " + nomeAluno + " nao encontrado.");
    }

    public ArrayList<AlunoDisciplina> getDisciplinasDoAluno(String nomeAluno) throws AlunoNotFound {

        Aluno aluno = procurarAluno(nomeAluno);
        ArrayList<AlunoDisciplina> disciplinas = new ArrayList<>();

        for (AlunoDisciplina alunoDisc : RelacaoAlunoDisciplina) {
            if (aluno.equals(alunoDisc.getAluno())) {
                disciplinas.add(alunoDisc);
            }
        }

        return disciplinas;
    }

    public ArrayList<ProfessorDisciplina> getDisciplinasDoProfessor(String nomeProfessor) throws ProfessorNotFound {

        Professor professor = procurarProfessor(nomeProfessor);
        ArrayList<ProfessorDisciplina> disciplinas = new ArrayList<>();

        for (ProfessorDisciplina profDisc : RelacaoProfessorDisciplina) {
            if (professor.equals(profDisc.getProfessor())) {
                disciplinas.add(profDisc);
            }
        }

        return disciplinas;
    }

    public ArrayList<Aluno> getAlunosDaDisciplina(String nomeDisciplina) throws DisciplinaNotFound {

        Disciplina disciplina = procurarDisciplina(nomeDisciplina);
        ArrayList<Aluno> alunos = new ArrayList<>();

        for (AlunoDisciplina alunoDisc : RelacaoAlunoDisciplina) {
            if (disciplina.equals(alunoDisc.getDisciplina())) {
                alunos.add(alunoDisc.getAluno());
            }
        }

        return alunos;
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

    public ArrayList<AlunoDisciplina> getRelacaoAlunoDisciplina() {
        return RelacaoAlunoDisciplina;
    }

    public ArrayList<ProfessorDisciplina> getRelacaoProfessorDisciplina() {
        return RelacaoProfessorDisciplina;
    }
}
