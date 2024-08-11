package org.example;

import java.util.ArrayList;
import java.util.Objects;

public class MembroInstitucional {

    private String nome;
    private ArrayList<Disciplina> disciplinas;
    private Horario horario;

    public MembroInstitucional(String nome) {
        this.nome = nome;
        this.disciplinas = new ArrayList<>();
    }

    void construirHorario() {

        String[][] construtorDoHorario = new String[7][5];

        // fazendo um "or" em todas os horarios das disciplinas
        for (Disciplina disc : disciplinas) {
            Horario horarioDaDisc = disc.getHorario();

            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 5; j++) {
                    if (Objects.equals(horarioDaDisc.getMatrizHorario()[i][j], "T") | Objects.equals(construtorDoHorario[i][j], "T")) {
                        construtorDoHorario[i][j] = "T";
                    }
                    else {
                        construtorDoHorario[i][j] = "F";
                    }
                }
            }
        }

        horario = new Horario(construtorDoHorario);
    }

    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void addDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
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
