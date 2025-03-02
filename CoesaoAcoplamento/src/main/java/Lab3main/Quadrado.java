package Lab3main;

public class Quadrado implements MetodosDasFigurasGeometricas {

    private final double lado;

    public Quadrado(double lado) {
        this.lado = lado;
    }

    @Override
    public double area() {
        return lado * lado;
    }

    @Override
    public double perimetro() {
        return lado * 4;
    }

    public double getLado() {
        return lado;
    }
}
