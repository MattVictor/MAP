package org.example.Sanduiches;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SanduicheLightTest {
    SanduicheLight sanduicheTeste;

    @Before
    public void setup(){
        this.sanduicheTeste = new SanduicheLight();
    }

    @Test
    public void paoTeste(){
        assertEquals("Pão Integral", sanduicheTeste.sanduiche[0].getNome());
    }

    @Test
    public void queijoTeste(){
        assertEquals("Queijo Prato", sanduicheTeste.sanduiche[1].getNome());
    }

    @Test
    public void presuntoTeste(){
        assertEquals("Presunto de Frango", sanduicheTeste.sanduiche[2].getNome());
    }

    @Test
    public void ovoTeste(){
        assertEquals("Ovo de Granja", sanduicheTeste.sanduiche[3].getNome());
    }
}