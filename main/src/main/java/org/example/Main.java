package org.example;

import org.example.Exceptions.AlunoNotFound;
import org.example.Exceptions.DisciplinaNotFound;
import org.example.Exceptions.ProfessorNotFound;

public class Main {

    public static void main(String[] args) {

        ControleAcademico controleAcademico = new ControleAcademico();

        String[] professores = {"Sabrina","Daniel","Fabio"};
        String[] alunos = {"Matheus","Maria","Joseph","Samuel"};
        String[] disciplinas = {"MAP","ATAL","BD"};
        String[] horarios = {
            "T,F,F,F,F,T,F/F,F,F,T,F,F,F/F,F,F,F,F,F,F/F,F,F,F,T,F,F/F,F,F,F,F,T,F",
            "F,T,F,F,F,F,T/F,F,F,F,F,F,F/F,F,F,F,F,T,T/F,F,F,F,F,F,F/F,T,F,F,F,F,F",
            "F,F,T,F,T,F,F/F,T,F,F,F,F,F/F,F,F,F,F,F,F/F,T,F,F,F,F,F/F,F,T,F,F,F,F"
        };

        adicionarDisciplinasAoControle(controleAcademico, disciplinas, horarios);
        adicionarMembrosAoControle(controleAcademico, professores, alunos);
        alocarProfessores(controleAcademico);
        matricularAlunos(controleAcademico);
        construirHorariosDosMembros(controleAcademico);

        System.out.println("\nDisciplinas dos Professores:");

        for (Professor prof : controleAcademico.getProfessores()) {
            System.out.println(prof.getNome());

            for (Disciplina dis : prof.getDisciplinas()) {
                System.out.print(dis.getNome() + " ");
            }
            System.out.println();
        }

        System.out.println("\nHorarios dos professores:");
        for (Professor prof : controleAcademico.getProfessores()) {
            System.out.println(prof.getNome());

            Horario horario = prof.getHorario();
            for (String[] dia : horario.getMatrizHorario()) {
                for (String hora : dia) {
                    System.out.print(hora + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

        System.out.println("\nAlunos das Disiciplinas:");
        for (Disciplina disc : controleAcademico.getDisciplinas()) {
            System.out.println(disc.getNome());

            for (Aluno aluno : disc.getAlunos()) {
                System.out.print(aluno.getNome() + " ");
            }
            System.out.println();
        }

        System.out.println("\nDisciplinas do Aluno:");
        for (Aluno aluno : controleAcademico.getAlunos()) {
            System.out.println(aluno.getNome());

            for (Disciplina disc : aluno.getDisciplinas()) {
                System.out.print(disc.getNome() + " ");
            }
            System.out.println();
        }

        System.out.println("\nHorarios do Aluno:");
        for (Aluno aluno : controleAcademico.getAlunos()) {
            System.out.println(aluno.getNome());

            Horario horario = aluno.getHorario();

            for (String[] dia : horario.getMatrizHorario()) {
                for (String hora : dia) {
                    System.out.print(hora + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

        System.out.println("\nAlunos das Disciplinas:");
        for (Disciplina disc : controleAcademico.getDisciplinas()) {
            System.out.println(disc.getNome());

            for (Aluno aluno : disc.getAlunos()) {
                System.out.print(aluno.getNome() + " ");
            }
            System.out.println();
        }
    }

    private static void adicionarMembrosAoControle(ControleAcademico controleAcademico, String[] professores, String[] alunos) {

        // adicionando professores ao controle
        for (String professor : professores) {
            controleAcademico.adicionarProfessor(professor);
        }

        // adicionando alunos ao controle
        for (String aluno : alunos) {
            controleAcademico.adicionarAluno(aluno);
        }
    }

    private static void adicionarDisciplinasAoControle(ControleAcademico controleAcademico, String[] disciplinas, String[] horarios) {

        // adicionando disciplinas ao controle
        for (int i = 0; i < disciplinas.length; i++) {
            controleAcademico.adicionarDisciplina(new Disciplina(disciplinas[i]), new Horario(horarios[i]));
        }
    }

    private static void alocarProfessores(ControleAcademico controleAcademico) {

        // alocando professores às suas disciplinas
        try {
            controleAcademico.alocarProfessor("Sabrina", "MAP");
            controleAcademico.alocarProfessor("Daniel","ATAL");
            controleAcademico.alocarProfessor("Fabio","BD");
        }
        catch (ProfessorNotFound | DisciplinaNotFound e) {
            System.out.println(e.getMessage());
        }
    }

    private static void matricularAlunos(ControleAcademico controleAcademico) {

        // matriculando alunos às suas disciplinas
        try {
            controleAcademico.matricularAluno("Matheus","MAP");
            controleAcademico.matricularAluno("Maria","MAP");
            controleAcademico.matricularAluno("Joseph","MAP");
            controleAcademico.matricularAluno("Samuel","MAP");
            controleAcademico.matricularAluno("Matheus","ATAL");
            controleAcademico.matricularAluno("Joseph","BD");
            controleAcademico.matricularAluno("Samuel","ATAL");
            controleAcademico.matricularAluno("Maria","BD");
        }
        catch (AlunoNotFound | DisciplinaNotFound e) {
            System.out.println(e.getMessage());
        }
    }

    private static void construirHorariosDosMembros(ControleAcademico controleAcademico) {

        // construindo horarios baseado nas disciplinas
        for (Aluno aluno : controleAcademico.getAlunos()) {
            aluno.construirHorario();
        }
        for (Professor professor : controleAcademico.getProfessores()) {
            professor.construirHorario();
        }
    }
}