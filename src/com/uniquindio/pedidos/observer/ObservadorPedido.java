package com.uniquindio.pedidos.observer;

import com.uniquindio.pedidos.model.Pedido;

/**
 * PATRÓN: Observer (Interfaz Observador)
 * Propósito: Define el método de actualización cuando el estado de un pedido cambia.
 */
public interface ObservadorPedido {
    void actualizar(Pedido pedido, String mensaje);
}
