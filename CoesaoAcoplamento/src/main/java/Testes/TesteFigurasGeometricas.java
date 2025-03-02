package Testes;

import Exceptions.FiguraDesconhecida;
import Lab3main.FigurasGeometricas;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TesteFigurasGeometricas {
    private FigurasGeometricas fig;

    @Before
    public void setUp(){
        this.fig = new FigurasGeometricas(20, 7, 12, 32);
    }

    @Test
    public void perimetroDoRetangulo() throws FiguraDesconhecida {
        Assert.assertEquals(54.0,fig.perimetro(2),0.0);
    }

    @Test
    public void perimetroDoQuadrado() throws FiguraDesconhecida {
        Assert.assertEquals(48.0,fig.perimetro(1),0.0);
    }

    @Test
    public void perimetroDoCirculo() throws FiguraDesconhecida {
        Assert.assertEquals(201.0,fig.perimetro(0),0.1);
    }

    @Test (expected = FiguraDesconhecida.class)
    public void figuraInexistentePerimetro() throws FiguraDesconhecida {
        Assert.assertEquals(54.0,fig.perimetro(-2),0.0);
    }

    @Test
    public void areaDoRetangulo() throws FiguraDesconhecida {
        Assert.assertEquals(140.0,fig.area(FigurasGeometricas.RETANGULO),0.0);
    }

    @Test
    public void areaDoQuadrado() throws FiguraDesconhecida {
        Assert.assertEquals(144.0,fig.area(FigurasGeometricas.QUADRADO),0.0);
    }

    @Test
    public void areaDoCirculo() throws FiguraDesconhecida {
        Assert.assertEquals(3216.9,fig.area(FigurasGeometricas.CIRCULO),0.1);
    }

    @Test (expected = FiguraDesconhecida.class)
    public void figuraInexistenteArea() throws FiguraDesconhecida {
        Assert.assertEquals(54.0,fig.area(-5),0.0);
    }

    @Test
    public void toStringDoRetangulo() throws FiguraDesconhecida {
        Assert.assertEquals("O retângulo criado tem altura de tamanho: 20.0 e largura de tamanho: 7.0",fig.toStringDaFigura(2));
    }

    @Test
    public void toStringDoQuadrado() throws FiguraDesconhecida {
        Assert.assertEquals("O quadrado criado tem lados de tamanho: 12.0",fig.toStringDaFigura(1));
    }

    @Test
    public void toStringDoCirculo() throws FiguraDesconhecida {
        Assert.assertEquals("O circulo criado tem raio de tamanho: 32.0",fig.toStringDaFigura(0));
    }

    @Test
    public void toStringDeTodos() throws FiguraDesconhecida {
        Assert.assertEquals("O retângulo criado tem altura: 20.0 e largura de: 7.0 O quadrado criado tem lados de: 12.0 O circulo criado tem raio de: 32.0",fig.toStringDaFigura(-1));
    }

    @Test (expected = FiguraDesconhecida.class)
    public void toStringDoDesconhecido() throws FiguraDesconhecida {
        Assert.assertEquals("O quadrado criado tem lados de tamanho: 12.0",fig.toStringDaFigura(5));
    }
}
