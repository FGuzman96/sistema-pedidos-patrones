package com.uniquindio.pedidos.memento;

import java.util.Stack;

/**
 * PATRÓN: Memento (CareTaker / Guardián)
 * Almacena y administra el historial de mementos (pila para deshacer cambios).
 */
public class HistorialCareTaker {
    private final Stack<PedidoMemento> historial = new Stack<>();

    public void guardarMemento(PedidoMemento memento) {
        historial.push(memento);
        System.out.println("[MEMENTO]: Punto de restauración guardado (" + memento.getTimestamp() + ").");
    }

    public PedidoMemento deshacer() {
        if (!historial.isEmpty()) {
            PedidoMemento memento = historial.pop();
            System.out.println("[MEMENTO]: Restaurando pedido al estado previo guardado (" + memento.getTimestamp() + ")...");
            return memento;
        }
        System.out.println("[MEMENTO]: No hay puntos de restauración previos.");
        return null;
    }
}
