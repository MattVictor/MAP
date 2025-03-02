package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Filme {
    private String nome;
    private String ano;
    private ArrayList<String> trilhaSonora;
    private ArrayList<PapelFuncionario> envolvidos;

    public Filme(String nome, String ano, String[] trilhas){
        this.nome = nome;
        this.ano = ano;

        this.trilhaSonora = new ArrayList<>();
        trilhaSonora.addAll(Arrays.asList(trilhas));

        this.envolvidos = new ArrayList<>();
    }

    public Filme(String nome, String[] trilhas){
        this.nome = nome;
        this.ano = "Não Informado";

        this.trilhaSonora = new ArrayList<>();
        trilhaSonora.addAll(Arrays.asList(trilhas));
    }

    public Filme(String nome, String ano){
        this.nome = nome;
        this.ano = ano;

        this.trilhaSonora = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getAno() {
        return ano;
    }

    public void addEnvolvido(Papel papel, Funcionario funcionario){
        this.envolvidos.add(new PapelFuncionario(funcionario.getNome(),papel));
    }

    public ArrayList<PapelFuncionario> getEnvolvidos(){
        return this.envolvidos;
    }

    public ArrayList<String> getTrilhaSonora() {
        return trilhaSonora;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Filme filme = (Filme) obj;
        return Objects.equals(nome, filme.nome) &&
                Objects.equals(ano, filme.ano) &&
                Objects.equals(trilhaSonora, filme.trilhaSonora);
    }
}
