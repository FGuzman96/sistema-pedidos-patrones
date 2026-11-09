package com.uniquindio.pedidos.state;

import com.uniquindio.pedidos.model.Pedido;

/**
 * PATRÓN: State (Estado Concreto: Pagado)
 * El pedido ya está pagado y puede ser despachado a bodega y transporte.
 */
public class EstadoPagado implements EstadoPedido {

    @Override
    public void pagar(Pedido pedido) {
        System.out.println("[State Pagado]: AVISO - El pedido ya se encuentra pagado.");
    }

    @Override
    public void despachar(Pedido pedido) {
        System.out.println("[State Pagado]: Despacho autorizado. Saliendo de bodega hacia transporte.");
        pedido.setEstado(new EstadoEnviado());
    }

    @Override
    public void entregar(Pedido pedido) {
        System.out.println("[State Pagado]: ERROR - El pedido debe enviarse antes de ser entregado.");
    }

    @Override
    public void cancelar(Pedido pedido) {
        System.out.println("[State Pagado]: Pedido cancelado antes de despachar. Se programa reembolso de dinero.");
        pedido.setEstado(new EstadoCancelado());
    }

    @Override
    public String getNombreEstado() {
        return "PAGADO (Listo para Despacho)";
    }
}
