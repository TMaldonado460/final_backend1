package com.ctd.finalbackend1.exceptions;

public class TurnoWithDateAlreadyPersisted extends Exception {
    private static final String MESSAGE = "Ya existe un turno con esa fecha";
    public TurnoWithDateAlreadyPersisted() {
        super(MESSAGE);
    }
}
