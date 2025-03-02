package Setores;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GestorAlunosTest {
    static GestorAlunos gestorTeste;

    @BeforeAll
    public static void setup(){
        gestorTeste = new GestorAlunos();
        gestorTeste.adicionarRdm("002234");
    }

    @Test
    public void testeAdicionarRDM(){
        Assertions.assertEquals(gestorTeste.adicionarRdm("028341"), "028341");
    }

    @Test
    public void adicionarRDMExistente(){
        Assertions.assertEquals(gestorTeste.adicionarRdm("002234"),"Este RDM já está registrado");
    }

    @Test
    public void adicionarHistorico(){
        Assertions.assertEquals(gestorTeste.adicionarHistorico("MAP\nATAL\nParadigmas"), "MAP\nATAL\nParadigmas");
    }
}