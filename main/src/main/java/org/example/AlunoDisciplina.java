package org.example;

public class AlunoDisciplina extends MembroDisciplina {
    private Aluno aluno;

    public AlunoDisciplina(Aluno aluno, Disciplina disciplina) {
        super(disciplina);
        this.aluno = aluno;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public void acrescentarHorario() {
        aluno.setHorario(construirHorario());
    }
}
