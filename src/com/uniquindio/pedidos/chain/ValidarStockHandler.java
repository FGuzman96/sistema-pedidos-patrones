package com.uniquindio.pedidos.chain;

import com.uniquindio.pedidos.model.Pedido;
import com.uniquindio.pedidos.model.Producto;

/**
 * PATRÓN: Chain of Responsibility (Eslabón 1: Validación de Stock)
 * Verifica que todos los productos del pedido tengan stock disponible en inventario.
 */
public class ValidarStockHandler extends ValidadorPedidoHandler {

    @Override
    public boolean validar(Pedido pedido) {
        System.out.println("[Chain: ValidadorStock]: Verificando disponibilidad de inventario...");

        if (pedido.getProductos().isEmpty()) {
            System.out.println("[Chain: ValidadorStock]: RECHAZADO - El pedido no tiene productos.");
            return false;
        }

        for (Producto prod : pedido.getProductos()) {
            if (prod.getStockDisponible() <= 0) {
                System.out.println("[Chain: ValidadorStock]: RECHAZADO - No hay stock para el producto: " + prod.getNombre());
                return false;
            }
        }

        System.out.println("[Chain: ValidadorStock]: APROBADO - Hay inventario disponible.");
        if (siguiente != null) {
            return siguiente.validar(pedido);
        }
        return true;
    }
}
