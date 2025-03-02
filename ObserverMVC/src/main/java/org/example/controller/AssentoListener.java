package org.example.controller;

import java.util.EventListener;

public interface AssentoListener extends EventListener {

    void assentoDisponivel(AssentoEvent e);

    void assentoReservado(AssentoEvent e);

    void assentoComprado(AssentoEvent e);
}
