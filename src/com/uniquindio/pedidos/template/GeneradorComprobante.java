package com.uniquindio.pedidos.template;

import com.uniquindio.pedidos.model.Pedido;
import com.uniquindio.pedidos.model.Producto;

/**
 * PATRÓN: Template Method (Clase Plantilla Abstracta)
 * Define el esqueleto del algoritmo para emitir un comprobante de pago.
 */
public abstract class GeneradorComprobante {

    // Método Plantilla (final para que las subclases no alteren el esqueleto)
    public final void emitirComprobante(Pedido pedido) {
        imprimirEncabezado(pedido);
        imprimirDetalleProductos(pedido);
        imprimirImpuestosYRecargos(pedido);
        imprimirPieDePagina(pedido);
    }

    // Paso común 1
    protected void imprimirEncabezado(Pedido pedido) {
        System.out.println("\n==================================================");
        System.out.println("                 TIENDA UNIQUINDÍO                ");
        System.out.println("              COMPROBANTE DE COMPRA               ");
        System.out.println("==================================================");
        System.out.println("Pedido ID: #" + pedido.getId());
        System.out.println("Cliente  : " + pedido.getCliente());
        System.out.println("Dirección: " + pedido.getDireccion());
        System.out.println("Método de Envío: " + pedido.getEstrategiaEnvio().getNombreEstrategia());
        System.out.println("--------------------------------------------------");
    }

    // Paso común 2
    protected void imprimirDetalleProductos(Pedido pedido) {
        System.out.println("DETALLE DE PRODUCTOS:");
        for (Producto prod : pedido.getProductos()) {
            System.out.println(" - " + prod.getNombre() + " : $" + prod.getPrecio());
        }
        System.out.println("Subtotal: $" + pedido.calcularSubtotal());
        System.out.println("Costo Envío: $" + pedido.calcularCostoEnvio());
    }

    // Paso variable (implementado obligatoriamente por subclases)
    protected abstract void imprimirImpuestosYRecargos(Pedido pedido);

    // Paso común 3
    protected void imprimirPieDePagina(Pedido pedido) {
        System.out.println("--------------------------------------------------");
        System.out.println("VALOR TOTAL PAGADO: $" + pedido.calcularTotal());
        System.out.println("¡Gracias por confiar en nosotros!");
        System.out.println("==================================================\n");
    }
}
