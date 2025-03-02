package Setores;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SetorInfraestruturaTest {
    static SetorInfraestrutura setorTeste;
    @BeforeAll
    public static void setup(){
        setorTeste = new SetorInfraestrutura();
    }

    @Test
    public void testarAdicicao(){
        Assertions.assertEquals(setorTeste.alocarNovaSala("B103"),"B103");
    }

    @Test
    public void testarSalaAlocada(){
        Assertions.assertTrue(setorTeste.salaEstaAlocada("B103"));
    }

    @Test
    public void testarSalaNaoAlocada(){
        Assertions.assertFalse(setorTeste.salaEstaAlocada("C206"));
    }

    @Test
    public void testarGetAlocacao(){
        Assertions.assertEquals(setorTeste.getAlocacaoSala().getLast(),"B103");
    }
}