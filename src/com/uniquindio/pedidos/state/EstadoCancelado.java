package com.uniquindio.pedidos.state;

import com.uniquindio.pedidos.model.Pedido;

/**
 * PATRÓN: State (Estado Concreto: Cancelado)
 */
public class EstadoCancelado implements EstadoPedido {

    @Override
    public void pagar(Pedido pedido) {
        System.out.println("[State Cancelado]: ERROR - No se puede pagar un pedido cancelado.");
    }

    @Override
    public void despachar(Pedido pedido) {
        System.out.println("[State Cancelado]: ERROR - No se puede despachar un pedido cancelado.");
    }

    @Override
    public void entregar(Pedido pedido) {
        System.out.println("[State Cancelado]: ERROR - No se puede entregar un pedido cancelado.");
    }

    @Override
    public void cancelar(Pedido pedido) {
        System.out.println("[State Cancelado]: AVISO - El pedido ya está cancelado.");
    }

    @Override
    public String getNombreEstado() {
        return "CANCELADO";
    }
}
