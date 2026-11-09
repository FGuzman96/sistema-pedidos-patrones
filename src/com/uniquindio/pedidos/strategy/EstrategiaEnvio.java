package com.uniquindio.pedidos.strategy;

/**
 * PATRÓN: Strategy (Interfaz Estrategia)
 * Propósito: Define el contrato para calcular el costo de envío según diferentes políticas.
 */
public interface EstrategiaEnvio {
    double calcularCosto(double subtotal);
    String getNombreEstrategia();
}
