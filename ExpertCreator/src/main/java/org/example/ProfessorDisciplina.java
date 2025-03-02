package org.example;

public class ProfessorDisciplina extends MembroDisciplina {
    private Professor professor;

    public ProfessorDisciplina(Professor professor, Disciplina disciplina, String horaDaDisc) {
        super(disciplina, horaDaDisc);
        this.professor = professor;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void acrescentarHorario() {
        this.setHorario(construirHorario());
    }
}
