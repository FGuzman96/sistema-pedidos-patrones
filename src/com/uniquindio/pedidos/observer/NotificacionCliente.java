package com.uniquindio.pedidos.observer;

import com.uniquindio.pedidos.model.Pedido;

/**
 * PATRÓN: Observer (Observador Concreto 1)
 * Simula el envío de correos o SMS de actualización al cliente.
 */
public class NotificacionCliente implements ObservadorPedido {
    private String nombreCliente;

    public NotificacionCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    @Override
    public void actualizar(Pedido pedido, String mensaje) {
        System.out.println("[NOTIFICACIÓN SMS/CORREO al Cliente " + nombreCliente + "]: " 
                + "Pedido #" + pedido.getId() + " -> " + mensaje);
    }
}
