package com.uniquindio.pedidos.strategy;

/**
 * PATRÓN: Strategy (Estrategia Concreta 1)
 * Envio estándar: tarifa fija accesible de $10.000 COP.
 */
public class EnvioEstandar implements EstrategiaEnvio {
    @Override
    public double calcularCosto(double subtotal) {
        return 10000.0;
    }

    @Override
    public String getNombreEstrategia() {
        return "Envío Estándar (3-5 días hábiles)";
    }
}
