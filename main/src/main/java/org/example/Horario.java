package org.example;

public class Horario {

    private String[][] matrizHorario;

    public Horario(String horario) {

        String[][] matrizTemp = new String[5][7];
        matrizHorario = new String[7][5];

        String[] diasSeparados = horario.split("/");

        for (int i = 0; i < diasSeparados.length; i++) {
            matrizTemp[i] = diasSeparados[i].split(",");
        }

        // transpondo a matriz
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                matrizHorario[j][i] = matrizTemp[i][j];
            }
        }
    }

    public Horario(String[][] matrizHorario) {
        this.matrizHorario = matrizHorario;
    }

    public String[][] getMatrizHorario() {
        return matrizHorario;
    }
}
