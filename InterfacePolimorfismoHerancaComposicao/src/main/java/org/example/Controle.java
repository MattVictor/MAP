package org.example;

import org.example.ClassesPapeis.*;
import org.example.Exceptions.*;

import java.util.ArrayList;

public class Controle {
    private final ArrayList<Funcionario> funcionarios;
    private final ArrayList<Filme> filmes;

    public Controle() {
        this.funcionarios = new ArrayList<>();
        this.filmes = new ArrayList<>();
    }

    public Funcionario adicionarFuncionario(String nome) throws FuncionarioAlreadyExists {

        verificarFuncionarioJaExiste(nome);

        Funcionario funcionario = new Funcionario(nome);
        this.funcionarios.add(funcionario);
        return funcionario;
    }

    public Filme cadastrarFilme(String nome, String ano, String[] trilha) throws FilmeAlreadyExists {

        verificarFilmeJaExiste(nome);
        Filme filme = new Filme(nome,ano,trilha);
        this.filmes.add(filme);
        return filme;
    }

    public void cadastrarEnvolvidos(String filme, Papeis[] papeis, String[] envolvidos) throws UnmathcingSizes, FilmeNotFound, PapelNotFound, FuncionarioNotFound {

        if(papeis.length != envolvidos.length)
            throw new UnmathcingSizes("Papeis e envolvidos são de tamanhos diferentes");

        Filme filmeAtual;
        filmeAtual = procurarFilme(filme);

        for(int i = 0; i < envolvidos.length; i++){
            cadastrarPapelNoFilme(filmeAtual, papeis[i], envolvidos[i]);
        }
    }

    public Papel cadastrarPapelNoFilme(Filme filme, Papeis papel, String envolvido) throws PapelNotFound, FuncionarioNotFound {

        if(papel == null) {
            throw new PapelNotFound("Papel informado não existe");
        }

        Papel funcao;
        Funcionario funcionario;

        funcionario = procurarFuncionario(envolvido);

        funcao = switch (papel) {
            case ATOR -> new Ator();
            case ROTEIRISTA -> new Roteirista();
            case DIRETOR -> new Diretor();
            case CINEGRAFISTA -> new Cinegrafista();
            case CAMERA -> new Camera();
        };

        funcionario.addPapel(funcao, filme);
        filme.addEnvolvido(funcao, funcionario);

        return funcao;
    }

    public void mostrarFilmografia(String func) throws FuncionarioNotFound {

        Funcionario funcionario;
        funcionario = procurarFuncionario(func);

        System.out.println("Filmografia de "+func+":");

        for(FilmePapel filmografia : funcionario.getPapeis()){
            System.out.println("Filme: "+filmografia.getFilme()+" | Função: "+filmografia.getPapel().toString());
        }
    }

    public void mostrarDadosFilme(String filme) throws FilmeNotFound {

        Filme filmeDesejado;
        filmeDesejado = procurarFilme(filme);

        System.out.println("Dados do filme "+filmeDesejado.getNome()+":");
        System.out.println("Ano de Lançamento: "+filmeDesejado.getAno()+"\n");
        System.out.println("Trilha Sonora: ");
        for(String trilha : filmeDesejado.getTrilhaSonora())
            System.out.println(trilha);
        System.out.println();
        for(PapelFuncionario envolvido : filmeDesejado.getEnvolvidos())
            System.out.println(envolvido.getPapel().toString()+": "+envolvido.getFuncionario());
        System.out.println();
    }

    public Filme procurarFilme(String nomeDoFilme) throws FilmeNotFound {
        for(Filme filme : filmes){
            if(filme.getNome().equals(nomeDoFilme))
                return filme;
        }
        throw new FilmeNotFound("Filme não encontrado");
    }

    public Funcionario procurarFuncionario(String nomeDoFuncionario) throws FuncionarioNotFound {
        for(Funcionario func : funcionarios){
            if(func.getNome().equals(nomeDoFuncionario))
                return func;
        }
        throw new FuncionarioNotFound("Funcionario não encontrado.("+nomeDoFuncionario+")");
    }

    public Boolean verificarFuncionarioJaExiste(String nomeDoFuncionario) throws FuncionarioAlreadyExists {

        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equals(nomeDoFuncionario)){
                throw new FuncionarioAlreadyExists("Já existe um funcionário cadastrado com este nome.("+nomeDoFuncionario+")");
            }
        }
        return false;
    }

    public Boolean verificarFilmeJaExiste(String nomeDoFilme) throws FilmeAlreadyExists {

        for (Filme filme : filmes) {
            if (filme.getNome().equals(nomeDoFilme)){
                throw new FilmeAlreadyExists("Já existe um filme cadastrado com esse nome.");
            }
        }
        return false;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return this.funcionarios;
    }
}
