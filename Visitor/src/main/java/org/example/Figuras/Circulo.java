package org.example.Figuras;

import org.example.Visitors.VisitaFigura;

public class Circulo implements ElementoConcreto{
    private double raio;

    public Circulo(double raio) throws Exception {
        if(raio <= 0) // Valores Negativos ou 0
            throw new Exception("Valor de Raio Invalido");
        this.raio = raio;
    }

    public double getRaio(){
        return this.raio;
    }

    @Override
    public void aceitaVisita(VisitaFigura visitor) {
        visitor.visitaCirculo(this);
    }
}
