package org.example.Figuras;
import org.example.Visitors.VisitaFigura;

import java.lang.Math;
import java.util.concurrent.ExecutionException;

public class Triangulo implements ElementoConcreto{
    private double lado1;
    private double lado2;
    private double base;
    private double altura;
    private String tipo;

    public Triangulo(double l1, double l2, double l3) throws Exception {
        if(l1 <= 0 || l2 <= 0 || l3 <= 0) // Valores Negativos ou 0
            throw new Exception("Os dados devem ser maiores que zero");
        if(l1 + l2 <= l3 || l1 + l3 <= l2 || l2 + l3 <= l1) // Triangulo Inválido
            throw new Exception("A soma de dois lados deve ser maior que o terceiro lado");

        tipoTriangulo(l1,l2,l3);

        setLados(l1,l2,l3);

        altura = setAltura(lado1,lado2,base);
    }

    private double setAltura(double l1, double l2, double base) {
        if(this.tipo.equals("Equilatero"))
            return (l1*Math.sqrt(3))/2;
        else if(this.tipo.equals("Isoceles"))
            return Math.sqrt((l1*l2)-((base*base)/4));
        else{
            double s = (l1 + l2 + base) / 2;

            double area = Math.sqrt(s * (s - l1) * (s - l2) * (s - base));

            double h = (2 * area) / base;

            return h;
        }
    }

    private void setLados(double l1, double l2, double l3) {
        if(this.tipo.equals("Equilatero")){
            lado1 = l1;
            lado2 = l2;
            base = l3;
        }
        else if(this.tipo.equals("Isoceles")){
            if(l1 == l2){
                lado1 = l1;
                lado2 = l2;
                base = l3;
            }
            else if(l2 == l3){
                lado1 = l2;
                lado2 = l3;
                base = l1;
            }
            else
                lado1 = l1;
            lado2 = l3;
            base = l2;
        }
        else {
            if (l1 > l2 && l1 > l3) {
                base = l1;
                lado1 = l2;
                lado2 = l3;
            } else if (l2 > l1 && l2 > l3) {
                base = l2;
                lado1 = l1;
                lado2 = l3;
            } else {
                base = l3;
                lado1 = l1;
                lado2 = l2;
            }
        }
    }

    private void tipoTriangulo(double l1, double l2, double l3){
        if(l1 == l2 && l2 == l3) {
            tipo = "Equilatero";
        }
        else if(l1 == l2 || l2 == l3 || l1 == l3){
            tipo = "Isoceles";
        }
        else
            tipo = "Escaleno";
    }

    public double getLado1() {
        return lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }

    public String getTipo(){
        return this.tipo;
    }

    @Override
    public void aceitaVisita(VisitaFigura visitor) {
        visitor.visitaTriangulo(this);
    }
}
