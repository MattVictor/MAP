package org.example.ClassesPapeis;

import org.example.Papel;

public class Camera implements Papel {
    @Override
    public String exercerPapel() {
        return "Filmar";
    }

    public String toString(){
        return "Camera";
    }
}
