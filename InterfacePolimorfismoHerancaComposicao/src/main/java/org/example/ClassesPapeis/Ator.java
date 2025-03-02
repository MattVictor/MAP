package org.example.ClassesPapeis;

import org.example.Papel;

public class Ator implements Papel {
    @Override
    public String exercerPapel() {
        return "Atuar";
    }

    public String toString(){
        return "Ator";
    }
}
