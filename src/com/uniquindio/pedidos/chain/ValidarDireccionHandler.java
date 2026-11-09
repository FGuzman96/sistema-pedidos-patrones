package com.uniquindio.pedidos.chain;

import com.uniquindio.pedidos.model.Pedido;

/**
 * PATRÓN: Chain of Responsibility (Eslabón 3: Dirección de Entrega)
 * Verifica que la dirección no esté vacía y tenga una longitud mínima válida.
 */
public class ValidarDireccionHandler extends ValidadorPedidoHandler {

    @Override
    public boolean validar(Pedido pedido) {
        System.out.println("[Chain: ValidadorDireccion]: Verificando dirección de entrega...");

        if (pedido.getDireccion() == null || pedido.getDireccion().trim().length() < 5) {
            System.out.println("[Chain: ValidadorDireccion]: RECHAZADO - Dirección inválida o incompleta.");
            return false;
        }

        System.out.println("[Chain: ValidadorDireccion]: APROBADO - Dirección válida (" + pedido.getDireccion() + ").");
        if (siguiente != null) {
            return siguiente.validar(pedido);
        }
        return true;
    }
}
