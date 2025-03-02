package Lab3main;

public class Circulo implements MetodosDasFigurasGeometricas {

    public final double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    @Override
    public double area() {
        return 3.1415 * raio * raio;
    }

    @Override
    public double perimetro() {
        return 2 * 3.1415 * raio;
    }

    public double getRaio() {
        return raio;
    }
}
