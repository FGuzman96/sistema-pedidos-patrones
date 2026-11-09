package com.uniquindio.pedidos.command;

import java.util.ArrayList;
import java.util.List;

/**
 * PATRÓN: Command (Invocador / Invoker)
 * Recibe, ejecuta y registra en una bitácora los comandos solicitados.
 */
public class InvocadorComandos {
    private final List<Comando> historialComandos = new ArrayList<>();

    public void ejecutarComando(Comando comando) {
        System.out.println("[INVOCADOR]: Solicitud recibida -> " + comando.getDescripcion());
        comando.ejecutar();
        historialComandos.add(comando);
    }

    public void mostrarHistorial() {
        System.out.println("\n--- BITÁCORA DE COMANDOS EJECUTADOS ---");
        for (int i = 0; i < historialComandos.size(); i++) {
            System.out.println((i + 1) + ". " + historialComandos.get(i).getDescripcion());
        }
        System.out.println("--------------------------------------\n");
    }
}
