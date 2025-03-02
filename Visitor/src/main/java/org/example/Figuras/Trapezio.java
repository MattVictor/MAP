package org.example.Figuras;

import org.example.Visitors.VisitaFigura;

public class Trapezio implements ElementoConcreto{
    private double baseMaior;
    private double baseMenor;
    private double ladoObliquoE;
    private double ladoObliquoD;
    private double altura;

    public Trapezio(double baseA, double baseB, double h) throws Exception {
        if(baseA <= 0 || baseB <= 0 || h <= 0) // Valores Negativos ou 0
            throw new Exception("Os dados devem ser maiores que zero");
        if(baseA == baseB)
            throw new Exception("As bases não podem ser iguais");

        if(baseA > baseB){
            baseMaior = baseA;
            baseMenor = baseB;
        }
        else{
            baseMaior = baseB;
            baseMenor = baseA;
        }

        double diferenca = (baseMaior-baseMenor)/2;
        this.ladoObliquoE = this.ladoObliquoD = Math.sqrt(((diferenca*diferenca)+(altura*altura)));
        this.altura = h;
    }

    public double getBaseMaior() {
        return baseMaior;
    }

    public double getBaseMenor() {
        return baseMenor;
    }

    public double getLadoObliquoE() {
        return ladoObliquoE;
    }

    public double getLadoObliquoD() {
        return ladoObliquoD;
    }

    public double getAltura() {
        return altura;
    }

    @Override
    public void aceitaVisita(VisitaFigura visitor) {
        visitor.visitaTrapezio(this);
    }
}
