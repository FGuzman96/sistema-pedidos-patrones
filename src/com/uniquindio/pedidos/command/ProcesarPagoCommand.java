package com.uniquindio.pedidos.command;

import com.uniquindio.pedidos.model.Pedido;

/**
 * PATRÓN: Command (Comando Concreto: Procesar Pago)
 * Ejecuta el pago sobre el pedido receptor.
 */
public class ProcesarPagoCommand implements Comando {
    private Pedido pedido;

    public ProcesarPagoCommand(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public void ejecutar() {
        System.out.println("[COMMAND: ProcesarPago]: Ejecutando cobro por un valor total de $" + pedido.calcularTotal());
        pedido.pagar();
    }

    @Override
    public String getDescripcion() {
        return "Procesar Pago del Pedido #" + pedido.getId();
    }
}
