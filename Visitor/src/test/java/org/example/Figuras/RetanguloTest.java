package org.example.Figuras;

import org.example.Visitors.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RetanguloTest {
    private Retangulo retanguloTeste;

    @Before
    public void setup() throws Exception {
        retanguloTeste = new Retangulo(30,10);
    }

    @Test
    public void criarNovoRetangulo() throws Exception {
        Retangulo novoRetangulo = new Retangulo(15,7);
    }

    @Test (expected = Exception.class)
    public void retanguloLadoNegativo() throws Exception {
        Retangulo retanguloNegativo = new Retangulo(-5,12);
    }

    @Test (expected = Exception.class)
    public void retanguloLadoIgualAZero() throws Exception {
        Retangulo retanguloZero = new Retangulo(14, 0);
    }

    @Test
    public void testeLargura(){
        assertEquals(retanguloTeste.getLargura(), 30,0);
    }

    @Test
    public void testeAltura(){
        assertEquals(retanguloTeste.getAltura(),10,0);
    }

    @Test
    public void aceitaVisitaArea(){
        VisitorArea visitorTeste = new VisitorArea();

        retanguloTeste.aceitaVisita(visitorTeste);
    }

    @Test
    public void aceitaVisitaPerimetro(){
        VisitorPerimetro visitorTeste = new VisitorPerimetro();

        retanguloTeste.aceitaVisita(visitorTeste);
    }

    @Test
    public void aceitaVisitaMaximo(){
        VisitorMax visitorTeste = new VisitorMax();

        retanguloTeste.aceitaVisita(visitorTeste);
    }

    @Test
    public void aceitaVisitaDesenho(){
        VisitorDesenhar visitorTeste = new VisitorDesenhar();

        retanguloTeste.aceitaVisita(visitorTeste);
    }
}