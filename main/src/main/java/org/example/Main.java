package org.example;

import org.example.Exceptions.AlunoNotFound;
import org.example.Exceptions.DisciplinaNotFound;
import org.example.Exceptions.ProfessorNotFound;

public class Main {

    public static void main(String[] args) {

        ControleAcademico controleAcademico = new ControleAcademico();
        ConsolePrinter printer = new ConsolePrinter(controleAcademico);

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


        try {
            printer.printDisciplinasDosProfessores("Sabrina","Daniel");
            printer.printHorariosDosProfessores("Daniel");
            printer.printAlunosDasDisciplinas("ATAL","BD");
            printer.printDisciplinasDosAlunos("Maria","Matheus");
            printer.printHorariosDosAlunos("Joseph","Maria","Matheus");
            printer.printNumeroAlunosDasDisciplinas("MAP","BD");
        }
        catch (ProfessorNotFound | DisciplinaNotFound | AlunoNotFound e) {
            System.out.println(e.getMessage());
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
            controleAcademico.adicionarDisciplina(new Disciplina(disciplinas[i]), new Horario(horarios[i], disciplinas[i]));
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

    private static void construirHorariosDosMembros(ControleAcademico controleAcademico){

        // construindo horarios baseado nas disciplinas
        for (AlunoDisciplina alnDisc : controleAcademico.getRelacaoAlunoDisciplina()) {
            alnDisc.acrescentarHorario();
        }
        for (ProfessorDisciplina profDisc : controleAcademico.getRelacaoProfessorDisciplina()) {
            profDisc.acrescentarHorario();
        }
    }
}