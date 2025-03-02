package org.example;

import java.util.Objects;

public class PapelFuncionario {
    // Classe para gerir a relação Papel e Pessoa, dentro da classe filmes
    private String funcionario;
    private Papel papel;

    public PapelFuncionario(String pessoa, Papel papel){
        this.funcionario = pessoa;
        this.papel = papel;
    }

    public PapelFuncionario(String pessoa) {
        this.funcionario = pessoa;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public Papel getPapel() {
        return papel;
    }

    public void setPapel(Papel papel) {
        this.papel = papel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PapelFuncionario papelFuncionario = (PapelFuncionario) o;

        // Compara o atributo funcionario dos dois objetos
        return Objects.equals(funcionario, papelFuncionario.funcionario);
    }
}
