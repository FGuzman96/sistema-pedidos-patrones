package com.uniquindio.pedidos.command;

/**
 * PATRÓN: Command (Interfaz Comando)
 * Encapsula una acción sobre el sistema en un objeto ejecutable.
 */
public interface Comando {
    void ejecutar();
    String getDescripcion();
}
