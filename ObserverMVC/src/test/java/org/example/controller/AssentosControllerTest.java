package org.example.controller;

import org.example.exceptions.AssentoIndisponivel;
import org.example.exceptions.AssentoInvalido;
import org.example.exceptions.OnibusInvalido;
import org.example.model.Onibus;
import org.example.model.Rodoviaria;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AssentosControllerTest {
    public AssentosController aCtest;

    @BeforeEach
    public void setup(){
        Rodoviaria rod = new Rodoviaria();

        rod.adicionarOnibus(new Onibus(10,"Campina Grande", new Date(10), new Date(11),50));
        rod.adicionarOnibus(new Onibus(20,"João Pessoa", new Date(20), new Date(31),100));

        aCtest = new AssentosController(rod);
    }

    @Test
    public void comprarAssentoTest() throws OnibusInvalido, AssentoInvalido, AssentoIndisponivel {
        aCtest.comprarAssento(10,5,"Matheus");

        assertEquals("Indisponível",aCtest.findAssento(5,aCtest.findOnibus(10)).getStatus());
    }

    @Test
    public void comprarAssentoIndisponivel() throws OnibusInvalido, AssentoInvalido, AssentoIndisponivel {
        aCtest.comprarAssento(10,2,"Luiz");

        assertThrows(AssentoIndisponivel.class,() -> aCtest.comprarAssento(10,2,"Gabriel"));
    }

    @Test
    public void reservarAssentoTest() throws OnibusInvalido, AssentoInvalido, AssentoIndisponivel {
        aCtest.reservarAssento(20,7,"Vinicius");

        assertEquals("Reservado",aCtest.findAssento(7,aCtest.findOnibus(20)).getStatus());
    }

    @Test
    public void reservarAssentoIndisponivel() throws OnibusInvalido, AssentoInvalido, AssentoIndisponivel {
        aCtest.comprarAssento(20,4,"Gabriel");

        assertThrows(AssentoIndisponivel.class,() -> aCtest.comprarAssento(20,4,"Luiz"));
    }

    @Test
    public void disponibilizarAssentoTest() throws OnibusInvalido, AssentoInvalido, AssentoIndisponivel {
        aCtest.disponibilizarAssento(10,5);

        assertEquals("Disponível",aCtest.findAssento(5,aCtest.findOnibus(10)).getStatus());
    }

    @Test
    public void findOnibusTest() throws OnibusInvalido {
        assertEquals(10,aCtest.findOnibus(10).getNumero());
    }

    @Test
    public void findOnibusInexistente() throws OnibusInvalido {
        assertThrows(OnibusInvalido.class,() -> aCtest.findOnibus(30));
    }

    @Test
    public void findAssentoInexistente() throws OnibusInvalido, AssentoInvalido {
        assertThrows(AssentoInvalido.class,() -> aCtest.findAssento(300,aCtest.findOnibus(20)));
    }
}