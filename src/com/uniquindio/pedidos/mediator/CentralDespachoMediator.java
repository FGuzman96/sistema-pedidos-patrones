package com.uniquindio.pedidos.mediator;

import com.uniquindio.pedidos.model.Pedido;

/**
 * PATRÓN: Mediator (Mediador Concreto)
 * Centraliza la comunicación evitando dependencias directas entre Bodega y Transporte.
 */
public class CentralDespachoMediator implements MediadorDespacho {
    private BodegaDepartamento bodega;
    private TransporteDepartamento transporte;

    public void setBodega(BodegaDepartamento bodega) {
        this.bodega = bodega;
    }

    public void setTransporte(TransporteDepartamento transporte) {
        this.transporte = transporte;
    }

    public void iniciarDespacho(Pedido pedido) {
        System.out.println("\n[MEDIADOR CENTRAL]: Iniciando proceso de despacho coordinado para Pedido #" + pedido.getId());
        if (bodega != null) {
            bodega.empaquetarPedido(pedido);
        }
    }

    @Override
    public void notificar(Departamento origen, String evento, Pedido pedido) {
        if (origen instanceof BodegaDepartamento && "PEDIDO_EMPAQUETADO".equals(evento)) {
            System.out.println("[MEDIADOR CENTRAL]: Bodega terminó de empacar. Coordinando con Transporte...");
            if (transporte != null) {
                transporte.programarEnvio(pedido);
            }
        } else if (origen instanceof TransporteDepartamento && "RUTA_ASIGNADA".equals(evento)) {
            System.out.println("[MEDIADOR CENTRAL]: Transporte listo con guía. Transicionando estado del pedido...");
            pedido.despachar();
        }
    }
}
