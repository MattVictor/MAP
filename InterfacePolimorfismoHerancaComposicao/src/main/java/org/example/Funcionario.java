package org.example;

import java.util.ArrayList;
import java.util.Objects;

public class Funcionario {
    private final String nome;
    private final ArrayList<FilmePapel> papeis;

    public Funcionario(String nome){
        this.nome = nome;
        this.papeis = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<FilmePapel> getPapeis() {
        return papeis;
    }

    public void addPapel(Papel novoPapel, Filme filme){
        papeis.add(new FilmePapel(filme.getNome(),novoPapel));
    }

    @Override
    public boolean equals(Object obj) {  // usado nos testes
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Funcionario func = (Funcionario) obj;
        return Objects.equals(nome, func.nome) && Objects.equals(papeis, func.papeis);
    }
}
