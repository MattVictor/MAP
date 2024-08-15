package org.example;

import java.util.ArrayList;
import java.util.Objects;

public class MembroInstitucional {

    private String nome;
    private Horario horario;

    public MembroInstitucional(String nome) {
        this.nome = nome;
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
