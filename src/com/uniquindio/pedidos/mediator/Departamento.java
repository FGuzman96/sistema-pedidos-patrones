package com.uniquindio.pedidos.mediator;

/**
 * PATRÓN: Mediator (Colega Base / Colleague)
 * Cada departamento mantiene referencia al mediador para comunicarse con los demás.
 */
public abstract class Departamento {
    protected MediadorDespacho mediador;

    public Departamento(MediadorDespacho mediador) {
        this.mediador = mediador;
    }
}
