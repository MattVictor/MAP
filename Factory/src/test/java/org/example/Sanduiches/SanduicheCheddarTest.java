package org.example.Sanduiches;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SanduicheCheddarTest {
    SanduicheCheddar sanduicheTeste;

    @Before
    public void setup(){
        this.sanduicheTeste = new SanduicheCheddar();
    }

    @Test
    public void paoTeste(){
        assertEquals("Pão Bola", sanduicheTeste.sanduiche[0].getNome());
    }

    @Test
    public void queijoTeste(){
        assertEquals("Queijo Cheddar", sanduicheTeste.sanduiche[1].getNome());
    }

    @Test
    public void presuntoTeste(){
        assertEquals("Presunto de Peru", sanduicheTeste.sanduiche[2].getNome());
    }

    @Test
    public void ovoTeste(){
        assertEquals("Ovo de Capoeira", sanduicheTeste.sanduiche[3].getNome());
    }
}