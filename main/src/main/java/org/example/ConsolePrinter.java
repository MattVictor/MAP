package org.example;

import org.example.Exceptions.AlunoNotFound;
import org.example.Exceptions.DisciplinaNotFound;
import org.example.Exceptions.ProfessorNotFound;

import java.util.ArrayList;

public class ConsolePrinter {

    ControleAcademico controleAcademico;

    public ConsolePrinter(ControleAcademico controleAcademico) {
        this.controleAcademico = controleAcademico;
    }

    public void printDisciplinasDosProfessores() throws ProfessorNotFound {

        System.out.println("\nDisciplinas dos Professores:");

        for (Professor prof : controleAcademico.getProfessores()) {
            System.out.println(prof.getNome());

            ArrayList<ProfessorDisciplina> disciplinasDoProf = controleAcademico.getDisciplinasDoProfessor(prof.getNome());

            for (ProfessorDisciplina dis : disciplinasDoProf) {
                System.out.print(dis.getDisciplina().getNome() + " ");
            }
            System.out.println();
        }
    }

    public void printDisciplinasDosProfessores(String... nomes) throws ProfessorNotFound {

        System.out.println("\nDisciplinas dos Professores:");

        Professor prof;
        for (String nome : nomes) {
            prof = controleAcademico.procurarProfessor(nome);

            ArrayList<ProfessorDisciplina> disciplinasDoProf = controleAcademico.getDisciplinasDoProfessor(prof.getNome());

            System.out.println(prof.getNome());
            for (ProfessorDisciplina dis : disciplinasDoProf) {
                System.out.print(dis.getDisciplina().getNome() + " ");
            }
            System.out.println();
        }
    }

//    public void printHorariosDosProfessores() {
//
//        System.out.println("\nHorarios dos professores:");
//        for (Professor prof : controleAcademico.getProfessores()) {
//            System.out.println(prof.getNome());
//
//            Horario horario = prof.getHorario();
//            printHorario(horario);
//        }
//    }

    public void printHorariosDosProfessores(String... nomes) throws ProfessorNotFound {

        System.out.println("\nHorarios dos professores:");

        String[] hr = {"7:00","9:00","11:00","14:00","16:00","18:00","20:00"};
        for (String nome : nomes) {
            ArrayList<ProfessorDisciplina> disciplinasDoProf = controleAcademico.getDisciplinasDoProfessor(nome);

            System.out.println(nome);
            for (ProfessorDisciplina dis : disciplinasDoProf) {
                Horario horario = dis.getHorario();

                int i = 0;
                System.out.println("      Seg Ter Qua Qui Sex");

                for (String[] dia : horario.getMatrizHorario()) {
                    if(hr[i].length() < 5)
                        System.out.print(hr[i] + "  ");
                    else
                        System.out.print(hr[i] + " ");

                    int spacing = 4;

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
    }

    public void printAlunosDasDisciplinas() throws DisciplinaNotFound {

        System.out.println("\nAlunos das Disiciplinas:");
        for (Disciplina disc : controleAcademico.getDisciplinas()) {
            System.out.println(disc.getNome());

            ArrayList<Aluno> alunosDaDisc = controleAcademico.getAlunosDaDisciplina(disc.getNome());

            for (Aluno aluno : alunosDaDisc) {
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

            ArrayList<Aluno> alunosDaDisc = controleAcademico.getAlunosDaDisciplina(disc.getNome());

            System.out.println(disc.getNome());
            for (Aluno aluno : alunosDaDisc) {
                System.out.print(aluno.getNome() + " ");
            }
            System.out.println();
        }
    }

    public void printDisciplinasDosAlunos() throws AlunoNotFound {

        System.out.println("\nDisciplinas do Aluno:");
        for (Aluno aluno : controleAcademico.getAlunos()) {
            System.out.println(aluno.getNome());

            ArrayList<AlunoDisciplina> disciplinasDoAluno = controleAcademico.getDisciplinasDoAluno(aluno.getNome());

            for (AlunoDisciplina disc : disciplinasDoAluno) {
                System.out.print(disc.getDisciplina().getNome() + " ");
            }
            System.out.println();
        }
    }

    public void printDisciplinasDosAlunos(String... nomes) throws AlunoNotFound {

        System.out.println("\nDisciplinas do Aluno:");

        Aluno aluno;
        for (String nome : nomes) {
            aluno = controleAcademico.procurarAluno(nome);

            ArrayList<AlunoDisciplina> disciplinasDoAluno = controleAcademico.getDisciplinasDoAluno(aluno.getNome());

            System.out.println(aluno.getNome());
            for (AlunoDisciplina disc : disciplinasDoAluno) {
                System.out.print(disc.getDisciplina().getNome() + " ");
            }
            System.out.println();
        }
    }

//    public void printHorariosDosAlunos() {
//
//        System.out.println("\nHorarios do Aluno:");
//        for (Aluno aluno : controleAcademico.getAlunos()) {
//            System.out.println(aluno.getNome());
//
//            Horario horario = aluno.getHorario();
//            printHorario(horario);
//        }
//    }

    private void printHorario(Horario horario) {

        for (String[] dia : horario.getMatrizHorario()) {
            for (String hora : dia) {
                System.out.print(hora + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printHorariosDosAlunos(String... nomes) throws AlunoNotFound {

        System.out.println("\nHorarios do Aluno:");

        String[] hr = {"7:00","9:00","11:00","14:00","16:00","18:00","20:00"};
        for (String nome : nomes) {
            ArrayList<AlunoDisciplina> disciplinasDoProf = controleAcademico.getDisciplinasDoAluno(nome);

            System.out.println(nome);
            for (AlunoDisciplina dis : disciplinasDoProf) {
                Horario horario = dis.getHorario();

                int i = 0;
                System.out.println("      Seg Ter Qua Qui Sex");

                for (String[] dia : horario.getMatrizHorario()) {
                    if(hr[i].length() < 5)
                        System.out.print(hr[i] + "  ");
                    else
                        System.out.print(hr[i] + " ");

                    int spacing = 4;

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
    }

    public void printNumeroAlunosDasDisciplinas() throws DisciplinaNotFound {

        System.out.println("\nNúmero de alunos da Disciplina:");
        for (Disciplina disc : controleAcademico.getDisciplinas()) {
            System.out.println(disc.getNome());
            int quantAlunos = controleAcademico.getAlunosDaDisciplina(disc.getNome()).size();
            System.out.println(quantAlunos + " alunos.");
            System.out.println();
        }
    }

    public void printNumeroAlunosDasDisciplinas(String... nomes) throws DisciplinaNotFound {

        System.out.println("\nNúmero de alunos da Disciplina:");

        Disciplina disc;
        for (String nome : nomes) {
            disc = controleAcademico.procurarDisciplina(nome);
            System.out.println(disc.getNome());
            int quantAlunos = controleAcademico.getAlunosDaDisciplina(disc.getNome()).size();
            System.out.println(quantAlunos + " alunos.");
        }
    }
}
