package org.example.ClassesPapeis;

import org.example.Papel;

public class Cinegrafista implements Papel {
    @Override
    public String exercerPapel() {
        return "Montar o Cenário";
    }

    public String toString(){
        return "Cinegrafista";
    }
}
