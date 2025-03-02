package Lab3main;

import Exceptions.FiguraDesconhecida;

public class BrincandoComAsFigurasGeometricas {

    public static void main(String[] args) {

        try {
            FigurasGeometricas fig = new FigurasGeometricas(10, 5, 7, 25);

            double per;
            per = fig.perimetro(FigurasGeometricas.RETANGULO);
            per = fig.perimetro(FigurasGeometricas.CIRCULO);
            per = fig.perimetro(-2); // erro de figura inexistente
            per = fig.perimetro(1); // erro

            fig.area(0);
            fig.area(-1);
            fig.area(2);
            fig.area(1);
            fig.area(-2);
        }
        catch (FiguraDesconhecida e) {
            System.out.println(e.getMessage());
        }
    }
}