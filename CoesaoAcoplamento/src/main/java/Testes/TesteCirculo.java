package Testes;

import Lab3main.Circulo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TesteCirculo {
    private Circulo figura;

    @Before
    public void setUp(){
        this.figura = new Circulo(5);
    }

    @Test
    public void area(){
        Assert.assertEquals(78.5,this.figura.area(),0.1);
    }

    @Test
    public void perimetro(){
        Assert.assertEquals(31.4,figura.perimetro(),0.1);
    }

    @Test
    public void raio(){
        Assert.assertEquals(5,figura.getRaio(),0);
    }
}
