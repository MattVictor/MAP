package org.example.Sanduiches;

import org.example.Products.Produto;
import org.example.Products.*;
import org.example.Products.subtiposOvo.OvoCapoeira;
import org.example.Products.subtiposPao.PaoBola;
import org.example.Products.subtiposPresunto.PresuntoPeru;
import org.example.Products.subtiposQueijo.QueijoCheddar;

public class SanduicheCheddar implements Sanduiche {

    public Produto[] sanduiche;

    public SanduicheCheddar() {
        this.sanduiche = criaSanduiche();
    }
    public Pao criaPao(){
        return new PaoBola();
    }

    public Queijo criaQueijo() {
        return new QueijoCheddar();
    }

    public Presunto criaPresunto(){
        return new PresuntoPeru();
    }

    public Ovo criaOvo(){
        return new OvoCapoeira();
    }

    public void printSanduiche() {
        System.out.println("\nNome: "+this.toString());
        for (Produto produto : sanduiche) {
            System.out.println(produto.getNome());
        }
    }

    public String toString(){
        return "Sanduiche Cheddar";
    }
}
