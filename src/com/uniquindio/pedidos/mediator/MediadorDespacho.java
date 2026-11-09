package com.uniquindio.pedidos.mediator;

import com.uniquindio.pedidos.model.Pedido;

/**
 * PATRÓN: Mediator (Interfaz Mediador)
 * Desacopla la comunicación entre los diferentes departamentos (Bodega, Transporte, Facturación).
 */
public interface MediadorDespacho {
    void notificar(Departamento origen, String evento, Pedido pedido);
}
