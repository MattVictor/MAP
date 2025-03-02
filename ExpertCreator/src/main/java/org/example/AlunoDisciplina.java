package org.example;

public class AlunoDisciplina extends MembroDisciplina {
    private Aluno aluno;

    public AlunoDisciplina(Aluno aluno, Disciplina disciplina, String horaDaDisc) {
        super(disciplina,horaDaDisc);
        this.aluno = aluno;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public void acrescentarHorario() {
        this.setHorario(construirHorario());
    }
}
