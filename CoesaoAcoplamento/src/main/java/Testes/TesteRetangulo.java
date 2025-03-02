package Testes;

import Lab3main.Retangulo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TesteRetangulo {
    private Retangulo figura;

    @Before
    public void setUp(){
        this.figura = new Retangulo(5,10);
    }

    @Test
    public void perimetro(){
        Assert.assertEquals(30.0,figura.perimetro(),0.0);
    }

    @Test
    public void area(){
        Assert.assertEquals(50.0,figura.area(),0.0);
    }

    @Test
    public void altura(){
        Assert.assertEquals(5.0,figura.getAltura(),0.0);
    }

    @Test
    public void largura(){
        Assert.assertEquals(10.0,figura.getLargura(),0.0);
    }
}
