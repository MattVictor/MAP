package org.example.Testes;

import org.example.ClassesPapeis.Ator;
import org.example.ClassesPapeis.Diretor;
import org.example.Filme;
import org.example.Funcionario;
import org.example.PapelFuncionario;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestesFilmes {

    private static Filme filme;
    private static Funcionario funcionario1;
    private static Funcionario funcionario2;


    @BeforeAll
    public static void setUpBefore() {
        String nome = "Ecos do Silêncio";
        String ano = "2023";
        String[] trilha = {"\"Sombras do Amanhecer\" - Hans Zimmer", "\"O Vazio do Tempo\" - Ludovico Einaudi", "\"Luzes no Escuro\" - Max Richter"};

        filme = new Filme(nome, ano, trilha);
        funcionario1 = new Funcionario("Matheus Victor");
        funcionario2 = new Funcionario("Vinicius Araujo");

        filme.addEnvolvido(new Diretor(), funcionario1);
        filme.addEnvolvido(new Ator(), funcionario2);
    }

    @Test
    public void testarEnvolvidos() {
        Filme filmeTeste = new Filme("Ventos do Destino","2021",new String[]{"\"Caminhos Cruzados\" - John Williams", "\"Maré Alta\" - Ennio Morricone", "\"Horizontes Distantes\" - Alexandre Desplat"});

        filmeTeste.addEnvolvido(new Diretor(), funcionario1);
        filmeTeste.addEnvolvido(new Ator(), funcionario2);

        for (int i = 0; i < filmeTeste.getEnvolvidos().size(); i++) {
            assertEquals(filmeTeste.getEnvolvidos().get(i), filme.getEnvolvidos().get(i));
        }
    }

    @Test
    public void testarTrilhaSonora() {
        String[] trilha = {"\"Sombras do Amanhecer\" - Hans Zimmer", "\"O Vazio do Tempo\" - Ludovico Einaudi", "\"Luzes no Escuro\" - Max Richter"};

        Filme filmeTeste = new Filme("Ventos do Destino","2021",trilha);

        assertEquals(filmeTeste.getTrilhaSonora(),filme.getTrilhaSonora());
    }
}
