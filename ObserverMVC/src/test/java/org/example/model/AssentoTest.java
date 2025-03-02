package org.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssentoTest {
    Assento acentoTeste;

    @BeforeEach
    public void setup(){
        this.acentoTeste = new Assento(30);
    }

    @Test
    public void comprarAssento(){
        acentoTeste.comprarAssento("Matheus");

        assertEquals("Indisponível",acentoTeste.getStatus());
    }

    @Test
    public void reservarAssento(){
        acentoTeste.reservarAssento("Vinicius");

        assertEquals("Reservado",acentoTeste.getStatus());
    }

    @Test
    public void disponibilizarAssento(){
        acentoTeste.comprarAssento("Werlys");

        acentoTeste.disponibilizarAssento();

        assertEquals("Disponível",acentoTeste.getStatus());
    }

    @Test
    public void getOcupante(){
        acentoTeste.reservarAssento("Gustavo");

        assertEquals("Gustavo", acentoTeste.getOcupante());
    }

    @Test
    public void getOcupanteVazio(){
        acentoTeste.comprarAssento("João");

        acentoTeste.disponibilizarAssento();

        assertEquals("nenhum",acentoTeste.getOcupante());
    }

    @Test
    public void getNumero(){
        assertEquals(30,acentoTeste.getNumero());
    }
}