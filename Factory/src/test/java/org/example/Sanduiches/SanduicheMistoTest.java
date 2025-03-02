package org.example.Sanduiches;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SanduicheMistoTest {
    SanduicheMisto sanduicheTeste;

    @Before
    public void setup(){
        this.sanduicheTeste = new SanduicheMisto();
    }

    @Test
    public void paoTeste(){
        assertEquals("Pão Francês", sanduicheTeste.sanduiche[0].getNome());
    }

    @Test
    public void queijoTeste(){
        assertEquals("Queijo Mussarela", sanduicheTeste.sanduiche[1].getNome());
    }

    @Test
    public void presuntoTeste(){
        assertEquals("Presunto de Peru", sanduicheTeste.sanduiche[2].getNome());
    }

    @Test
    public void ovoTeste(){
        assertEquals("Ovo de Granja", sanduicheTeste.sanduiche[3].getNome());
    }
}