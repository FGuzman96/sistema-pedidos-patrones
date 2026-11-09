package com.uniquindio.pedidos.state;

import com.uniquindio.pedidos.model.Pedido;

/**
 * PATRÓN: State (Estado Concreto: Pendiente)
 * En este estado el pedido está recién registrado y esperando pago.
 */
public class EstadoPendiente implements EstadoPedido {

    @Override
    public void pagar(Pedido pedido) {
        System.out.println("[State Pendiente]: Pago recibido exitosamente.");
        pedido.setEstado(new EstadoPagado());
    }

    @Override
    public void despachar(Pedido pedido) {
        System.out.println("[State Pendiente]: ERROR - No se puede despachar un pedido que aún no ha sido pagado.");
    }

    @Override
    public void entregar(Pedido pedido) {
        System.out.println("[State Pendiente]: ERROR - No se puede entregar un pedido no despachado.");
    }

    @Override
    public void cancelar(Pedido pedido) {
        System.out.println("[State Pendiente]: Pedido cancelado por el usuario.");
        pedido.setEstado(new EstadoCancelado());
    }

    @Override
    public String getNombreEstado() {
        return "PENDIENTE DE PAGO";
    }
}
