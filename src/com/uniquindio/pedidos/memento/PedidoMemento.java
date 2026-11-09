package com.uniquindio.pedidos.memento;

import com.uniquindio.pedidos.state.EstadoPedido;
import com.uniquindio.pedidos.strategy.EstrategiaEnvio;

/**
 * PATRÓN: Memento
 * Guarda una instantánea del estado del pedido en un momento específico del tiempo.
 */
public class PedidoMemento {
    private final String direccion;
    private final EstrategiaEnvio estrategiaEnvio;
    private final EstadoPedido estado;
    private final String timestamp;

    public PedidoMemento(String direccion, EstrategiaEnvio estrategiaEnvio, EstadoPedido estado, String timestamp) {
        this.direccion = direccion;
        this.estrategiaEnvio = estrategiaEnvio;
        this.estado = estado;
        this.timestamp = timestamp;
    }

    public String getDireccion() {
        return direccion;
    }

    public EstrategiaEnvio getEstrategiaEnvio() {
        return estrategiaEnvio;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
