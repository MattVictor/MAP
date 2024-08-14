package org.example;

import java.util.ArrayList;
import java.util.Objects;

public class MembroInstitucional {

    private String nome;
    private Horario horario;

    public MembroInstitucional(String nome) {
        this.nome = nome;
    }

    public void construirHorario(ArrayList<Disciplina> disciplinas) {

        String[][] construtorDoHorario = new String[7][5];

        // fazendo um "or" em todas os horarios das disciplinas
        for (Disciplina disc : disciplinas) {
            Horario horarioDaDisc = disc.getHorario();

            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 5; j++) {
                    if (Objects.equals(horarioDaDisc.getMatrizHorario()[i][j], disc.getNome()) | Objects.equals(construtorDoHorario[i][j], disc.getNome())) {
                        construtorDoHorario[i][j] = disc.getNome();
                    }
                    else {
                        construtorDoHorario[i][j] = "-";
                    }
                }
            }
        }

        horario = new Horario(construtorDoHorario);
    }

    public String getNome() {
        return nome;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }
}
