package com.uniquindio.pedidos.template;

import com.uniquindio.pedidos.model.Pedido;

/**
 * PATRÓN: Template Method (Implementación Concreta 2: Boleta Simple / Ticket)
 * Para personas naturales, no discrimina impuestos detallados.
 */
public class BoletaSimple extends GeneradorComprobante {

    @Override
    protected void imprimirImpuestosYRecargos(Pedido pedido) {
        System.out.println("TIPO: Boleta de Venta / Consumidor Final");
        System.out.println("Impuestos: IVA incluido según régimen simplificado.");
    }
}
