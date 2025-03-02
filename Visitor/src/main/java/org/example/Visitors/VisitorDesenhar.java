package org.example.Visitors;

import org.example.Figuras.*;

public class VisitorDesenhar implements VisitaFigura{
    @Override
    public void visitaRetangulo(Retangulo retangulo) {
        for (int i = 0; i < retangulo.getAltura(); i++) {
            for (int j = 0; j < retangulo.getLargura(); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    @Override
    public void visitaCirculo(Circulo circulo) {
        double raio = circulo.getRaio();
        for (int i = 0; i <= 2*raio; i++) {
            for (int j = 0; j <= 2*raio; j++) {
                double dx = raio - i;
                double dy = raio - j;
                if (dx * dx + dy * dy <= raio * raio) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    @Override
    public void visitaTriangulo(Triangulo triangulo) {
        double altura = triangulo.getAltura();

        String tipo = triangulo.getTipo();

        if(tipo.equals("Equilatero")){
            for (int i = 0; i < altura; i++) {
                for (int j = 0; j < altura - i - 1; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < 2 * i + 1; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }else if(tipo.equals("Isoceles")) {
            double razao = altura/triangulo.getBase();
            for (int i = 0; i < triangulo.getBase(); i++) {
                for(int x = 1; x < razao; x++) {
                    for (int j = 0; j < altura - i - 1; j++) {
                        System.out.print(" ");
                    }
                    for (int j = 0; j < 2 * i + 1; j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
            }
        }else{
            for (int i = 1; i <= altura; i++) {
                for (int j = 1; j <= i; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }

    @Override
    public void visitaTrapezio(Trapezio trapezio) {
        double altura = trapezio.getAltura();
        double baseMenor = trapezio.getBaseMenor();
        double baseMaior = trapezio.getBaseMaior();

        for (int i = 0; i < altura; i++) {
            double larguraAtual = baseMenor + i * (baseMaior - baseMenor) / (altura - 1);
            for (int j = 0; j < (baseMaior - larguraAtual) / 2; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= larguraAtual; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
