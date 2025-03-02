package Setores;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GestorProfessoresTest {
    private static GestorProfessores gestorTeste;

    @BeforeAll
    public static void setup(){
        gestorTeste = new GestorProfessores();
    }

    @Test
    public void testeAlocarDisciplina(){
        Assertions.assertEquals(gestorTeste.alocarNovaDisciplina("MAP"),"MAP");
    }

    @Test
    public void testeAdicionarTempoDeCasa(){
        Assertions.assertEquals(gestorTeste.adicionarTempoDeCasa("5 anos"), "5 anos");
    }
}