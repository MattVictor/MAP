package org.example.Products;

public class Produto {
    private String nome;

    public Produto(String nome) {
        this.nome = nome;
    }

    public void printNome() {
        System.out.println(nome);
    }

    public String getNome() {
        return nome;
    }
}
