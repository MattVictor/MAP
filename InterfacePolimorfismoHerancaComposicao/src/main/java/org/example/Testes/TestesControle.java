package org.example.Testes;

import org.example.*;
import org.example.ClassesPapeis.Diretor;
import org.example.Exceptions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestesControle {

    private static Controle controle;
    private static Funcionario funcionario;
    private static Filme filme;

    @BeforeAll
    public static void setUpBefore() throws FilmeAlreadyExists, FuncionarioAlreadyExists {
        controle = new Controle();
        funcionario = new Funcionario("Matheus Victor");
        filme = new Filme("Ventos do Destino","2021",new String[]{"\"Caminhos Cruzados\" - John Williams", "\"Maré Alta\" - Ennio Morricone", "\"Horizontes Distantes\" - Alexandre Desplat"});

        controle.cadastrarFilme("Ecos do Silêncio","2023",new String[]{"\"Sombras do Amanhecer\" - Hans Zimmer", "\"O Vazio do Tempo\" - Ludovico Einaudi", "\"Luzes no Escuro\" - Max Richter"});
        controle.adicionarFuncionario("Quentin Tarantino");
    }

    @Test
    public void testarAdicionarFuncionario() throws FuncionarioAlreadyExists {
        Funcionario funcionarioTeste = controle.adicionarFuncionario("Matheus Victor");
        assertEquals(funcionarioTeste, funcionario, "Funcionario diferente no Controle.");
    }

    @Test
    public void testarCadastrarFilme() throws FilmeAlreadyExists {

        String nome = "Ventos do Destino";
        String ano = "2021";
        String[] trilha = {"\"Caminhos Cruzados\" - John Williams", "\"Maré Alta\" - Ennio Morricone", "\"Horizontes Distantes\" - Alexandre Desplat"};

        Filme filmeTeste = controle.cadastrarFilme(nome,ano,trilha);
        assertEquals(filmeTeste, filme);
    }

    @Test
    public void testarProcurarFilme() throws FilmeNotFound {
        controle.procurarFilme("Ecos do Silêncio");
        //controle.procurarFilme("O Homem do Futuro");
    }

    @Test
    public void testarProcurarFuncionario() throws FuncionarioNotFound {
        controle.procurarFuncionario("Quentin Tarantino");
        //controle.procurarFuncionario("Matheus Victor");
    }

    @Test
    public void testarVerificarFuncionario() throws FuncionarioAlreadyExists {
        controle.verificarFuncionarioJaExiste("Morgan Freeeman");
        controle.verificarFuncionarioJaExiste("Matheus Victor");
    }

    @Test
    public void testarVerificarFilme() throws FilmeAlreadyExists {
        controle.verificarFilmeJaExiste("Bacurau");
        //controle.verificarFilmeJaExiste("Ecos do Silêncio");
    }
}
