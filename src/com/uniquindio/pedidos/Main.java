package com.uniquindio.pedidos;

import com.uniquindio.pedidos.chain.*;
import com.uniquindio.pedidos.command.*;
import com.uniquindio.pedidos.mediator.*;
import com.uniquindio.pedidos.memento.*;
import com.uniquindio.pedidos.model.*;
import com.uniquindio.pedidos.observer.*;
import com.uniquindio.pedidos.state.*;
import com.uniquindio.pedidos.strategy.*;
import com.uniquindio.pedidos.template.*;

/**
 * CLASE PRINCIPAL: Simulación de principio a fin del flujo de negocio
 * Demuestra la interconexión cohesiva de los 8 patrones comportamentales.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("======================================================================");
        System.out.println("  SISTEMA INTEGRADO DE GESTIÓN Y DESPACHO DE PEDIDOS ONLINE (UNIQUINDÍO) ");
        System.out.println("======================================================================\n");

        // --------------------------------------------------------------------
        // PASO 1: CREACIÓN DEL PEDIDO Y SELECCIÓN DE ESTRATEGIA (PATRÓN STRATEGY)
        // --------------------------------------------------------------------
        System.out.println(">>> [1. PATRÓN STRATEGY] Configurando el tipo de envío...");
        EstrategiaEnvio envioEstandar = new EnvioEstandar();
        EstrategiaEnvio envioExpress = new EnvioExpress();

        Pedido pedido = new Pedido(101, "Carlos Faber", "Calle 14 # 23-45, Armenia", envioExpress);
        pedido.agregarProducto(new Producto("Laptop Gamer Asus", 3500000.0, 5));
        pedido.agregarProducto(new Producto("Mouse Inalámbrico Logitech", 85000.0, 12));

        System.out.println("Subtotal de productos: $" + pedido.calcularSubtotal());
        System.out.println("Estrategia elegida: " + pedido.getEstrategiaEnvio().getNombreEstrategia());
        System.out.println("Costo de envío calculado: $" + pedido.calcularCostoEnvio());
        System.out.println("Total con envío: $" + pedido.calcularTotal());
        System.out.println();

        // --------------------------------------------------------------------
        // PASO 2: SUSCRIPCIÓN DE OBSERVADORES (PATRÓN OBSERVER)
        // --------------------------------------------------------------------
        System.out.println(">>> [2. PATRÓN OBSERVER] Registrando canales de notificación...");
        ObservadorPedido obsCliente = new NotificacionCliente("Carlos Faber");
        ObservadorPedido obsLogistica = new NotificacionLogistica();

        pedido.suscribir(obsCliente);
        pedido.suscribir(obsLogistica);
        System.out.println("Observadores suscritos correctamente.\n");

        // --------------------------------------------------------------------
        // PASO 3: ESTADO INICIAL (PATRÓN STATE)
        // --------------------------------------------------------------------
        System.out.println(">>> [3. PATRÓN STATE] Asignando estado inicial al pedido...");
        pedido.setEstado(new EstadoPendiente());
        System.out.println();

        // --------------------------------------------------------------------
        // PASO 4: CAPTURA DE HISTORIAL Y DESHACER (PATRÓN MEMENTO)
        // --------------------------------------------------------------------
        System.out.println(">>> [4. PATRÓN MEMENTO] Demostración de guardado y restauración de estado...");
        HistorialCareTaker historial = new HistorialCareTaker();

        // Guardamos punto de restauración
        historial.guardarMemento(pedido.crearMemento("Configuración inicial con Envio Express"));

        // Simulamos un cambio accidental del usuario
        System.out.println("-> Simulando cambio accidental: Dirección cambiada y envío cambiado a Estándar...");
        pedido.setDireccion("Avenida Bolívar # 10 Norte");
        pedido.setEstrategiaEnvio(envioEstandar);
        System.out.println("   Dirección actual temporal: " + pedido.getDireccion());
        System.out.println("   Estrategia actual temporal: " + pedido.getEstrategiaEnvio().getNombreEstrategia());

        // El usuario cancela la edición y se restaura el memento
        PedidoMemento snapshot = historial.deshacer();
        pedido.restaurar(snapshot);
        System.out.println();

        // --------------------------------------------------------------------
        // PASO 5: VALIDACIÓN EN SERIE DEL PEDIDO (PATRÓN CHAIN OF RESPONSIBILITY)
        // --------------------------------------------------------------------
        System.out.println(">>> [5. PATRÓN CHAIN OF RESPONSIBILITY] Validando reglas de negocio...");
        ValidadorPedidoHandler validadorStock = new ValidarStockHandler();
        ValidadorPedidoHandler validadorMonto = new ValidarMontoMinimoHandler();
        ValidadorPedidoHandler validadorDireccion = new ValidarDireccionHandler();

        // Ensamblado de la cadena
        validadorStock.setSiguiente(validadorMonto);
        validadorMonto.setSiguiente(validadorDireccion);

        boolean esValido = validadorStock.validar(pedido);
        if (!esValido) {
            System.out.println("Validación fallida. Se cancela el procesamiento.");
            return;
        }
        System.out.println("Todas las validaciones fueron aprobadas exitosamente.\n");

        // --------------------------------------------------------------------
        // PASO 6: EJECUCIÓN DE COMANDOS DESACOPLADOS (PATRÓN COMMAND)
        // --------------------------------------------------------------------
        System.out.println(">>> [6. PATRÓN COMMAND] Invocando procesamiento de pago a través de un comando...");
        InvocadorComandos invocador = new InvocadorComandos();
        Comando comandoPagar = new ProcesarPagoCommand(pedido);

        // El invocador ejecuta y registra en bitácora
        invocador.ejecutarComando(comandoPagar);
        System.out.println();

        // --------------------------------------------------------------------
        // PASO 7: GENERACIÓN DEL COMPROBANTE FISCAL (PATRÓN TEMPLATE METHOD)
        // --------------------------------------------------------------------
        System.out.println(">>> [7. PATRÓN TEMPLATE METHOD] Emitiendo comprobante fiscal con algoritmo plantilla...");
        GeneradorComprobante generador = new FacturaElectronica();
        generador.emitirComprobante(pedido);

        // --------------------------------------------------------------------
        // PASO 8: COORDINACIÓN DE DESPACHO INTERNO (PATRÓN MEDIATOR)
        // --------------------------------------------------------------------
        System.out.println(">>> [8. PATRÓN MEDIATOR] Coordinando despacho entre departamentos...");
        CentralDespachoMediator mediador = new CentralDespachoMediator();
        BodegaDepartamento bodega = new BodegaDepartamento(mediador);
        TransporteDepartamento transporte = new TransporteDepartamento(mediador);

        mediador.setBodega(bodega);
        mediador.setTransporte(transporte);

        // El mediador inicia el flujo coordinado: Bodega empaca -> Notifica mediador -> Transporte asigna -> Notifica mediador -> Pasa a Enviado
        mediador.iniciarDespacho(pedido);
        System.out.println();

        // --------------------------------------------------------------------
        // FINALIZACIÓN: ENTREGA FINAL DEL PRODUCTO
        // --------------------------------------------------------------------
        System.out.println(">>> [FINAL] El transportador arriba a la dirección y entrega el paquete:");
        pedido.entregar();
        System.out.println();

        // Mostramos el registro histórico de comandos
        invocador.mostrarHistorial();

        System.out.println("======================================================================");
        System.out.println("  ¡FLUJO COMPLETADO CON ÉXITO CUBRIENDO LOS 8 PATRONES COMPORTAMENTALES! ");
        System.out.println("======================================================================");
    }
}
