package Testes;

import Lab3main.Quadrado;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TesteQuadrado {

    private Quadrado figura;

    @Before
    public void setUp(){
        this.figura = new Quadrado(8);
    }

    @Test
    public void area(){
        Assert.assertEquals(64.0,figura.area(),0.0);
    }

    @Test
    public void perimetro(){
        Assert.assertEquals(32.0,figura.perimetro(),0.0);
    }

    @Test
    public void lado(){
        Assert.assertEquals(8.0,figura.getLado(),0.0);
    }
}
