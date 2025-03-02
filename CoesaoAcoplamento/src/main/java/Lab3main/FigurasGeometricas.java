package Lab3main;

import Exceptions.FiguraDesconhecida;

public class FigurasGeometricas {

    public static final int CIRCULO = 0;
    public static final int QUADRADO = 1;
    public static final int RETANGULO = 2;
    public static final int TODOS = -1;

    private final Circulo circulo;
    private final Quadrado quadrado;
    private final Retangulo retangulo;

    public FigurasGeometricas(int altura, int largura, int lado, int raio){
        this.circulo = new Circulo(raio);
        this.quadrado = new Quadrado(lado);
        this.retangulo = new Retangulo(altura, largura);
    }

    public double perimetro(int tipoDaFigura) throws FiguraDesconhecida {

        return switch (tipoDaFigura) {
            case RETANGULO -> retangulo.perimetro();
            case QUADRADO -> quadrado.perimetro();
            case CIRCULO -> circulo.perimetro();
            default -> throw new FiguraDesconhecida("Tipo de figura fornecido não existe.");
        };
    }

    public double area(int tipoDaFigura) throws FiguraDesconhecida {

        return switch (tipoDaFigura) {
            case RETANGULO -> retangulo.area();
            case QUADRADO -> quadrado.area();
            case CIRCULO -> circulo.area();
            default -> throw new FiguraDesconhecida("Tipo de figura fornecido não existe.");
        };
    }

    public String toStringDaFigura(int tipoDaFigura) throws FiguraDesconhecida {

        return switch (tipoDaFigura) {
            case RETANGULO -> "O retângulo criado tem altura de tamanho: " + retangulo.getAltura() + " e largura de tamanho: " + retangulo.getLargura();
            case QUADRADO -> "O quadrado criado tem lados de tamanho: " + quadrado.getLado();
            case CIRCULO -> "O circulo criado tem raio de tamanho: " + circulo.getRaio();
            case TODOS -> "O retângulo criado tem altura: " + retangulo.getAltura() + " e largura de: " + retangulo.getLargura() + " O quadrado criado tem lados de: " + quadrado.getLado() + " O circulo criado tem raio de: " + circulo.getRaio();
            default -> throw new FiguraDesconhecida("Nenhuma função corresponde ao comando fornecido");
        };
    }
}