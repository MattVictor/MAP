package org.example.Main;

import org.example.Sanduiches.Sanduiche;

import java.util.ArrayList;

public class Main {

    private static Cozinheiro cozinheiro;
    private static ArrayList<Sanduiche> sanduiches;

    public static void main(String[] args) {

        cozinheiro = new Cozinheiro();
        sanduiches = new ArrayList<>();

        pedirSanduiches();

        for (Sanduiche sanduiche : sanduiches) {
            sanduiche.printSanduiche();
        }
    }

    private static void pedirSanduiches() {
        try {
            sanduiches.add(cozinheiro.criarSanduiche(1));
            sanduiches.add(cozinheiro.criarSanduiche(2));
            sanduiches.add(cozinheiro.criarSanduiche(3));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}