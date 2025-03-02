package Setores;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SetorFinanceiroTest {
    static SetorFinanceiro setorTeste;

    @BeforeAll
    public static void setup(){
        setorTeste = new SetorFinanceiro();
    }

    @Test
    public void testarAdicionarBalanco(){
        Assertions.assertEquals(setorTeste.adicionarNovoBalanco("B0015"),"B0015");
    }

    @Test
    public void testarAdicionarFolha(){
        Assertions.assertEquals(setorTeste.adicionarNovaFolha("F0012"),"F0012");
    }
}