package org.example.ClassesPapeis;

import org.example.Papel;

public class Diretor implements Papel {
    @Override
    public String exercerPapel() {
        return "Dirigir o Filme";
    }

    public String toString(){
        return "Diretor";
    }
}
