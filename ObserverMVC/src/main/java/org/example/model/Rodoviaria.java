package org.example.model;

import java.util.ArrayList;
import java.util.Date;

public class Rodoviaria {

    private final ArrayList<Onibus> frota = new ArrayList<>();

    public void adicionarOnibus(Onibus onibus) {
        frota.add(onibus);
    }

    public void adicionarOnibus(int numero, String destino, Date chegada, Date saida, int numAssentos) {
        frota.add(new Onibus(numero, destino, chegada, saida, numAssentos));
    }

    public void removerOnibus(Onibus onibus) {
        frota.remove(onibus);
    }

    public ArrayList<Onibus> getFrota() {
        return frota;
    }
}
