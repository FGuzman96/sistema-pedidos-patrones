package com.uniquindio.pedidos.command;

import com.uniquindio.pedidos.model.Pedido;

/**
 * PATRÓN: Command (Comando Concreto: Despachar Pedido)
 * Ejecuta el despacho del pedido en el receptor.
 */
public class DespacharPedidoCommand implements Comando {
    private Pedido pedido;

    public DespacharPedidoCommand(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public void ejecutar() {
        System.out.println("[COMMAND: DespacharPedido]: Ejecutando orden de despacho para Pedido #" + pedido.getId());
        pedido.despachar();
    }

    @Override
    public String getDescripcion() {
        return "Despachar Pedido #" + pedido.getId();
    }
}
