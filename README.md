# Sistema de Gestión y Despacho de Pedidos

Proyecto en Java que implementa la integración de patrones de diseño comportamentales (GoF) en un flujo unificado de gestión de pedidos.

---

## Cómo ejecutar el proyecto

### Opción 1: Desde IntelliJ IDEA (Recomendado)
1. Abre IntelliJ IDEA.
2. Selecciona **Open** (Abrir) y elige la carpeta del proyecto:
   ```text
   sistema-pedidos-patrones
   ```
3. Asegúrate de tener configurado un SDK de Java (JDK 17 o superior).
4. En el explorador de archivos del proyecto, navega a:
   ```text
   src/com/uniquindio/pedidos/Main.java
   ```
5. Haz clic derecho sobre el archivo `Main.java` y selecciona **Run 'Main.main()'**.

---

### Opción 2: Desde la consola (Terminal / PowerShell / CMD)
Abre la terminal en la raíz del proyecto y ejecuta los siguientes comandos:

```bash
# Compilar el proyecto en la carpeta bin
javac -d bin src/com/uniquindio/pedidos/model/*.java src/com/uniquindio/pedidos/strategy/*.java src/com/uniquindio/pedidos/state/*.java src/com/uniquindio/pedidos/observer/*.java src/com/uniquindio/pedidos/command/*.java src/com/uniquindio/pedidos/chain/*.java src/com/uniquindio/pedidos/mediator/*.java src/com/uniquindio/pedidos/template/*.java src/com/uniquindio/pedidos/memento/*.java src/com/uniquindio/pedidos/Main.java

# Ejecutar el programa
java -cp bin com.uniquindio.pedidos.Main
```
