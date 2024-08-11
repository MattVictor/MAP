package org.example;

public class Horario {

    private String[][] matrizHorario;

    public Horario(String horario) {
        matrizHorario = new String[5][7];

        String[] diasSeparados = horario.split("/");

        for (int i = 0; i < diasSeparados.length; i++) {
            matrizHorario[i] = diasSeparados[i].split(",");
        }
    }

    public Horario(String[][] matrizHorario) {
        this.matrizHorario = matrizHorario;
    }

    public String[][] getMatrizHorario() {
        return matrizHorario;
    }
}
