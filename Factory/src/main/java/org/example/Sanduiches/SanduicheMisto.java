package org.example.Sanduiches;

import org.example.Products.*;
import org.example.Products.subtiposOvo.OvoGranja;
import org.example.Products.subtiposPao.PaoFrances;
import org.example.Products.subtiposPresunto.PresuntoPeru;
import org.example.Products.subtiposQueijo.QueijoMussarela;

public class SanduicheMisto implements Sanduiche {

    public Produto[] sanduiche;

    public SanduicheMisto() {
        this.sanduiche = criaSanduiche();
    }
    public Pao criaPao(){
        return new PaoFrances();
    }

    public Queijo criaQueijo(){
        return new QueijoMussarela();
    }

    public Presunto criaPresunto(){
        return new PresuntoPeru();
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
        return "Sanduiche Misto";
    }
}
