package com.ctd.finalbackend1.model;


import java.util.UUID;

public abstract class ADTO {
    // necesario para que al usarlo como clase superior en generics tenga el metodo
    public UUID getId() {return null;};
}
