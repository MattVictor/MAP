package org.example.Main;

import org.example.Exceptions.TipoInvalido;
import org.example.Sanduiches.Sanduiche;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CozinheiroTest {
    Cozinheiro cozinheiroTeste;

    @Before
    public void setup(){
        this.cozinheiroTeste = new Cozinheiro();
    }

    @Test
    public void criaSanduicheLight() throws TipoInvalido {
        Sanduiche sanduicheTeste = cozinheiroTeste.criarSanduiche(1);
        assertEquals("Sanduiche Light", sanduicheTeste.toString());
    }

    @Test
    public void criaSanduicheCheddar() throws TipoInvalido {
        Sanduiche sanduicheTeste = cozinheiroTeste.criarSanduiche(2);
        assertEquals("Sanduiche Cheddar", sanduicheTeste.toString());
    }

    @Test
    public void criaSanduicheMisto() throws TipoInvalido {
        Sanduiche sanduicheTeste = cozinheiroTeste.criarSanduiche(3);
        assertEquals("Sanduiche Misto", sanduicheTeste.toString());
    }

    @Test (expected = TipoInvalido.class)
    public void criaSanduicheInvalido() throws TipoInvalido {
        Sanduiche sanduicheTeste = cozinheiroTeste.criarSanduiche(4);
    }
}