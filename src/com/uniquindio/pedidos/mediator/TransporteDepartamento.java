package com.uniquindio.pedidos.mediator;

import com.uniquindio.pedidos.model.Pedido;

/**
 * PATRÓN: Mediator (Colega Concreto: Transporte)
 */
public class TransporteDepartamento extends Departamento {

    public TransporteDepartamento(MediadorDespacho mediador) {
        super(mediador);
    }

    public void programarEnvio(Pedido pedido) {
        System.out.println("[TRANSPORTE]: Asignando vehículo y ruta hacia " + pedido.getDireccion() 
                + " mediante " + pedido.getEstrategiaEnvio().getNombreEstrategia() + ".");
        System.out.println("[TRANSPORTE]: Guía de despacho generada. Notificando a la Central de Despacho...");
        mediador.notificar(this, "RUTA_ASIGNADA", pedido);
    }
}
