package com.uniquindio.pedidos.state;

import com.uniquindio.pedidos.model.Pedido;

/**
 * PATRÓN: State (Interfaz Estado)
 * Define las acciones que dependen del estado actual del pedido en su ciclo de vida.
 */
public interface EstadoPedido {
    void pagar(Pedido pedido);
    void despachar(Pedido pedido);
    void entregar(Pedido pedido);
    void cancelar(Pedido pedido);
    String getNombreEstado();
}
