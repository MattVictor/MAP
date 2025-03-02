package org.example.controller;

import org.example.model.Assento;
import java.util.EventObject;

public class AssentoEvent extends EventObject {

    public AssentoEvent(Assento source) {
        super(source);
    }
}
