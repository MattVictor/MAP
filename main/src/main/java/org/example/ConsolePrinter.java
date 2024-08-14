package org.example;

import org.example.Exceptions.AlunoNotFound;
import org.example.Exceptions.DisciplinaNotFound;
import org.example.Exceptions.ProfessorNotFound;

public class ConsolePrinter {

    ControleAcademico controleAcademico;

    public ConsolePrinter(ControleAcademico controleAcademico) {
        this.controleAcademico = controleAcademico;
    }

    public void printDisciplinasDosProfessores() {

        System.out.println("\nDisciplinas dos Professores:");

        for (Professor prof : controleAcademico.getProfessores()) {
            System.out.println(prof.getNome());

            for (Disciplina dis : prof.getDisciplinas()) {
                System.out.print(dis.getNome() + " ");
            }
            System.out.println();
        }
    }

    public void printDisciplinasDosProfessores(String... nomes) throws ProfessorNotFound {

        System.out.println("\nDisciplinas dos Professores:");

        Professor prof;
        for (String nome : nomes) {
            prof = controleAcademico.procurarProfessor(nome);

            System.out.println(prof.getNome());
            for (Disciplina dis : prof.getDisciplinas()) {
                System.out.print(dis.getNome() + " ");
            }
            System.out.println();
        }
    }

    public void printHorariosDosProfessores() {

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
    }

    public void printHorariosDosProfessores(String... nomes) throws ProfessorNotFound {

        System.out.println("\nHorarios dos professores:");

        String[] hr = {"7:00","9:00","11:00","14:00","16:00","18:00","20:00"};

        Professor prof;
        for (String nome : nomes) {
            prof = controleAcademico.procurarProfessor(nome);

            int i = 0;
            System.out.println(prof.getNome());
            Horario horario = prof.getHorario();

            System.out.println("      Seg Ter Qua Qui Sex");

            for (String[] dia : horario.getMatrizHorario()) {
                if(hr[i].length() < 5)
                    System.out.print(hr[i] + "  ");
                else
                    System.out.print(hr[i] + " ");

                int spacing = 4;
                for (String hora : dia) {
                    if(hora.length() > spacing){
                        spacing = hora.length();
                    }
                }

                for (String hora : dia) {
                    System.out.print(hora);
                    for(int m = 0; m < spacing-hora.length(); m++){
                        System.out.print(" ");
                    }
                }

                System.out.println();
                i++;
            }
            System.out.println();
        }
    }

    public void printAlunosDasDisciplinas() {

        System.out.println("\nAlunos das Disiciplinas:");
        for (Disciplina disc : controleAcademico.getDisciplinas()) {
            System.out.println(disc.getNome());

            for (Aluno aluno : disc.getAlunos()) {
                System.out.print(aluno.getNome() + " ");
            }
            System.out.println();
        }
    }

    public void printAlunosDasDisciplinas(String... nomes) throws DisciplinaNotFound {

        System.out.println("\nAlunos das Disiciplinas:");

        Disciplina disc;
        for (String nome : nomes) {
            disc = controleAcademico.procurarDisciplina(nome);

            System.out.println(disc.getNome());
            for (Aluno aluno : disc.getAlunos()) {
                System.out.print(aluno.getNome() + " ");
            }
            System.out.println();
        }
    }

    public void printDisciplinasDosAlunos() {

        System.out.println("\nDisciplinas do Aluno:");
        for (Aluno aluno : controleAcademico.getAlunos()) {
            System.out.println(aluno.getNome());

            for (Disciplina disc : aluno.getDisciplinas()) {
                System.out.print(disc.getNome() + " ");
            }
            System.out.println();
        }
    }

    public void printDisciplinasDosAlunos(String... nomes) throws AlunoNotFound {

        System.out.println("\nDisciplinas do Aluno:");

        Aluno aluno;
        for (String nome : nomes) {
            aluno = controleAcademico.procurarAluno(nome);

            System.out.println(aluno.getNome());
            for (Disciplina disc : aluno.getDisciplinas()) {
                System.out.print(disc.getNome() + " ");
            }
            System.out.println();
        }
    }

    public void printHorariosDosAlunos() {

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
    }

    public void printHorariosDosAlunos(String... nomes) throws AlunoNotFound {

        System.out.println("\nHorarios do Aluno:");

        String[] hr = {"7:00","9:00","11:00","14:00","16:00","18:00","20:00"};
        Aluno aluno;
        for (String nome : nomes) {
            aluno = controleAcademico.procurarAluno(nome);

            int i = 0;
            System.out.println(aluno.getNome());
            Horario horario = aluno.getHorario();

            System.out.println("      Seg Ter Qua Qui Sex");

            for (String[] dia : horario.getMatrizHorario()) {
                if(hr[i].length() < 5)
                    System.out.print(hr[i] + "  ");
                else
                    System.out.print(hr[i] + " ");

                int spacing = 4;
                for (String hora : dia) {
                    if(hora.length() > spacing){
                        spacing = hora.length();
                    }
                }

                for (String hora : dia) {
                    System.out.print(hora);
                    for(int m = 0; m < spacing-hora.length(); m++){
                        System.out.print(" ");
                    }
                }

                System.out.println();
                i++;
            }
            System.out.println();
        }
    }

    public void printNumeroAlunosDasDisciplinas() {

        System.out.println("\nNúmero de alunos da Disciplina:");
        for (Disciplina disc : controleAcademico.getDisciplinas()) {
            System.out.println(disc.getNome());
            System.out.println(disc.getAlunos().size() + " alunos.");
            System.out.println();
        }
    }

    public void printNumeroAlunosDasDisciplinas(String... nomes) throws DisciplinaNotFound {

        System.out.println("\nNúmero de alunos da Disciplina:");

        Disciplina disc;
        for (String nome : nomes) {
            disc = controleAcademico.procurarDisciplina(nome);
            System.out.println(disc.getNome());
            System.out.println(disc.getAlunos().size() + " alunos.");
        }
    }
}
