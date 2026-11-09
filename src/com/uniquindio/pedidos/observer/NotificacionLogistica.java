package com.uniquindio.pedidos.observer;

import com.uniquindio.pedidos.model.Pedido;

/**
 * PATRÓN: Observer (Observador Concreto 2)
 * Notifica al equipo de operaciones y logística interna para coordinar empaque y rutas.
 */
public class NotificacionLogistica implements ObservadorPedido {
    @Override
    public void actualizar(Pedido pedido, String mensaje) {
        System.out.println("[NOTIFICACIÓN DASHBOARD LOGÍSTICA]: Pedido #" + pedido.getId() 
                + " actualizado. Evento: " + mensaje);
    }
}
