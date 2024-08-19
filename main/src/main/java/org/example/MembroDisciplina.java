package org.example;

import java.util.Objects;

public abstract class MembroDisciplina {

    private Disciplina disciplina;

    private Horario horario;

    public MembroDisciplina(Disciplina disciplina, String hora) {
        this.disciplina = disciplina;
        this.horario = new Horario(hora,disciplina.getNome());
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Horario construirHorario() {

        String[][] construtorDoHorario = new String[7][5];

        // fazendo um "or" em todas os horarios das disciplinas

        Horario horarioDaDisc = horario;

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 5; j++) {
                if (Objects.equals(horarioDaDisc.getMatrizHorario()[i][j], disciplina.getNome()) | Objects.equals(construtorDoHorario[i][j], disciplina.getNome())) {
                    construtorDoHorario[i][j] = disciplina.getNome();
                }
                else {
                    construtorDoHorario[i][j] = "-";
                }
            }
        }

        return new Horario(construtorDoHorario);
    }

    public Horario getHorario(){
        return this.horario;
    }

    public abstract void acrescentarHorario();

    protected void setHorario(Horario horario) {
        this.horario = horario;
    }
}
