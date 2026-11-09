package com.uniquindio.pedidos.mediator;

import com.uniquindio.pedidos.model.Pedido;
import com.uniquindio.pedidos.model.Producto;

/**
 * PATRÓN: Mediator (Colega Concreto: Bodega)
 */
public class BodegaDepartamento extends Departamento {

    public BodegaDepartamento(MediadorDespacho mediador) {
        super(mediador);
    }

    public void empaquetarPedido(Pedido pedido) {
        System.out.println("[BODEGA]: Empaquetando productos del Pedido #" + pedido.getId() + "...");
        for (Producto p : pedido.getProductos()) {
            p.reducirStock(1);
            System.out.println("  -> Producto empaquetado: " + p.getNombre() + " (Stock restante: " + p.getStockDisponible() + ")");
        }
        System.out.println("[BODEGA]: Pedido embalado con éxito. Notificando a la Central de Despacho...");
        mediador.notificar(this, "PEDIDO_EMPAQUETADO", pedido);
    }
}
