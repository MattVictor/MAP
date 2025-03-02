package org.example.Sanduiches;

import org.example.Products.*;
import org.example.Products.subtiposOvo.OvoGranja;
import org.example.Products.subtiposPao.PaoIntegral;
import org.example.Products.subtiposPresunto.PresuntoFrango;
import org.example.Products.subtiposQueijo.QueijoPrato;

public class SanduicheLight implements Sanduiche {

    public Produto[] sanduiche;

    public SanduicheLight() {
        this.sanduiche = criaSanduiche();
    }

    public Pao criaPao(){
        return new PaoIntegral();
    }

    public Queijo criaQueijo(){
        return new QueijoPrato();
    }

    public Presunto criaPresunto(){
        return new PresuntoFrango();
    }

    public Ovo criaOvo(){
        return new OvoGranja();
    }

    public void printSanduiche() {
        System.out.println("\nNome: "+this.toString());
        for (Produto produto : sanduiche) {
            System.out.println(produto.getNome());
        }
    }

    public String toString(){
        return "Sanduiche Light";
    }
}