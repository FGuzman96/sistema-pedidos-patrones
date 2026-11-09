package com.uniquindio.pedidos.model;

/**
 * Modelo simple que representa un producto del catálogo.
 */
public class Producto {
    private String nombre;
    private double precio;
    private int stockDisponible;

    public Producto(String nombre, double precio, int stockDisponible) {
        this.nombre = nombre;
        this.precio = precio;
        this.stockDisponible = stockDisponible;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStockDisponible() {
        return stockDisponible;
    }

    public void reducirStock(int cantidad) {
        this.stockDisponible -= cantidad;
    }
}
