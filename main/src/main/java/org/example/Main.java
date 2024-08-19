package org.example;

import org.example.Exceptions.AlunoNotFound;
import org.example.Exceptions.DisciplinaNotFound;
import org.example.Exceptions.ProfessorNotFound;

public class Main {

    private static final String[] professores = {"Sabrina","Daniel","Fabio"};
    private static final String[] alunos = {"Matheus","Maria","Joseph","Samuel"};
    private static final String[] disciplinas = {"MAP","ATAL","BD"};
    private static final String[] horarios = {
            "T,F,F,F,F,T,F/F,F,F,T,F,F,F/F,F,F,F,F,F,F/F,F,F,F,T,F,F/F,F,F,F,F,T,F",
            "F,T,F,F,F,F,T/F,F,F,F,F,F,F/F,F,F,F,F,T,T/F,F,F,F,F,F,F/F,T,F,F,F,F,F",
            "F,F,T,F,T,F,F/F,T,F,F,F,F,F/F,F,F,F,F,F,F/F,T,F,F,F,F,F/F,F,T,F,F,F,F"
    };

    public static void main(String[] args) {

        ControleAcademico controleAcademico = new ControleAcademico();
        ConsolePrinter printer = new ConsolePrinter(controleAcademico);

        adicionarDisciplinasAoControle(controleAcademico, disciplinas);
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

    private static void adicionarDisciplinasAoControle(ControleAcademico controleAcademico, String[] disciplinas) {

        // adicionando disciplinas ao controle
        for (int i = 0; i < disciplinas.length; i++) {
            controleAcademico.adicionarDisciplina(disciplinas[i]);
        }
    }

    private static void alocarProfessores(ControleAcademico controleAcademico) {

        // alocando professores às suas disciplinas
        try {
            controleAcademico.alocarProfessor("Sabrina", "MAP",horarios[0]);
            controleAcademico.alocarProfessor("Daniel","ATAL",horarios[1]);
            controleAcademico.alocarProfessor("Fabio","BD",horarios[2]);
        }
        catch (ProfessorNotFound | DisciplinaNotFound e) {
            System.out.println(e.getMessage());
        }
    }

    private static void matricularAlunos(ControleAcademico controleAcademico) {

        // matriculando alunos às suas disciplinas
        try {
            controleAcademico.matricularAluno("Matheus","MAP",horarios[0]);
            controleAcademico.matricularAluno("Maria","MAP",horarios[0]);
            controleAcademico.matricularAluno("Joseph","MAP",horarios[0]);
            controleAcademico.matricularAluno("Samuel","MAP",horarios[0]);
            controleAcademico.matricularAluno("Matheus","ATAL",horarios[1]);
            controleAcademico.matricularAluno("Joseph","BD",horarios[2]);
            controleAcademico.matricularAluno("Samuel","ATAL",horarios[1]);
            controleAcademico.matricularAluno("Maria","BD",horarios[2]);
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