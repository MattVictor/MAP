package org.example;

import java.util.Objects;

public abstract class MembroDisciplina {

    private Disciplina disciplina;

    public MembroDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
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

        Horario horarioDaDisc = disciplina.getHorario();

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

    public abstract void acrescentarHorario();
}
