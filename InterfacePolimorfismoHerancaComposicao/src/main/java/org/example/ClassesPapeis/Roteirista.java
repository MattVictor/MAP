package org.example.ClassesPapeis;

import org.example.Papel;

public class Roteirista implements Papel {
    @Override
    public String exercerPapel() {
        return "Escrever o roteiro";
    }

    public String toString(){
        return "Roteirista";
    }
}
