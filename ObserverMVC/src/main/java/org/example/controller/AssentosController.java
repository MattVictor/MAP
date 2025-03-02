package org.example.controller;

import org.example.exceptions.AssentoIndisponivel;
import org.example.exceptions.AssentoInvalido;
import org.example.exceptions.OnibusInvalido;
import org.example.model.*;

import java.util.ArrayList;

public class AssentosController {

    Rodoviaria rodoviaria;

    public AssentosController(Rodoviaria rodoviaria) {
        this.rodoviaria = rodoviaria;
    }

    public void addInterfaces(AssentoListener assentoListener) {
        for (Onibus onibus : rodoviaria.getFrota()) {
            for (Assento assento : onibus.getAssentos()) {
                assento.addAssentoListener(assentoListener);
            }
        }
    }

    public void reservarAssento(int numOnibus, int numAssento, String reservador) throws AssentoInvalido, AssentoIndisponivel, OnibusInvalido {

        Onibus onibus = findOnibus(numOnibus);
        Assento assento = findAssento(numAssento,onibus);

        if (assento.getStatus().equals("Disponível")) {
            assento.reservarAssento(reservador);
        }
        else throw new AssentoIndisponivel("O Assento "+numAssento+" não pode ser reservado.");
    }

    public void comprarAssento(int numOnibus, int numAssento, String comprador) throws AssentoInvalido, AssentoIndisponivel, OnibusInvalido {

        Onibus onibus = findOnibus(numOnibus);
        Assento assento = findAssento(numAssento,onibus);

        if (assento.getStatus().equals("Reservado")) {
            if (assento.getOcupante().equals(comprador)) {
                assento.comprarAssento(comprador);
            }
        }

        else if (assento.getStatus().equals("Disponível")) {
            assento.comprarAssento(comprador);
        }

        else throw new AssentoIndisponivel("O Assento "+numAssento+" não pode ser comprado.");
    }

    public void disponibilizarAssento(int numOnibus, int numAssento) throws AssentoInvalido, OnibusInvalido {
        Onibus onibus = findOnibus(numOnibus);
        Assento assento = findAssento(numAssento,onibus);
        assento.disponibilizarAssento();
    }

    public Onibus findOnibus(int numOnibus) throws OnibusInvalido {

        for (Onibus onibus : rodoviaria.getFrota()) {
            if (onibus.getNumero() == numOnibus) {
                return onibus;
            }
        }
        throw new OnibusInvalido("O ônibus "+numOnibus+" não existe ou não está disponível.");
    }

    public Assento findAssento(int numAssento, Onibus onibus) throws AssentoInvalido {

        for (Assento assento : onibus.getAssentos()) {
            if (assento.getNumero() == numAssento) {
                return assento;
            }
        }
        throw new AssentoInvalido("O assento "+numAssento+" não está disponível ou não existe no ônibus "+onibus.getNumero()+".");
    }

    public ArrayList<Onibus> getOnibus() {
        return rodoviaria.getFrota();
    }
}
