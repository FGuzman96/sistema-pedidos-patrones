package com.uniquindio.pedidos.state;

import com.uniquindio.pedidos.model.Pedido;

/**
 * PATRÓN: State (Estado Concreto: Entregado - Estado Final)
 */
public class EstadoEntregado implements EstadoPedido {

    @Override
    public void pagar(Pedido pedido) {
        System.out.println("[State Entregado]: AVISO - El pedido ya fue pagado y completado.");
    }

    @Override
    public void despachar(Pedido pedido) {
        System.out.println("[State Entregado]: AVISO - El pedido ya fue entregado.");
    }

    @Override
    public void entregar(Pedido pedido) {
        System.out.println("[State Entregado]: AVISO - El pedido ya fue recibido a satisfacción.");
    }

    @Override
    public void cancelar(Pedido pedido) {
        System.out.println("[State Entregado]: ERROR - No se puede cancelar un pedido completado (debe tramitar devolución).");
    }

    @Override
    public String getNombreEstado() {
        return "ENTREGADO (Finalizado con Éxito)";
    }
}
