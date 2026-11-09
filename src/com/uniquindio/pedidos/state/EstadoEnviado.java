package com.uniquindio.pedidos.state;

import com.uniquindio.pedidos.model.Pedido;

/**
 * PATRÓN: State (Estado Concreto: Enviado)
 * El pedido está en ruta con la empresa de mensajería.
 */
public class EstadoEnviado implements EstadoPedido {

    @Override
    public void pagar(Pedido pedido) {
        System.out.println("[State Enviado]: AVISO - El pedido ya está pagado y en tránsito.");
    }

    @Override
    public void despachar(Pedido pedido) {
        System.out.println("[State Enviado]: AVISO - El pedido ya está en camino a su destino.");
    }

    @Override
    public void entregar(Pedido pedido) {
        System.out.println("[State Enviado]: Repartidor confirma entrega al cliente.");
        pedido.setEstado(new EstadoEntregado());
    }

    @Override
    public void cancelar(Pedido pedido) {
        System.out.println("[State Enviado]: ERROR - No se puede cancelar un pedido que ya está en camino al domicilio.");
    }

    @Override
    public String getNombreEstado() {
        return "ENVIADO (En Camino)";
    }
}
