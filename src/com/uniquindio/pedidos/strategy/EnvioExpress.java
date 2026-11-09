package com.uniquindio.pedidos.strategy;

/**
 * PATRÓN: Strategy (Estrategia Concreta 2)
 * Envío express: entrega rápida calculando tarifa base + 10% del subtotal.
 */
public class EnvioExpress implements EstrategiaEnvio {
    @Override
    public double calcularCosto(double subtotal) {
        return 20000.0 + (subtotal * 0.10);
    }

    @Override
    public String getNombreEstrategia() {
        return "Envío Express Prioritario (24 horas)";
    }
}
