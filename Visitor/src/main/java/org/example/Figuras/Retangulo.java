package org.example.Figuras;

import org.example.Visitors.VisitaFigura;

public class Retangulo implements ElementoConcreto{
    private double largura;
    private double altura;

    public Retangulo(double l, double a) throws Exception {
        if(l <= 0 || a <= 0) // Valores Negativos ou 0
            throw new Exception("os dados devem ser maiores que zero");

        this.largura = l;
        this.altura = a;
    }

    public double getLargura(){
        return this.largura;
    }

    public double getAltura(){
        return this.altura;
    }

    @Override
    public void aceitaVisita(VisitaFigura visitor) {
        visitor.visitaRetangulo(this);
    }
}
