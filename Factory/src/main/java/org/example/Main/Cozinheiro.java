package org.example.Main;

import org.example.Exceptions.TipoInvalido;
import org.example.Sanduiches.*;

public class Cozinheiro {

    public Sanduiche criarSanduiche(int tipo) throws TipoInvalido {

        return switch (tipo) {
            case 1 -> new SanduicheLight();
            case 2 -> new SanduicheCheddar();
            case 3 -> new SanduicheMisto();
            default -> throw new TipoInvalido("Tipo invalido");
        };
    }
}
