package com.uniquindio.pedidos.template;

import com.uniquindio.pedidos.model.Pedido;

/**
 * PATRÓN: Template Method (Implementación Concreta 1: Factura Electrónica)
 * Personaliza el paso de impuestos detallando el IVA (19%) y código de validación fiscal.
 */
public class FacturaElectronica extends GeneradorComprobante {

    @Override
    protected void imprimirImpuestosYRecargos(Pedido pedido) {
        double subtotal = pedido.calcularSubtotal();
        double iva = subtotal * 0.19;
        System.out.println("TIPO: Factura Electrónica con Validez Tributaria");
        System.out.println("IVA discriminado (19%): $" + iva);
        System.out.println("Código Fiscal CUFE: UQ-FE-2026-9874523-DIAN");
    }
}
