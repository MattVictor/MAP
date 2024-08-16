package org.example;

public class ProfessorDisciplina extends MembroDisciplina {
    private Professor professor;

    public ProfessorDisciplina(Professor professor, Disciplina disciplina) {
        super(disciplina);
        this.professor = professor;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void acrescentarHorario() {
        professor.setHorario(construirHorario());
    }
}
