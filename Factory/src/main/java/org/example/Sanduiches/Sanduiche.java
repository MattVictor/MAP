package org.example.Sanduiches;

import org.example.Products.*;

public interface Sanduiche {

    public abstract void printSanduiche();

    public abstract Pao criaPao();

    public abstract Queijo criaQueijo();

    public abstract Presunto criaPresunto();

    public abstract Ovo criaOvo();

    public default Tomate criaTomate(){
        return new Tomate();
    }

    public default Produto[] criaSanduiche(){
        Pao pao = criaPao();
        Queijo queijo = criaQueijo();
        Presunto presunto = criaPresunto();
        Ovo ovo = criaOvo();
        Tomate tomate = criaTomate();

        return new Produto[]{pao,queijo,presunto,ovo,tomate,pao};
    }
}
