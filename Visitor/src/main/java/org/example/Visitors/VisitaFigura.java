package org.example.Visitors;

import org.example.Figuras.*;

public interface VisitaFigura {
    // Não é possível realizar testes para estas classes por seu retorno ser void
    // o retorno não pode mudar devido ao fato que cada função precisaria de um
    // retorno diferente

    public void visitaRetangulo(Retangulo retangulo);

    public void visitaCirculo(Circulo circulo);

    public void visitaTriangulo(Triangulo triangulo);

    public void visitaTrapezio(Trapezio trapezio);
}
