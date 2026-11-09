package com.uniquindio.pedidos.chain;

import com.uniquindio.pedidos.model.Pedido;

/**
 * PATRÓN: Chain of Responsibility (Manejador Base)
 * Propósito: Define la estructura de la cadena para validar requisitos de un pedido.
 */
public abstract class ValidadorPedidoHandler {
    protected ValidadorPedidoHandler siguiente;

    public void setSiguiente(ValidadorPedidoHandler siguiente) {
        this.siguiente = siguiente;
    }

    public abstract boolean validar(Pedido pedido);
}
