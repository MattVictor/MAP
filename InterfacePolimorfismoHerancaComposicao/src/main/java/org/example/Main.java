package org.example;

import org.example.Exceptions.*;

public class Main {
    static Controle contrlFuncionariosGlobo;
    static private String[] filmes;
    static private String[] anosDeLancamento;
    static private String[][] trilhasSonoras;
    static private String[] funcionarios;
    static private Papeis[] papeis;

    public static void main(String[] args) {
        contrlFuncionariosGlobo = new Controle();
        iniciarVariaveis();

        try {
            cadastrarFilmes();
            cadastrarFuncionarios();
            alocarFuncionarios();

            mostrarDadosDoFilme("Ecos do Silêncio");
            mostrarFilmografiaDoFuncionario("Idris Elba");
        }
        catch (FilmeNotFound | PapelNotFound | UnmathcingSizes | FuncionarioNotFound | FuncionarioAlreadyExists |
               FilmeAlreadyExists e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private static void iniciarVariaveis() {

        filmes = new String[]{"Ecos do Silêncio", "Ventos do Destino", "Sombras da Meia-Noite"};
        anosDeLancamento = new String[]{"2023", "2021", "2022"};

        trilhasSonoras = new String[][]{
                {"\"Sombras do Amanhecer\" - Hans Zimmer", "\"O Vazio do Tempo\" - Ludovico Einaudi", "\"Luzes no Escuro\" - Max Richter"},
                {"\"Caminhos Cruzados\" - John Williams", "\"Maré Alta\" - Ennio Morricone", "\"Horizontes Distantes\" - Alexandre Desplat"},
                {"\"Dança das Sombras\" - Philip Glass", "\"Noite Sem Fim\" - Jóhann Jóhannsson", "\"Eco Distante\" - Ryuichi Sakamoto"}};
        funcionarios = new String[]{
                "Quentin Tarantino", "Christopher Nolan", "Leonardo DiCaprio", "Ana Souza",
                "Tom Hardy", "Cate Blanchett", "Idris Elba", "Joaquin Phoenix", "Sofia Coppola", "Fernanda Lima",
                "Christian Bale", "Timothée Chalamet", "Zendaya", "Marion Cotillard"};
        papeis = new Papeis[]{
                Papeis.DIRETOR, Papeis.ROTEIRISTA, Papeis.CAMERA, Papeis.CINEGRAFISTA,
                Papeis.ATOR, Papeis.ATOR, Papeis.ATOR, Papeis.ATOR, Papeis.ATOR};
    }

    private static void mostrarFilmografiaDoFuncionario(String nome) throws FuncionarioNotFound {
        contrlFuncionariosGlobo.mostrarFilmografia(nome);
    }

    private static void mostrarDadosDoFilme(String nome) throws FilmeNotFound {
        contrlFuncionariosGlobo.mostrarDadosFilme(nome);
    }

    private static void alocarFuncionarios() throws FilmeNotFound, PapelNotFound, UnmathcingSizes, FuncionarioNotFound {

        // Alocando Funcionários do primeiro filme
        String[] funcionariosFilme1 = {
                "Quentin Tarantino", "Christopher Nolan", "Leonardo DiCaprio", "Ana Souza", "Marion Cotillard",
                "Tom Hardy", "Cate Blanchett", "Idris Elba", "Joaquin Phoenix"};

        // Alocando funcionarios do segundo filme
        String[] funcionariosFilme2 = {
                "Ana Souza", "Marion Cotillard", "Tom Hardy", "Cate Blanchett", "Idris Elba",
                "Joaquin Phoenix", "Sofia Coppola", "Fernanda Lima", "Christian Bale"};

        // Alocando funcionários do terceiro filme
        String[] funcionariosFilme3 = {
                "Idris Elba", "Joaquin Phoenix", "Sofia Coppola", "Fernanda Lima",
                "Christian Bale", "Timothée Chalamet", "Cate Blanchett", "Zendaya", "Marion Cotillard"};

        contrlFuncionariosGlobo.cadastrarEnvolvidos(filmes[0], papeis,funcionariosFilme1);
        contrlFuncionariosGlobo.cadastrarEnvolvidos(filmes[1], papeis,funcionariosFilme2);
        contrlFuncionariosGlobo.cadastrarEnvolvidos(filmes[2], papeis,funcionariosFilme3);
    }

    private static void cadastrarFuncionarios() throws FuncionarioAlreadyExists {
        // Adiciona todos os funcionarios ao sistema
        for(String funcionario : funcionarios)
            contrlFuncionariosGlobo.adicionarFuncionario(funcionario);
    }

    private static void cadastrarFilmes() throws FilmeAlreadyExists {
        for(int i = 0; i < filmes.length; i++){
            contrlFuncionariosGlobo.cadastrarFilme(filmes[i],anosDeLancamento[i],trilhasSonoras[i]);
        }
    }
}