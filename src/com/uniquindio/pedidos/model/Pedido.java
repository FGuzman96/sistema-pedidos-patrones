package com.uniquindio.pedidos.model;

import com.uniquindio.pedidos.memento.PedidoMemento;
import com.uniquindio.pedidos.observer.ObservadorPedido;
import com.uniquindio.pedidos.state.EstadoPedido;
import com.uniquindio.pedidos.strategy.EstrategiaEnvio;

import java.util.ArrayList;
import java.util.List;

/**
 * Entidad central del sistema.
 * Conecta e interactúa de forma directa con State, Strategy, Observer y Memento.
 */
public class Pedido {
    private int id;
    private String cliente;
    private String direccion;
    private List<Producto> productos;
    private EstadoPedido estado;
    private EstrategiaEnvio estrategiaEnvio;
    private List<ObservadorPedido> observadores;

    public Pedido(int id, String cliente, String direccion, EstrategiaEnvio estrategiaEnvio) {
        this.id = id;
        this.cliente = cliente;
        this.direccion = direccion;
        this.estrategiaEnvio = estrategiaEnvio;
        this.productos = new ArrayList<>();
        this.observadores = new ArrayList<>();
        // El estado inicial se asigna externamente o en el arranque (EstadoPendiente)
    }

    public void agregarProducto(Producto p) {
        this.productos.add(p);
    }

    public double calcularSubtotal() {
        double subtotal = 0;
        for (Producto p : productos) {
            subtotal += p.getPrecio();
        }
        return subtotal;
    }

    public double calcularCostoEnvio() {
        if (estrategiaEnvio == null) {
            return 0.0;
        }
        return estrategiaEnvio.calcularCosto(calcularSubtotal());
    }

    public double calcularTotal() {
        return calcularSubtotal() + calcularCostoEnvio();
    }

    // --- MÉTODOS DEL PATRÓN OBSERVER ---
    public void suscribir(ObservadorPedido obs) {
        observadores.add(obs);
    }

    public void notificarObservadores(String evento) {
        for (ObservadorPedido obs : observadores) {
            obs.actualizar(this, evento);
        }
    }

    // --- MÉTODOS DEL PATRÓN STATE ---
    public void setEstado(EstadoPedido nuevoEstado) {
        this.estado = nuevoEstado;
        System.out.println("-> [ESTADO]: El pedido #" + id + " ahora está en estado: " + nuevoEstado.getNombreEstado());
        notificarObservadores("Cambio de estado a " + nuevoEstado.getNombreEstado());
    }

    public void pagar() {
        if (estado != null) {
            estado.pagar(this);
        }
    }

    public void despachar() {
        if (estado != null) {
            estado.despachar(this);
        }
    }

    public void entregar() {
        if (estado != null) {
            estado.entregar(this);
        }
    }

    public void cancelar() {
        if (estado != null) {
            estado.cancelar(this);
        }
    }

    // --- MÉTODOS DEL PATRÓN MEMENTO ---
    public PedidoMemento crearMemento(String descripcion) {
        return new PedidoMemento(this.direccion, this.estrategiaEnvio, this.estado, descripcion);
    }

    public void restaurar(PedidoMemento memento) {
        if (memento != null) {
            this.direccion = memento.getDireccion();
            this.estrategiaEnvio = memento.getEstrategiaEnvio();
            this.estado = memento.getEstado();
            System.out.println("-> [ESTADO RESTAURADO]: Dirección = " + this.direccion 
                    + ", Estrategia = " + this.estrategiaEnvio.getNombreEstrategia() 
                    + ", Estado = " + this.estado.getNombreEstado());
            notificarObservadores("Pedido restaurado desde punto de control (" + memento.getTimestamp() + ")");
        }
    }

    // --- GETTERS Y SETTERS ---
    public int getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public EstrategiaEnvio getEstrategiaEnvio() {
        return estrategiaEnvio;
    }

    public void setEstrategiaEnvio(EstrategiaEnvio estrategiaEnvio) {
        this.estrategiaEnvio = estrategiaEnvio;
    }
}
