package com.uniquindio.pedidos.chain;

import com.uniquindio.pedidos.model.Pedido;

/**
 * PATRÓN: Chain of Responsibility (Eslabón 2: Monto Mínimo)
 * Verifica que el subtotal del pedido supere el valor mínimo de compra ($20.000 COP).
 */
public class ValidarMontoMinimoHandler extends ValidadorPedidoHandler {
    private final double MONTO_MINIMO = 20000.0;

    @Override
    public boolean validar(Pedido pedido) {
        System.out.println("[Chain: ValidadorMonto]: Verificando monto mínimo de compra ($" + MONTO_MINIMO + ")...");

        if (pedido.calcularSubtotal() < MONTO_MINIMO) {
            System.out.println("[Chain: ValidadorMonto]: RECHAZADO - Subtotal ($" + pedido.calcularSubtotal() 
                    + ") no alcanza el monto mínimo.");
            return false;
        }

        System.out.println("[Chain: ValidadorMonto]: APROBADO - Monto mínimo superado.");
        if (siguiente != null) {
            return siguiente.validar(pedido);
        }
        return true;
    }
}
