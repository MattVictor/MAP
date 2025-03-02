package org.example.Figuras;

import org.example.Visitors.VisitaFigura;

public interface ElementoConcreto {
    public void aceitaVisita(VisitaFigura visitor);
}
