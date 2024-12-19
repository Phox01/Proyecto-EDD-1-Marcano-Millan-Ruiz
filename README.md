# Organized Chaos: Gestión de Almacenes con Grafos

## Descripción del Proyecto
**Organized Chaos** es un sistema diseñado para optimizar la logística de envíos en una red de almacenes interconectados, basado en la teoría de grafos. Este proyecto simula la gestión de inventarios y pedidos mediante algoritmos eficientes que determinan las rutas más cortas y aseguran un flujo adecuado de productos entre almacenes.

El sistema está orientado a empresas de gran escala, como Amazon, que necesitan soluciones robustas para manejar grandes volúmenes de pedidos y optimizar sus redes de distribución.

---

## Objetivos
1. Implementar un modelo de grafo para representar la red de almacenes y rutas.
2. Permitir la gestión de stock y pedidos, priorizando la eficiencia en el uso de recursos.
3. Desarrollar una interfaz gráfica amigable para visualizar y gestionar la red.
4. Ofrecer soporte para la carga y persistencia de datos mediante archivos de texto.
5. Asegurar un diseño basado en principios de Programación Orientada a Objetos (POO) y reutilización de código.

---

## Requerimientos Funcionales
1. **Cargar Archivo**
   - Permitir al usuario cargar un archivo de texto (`amazon.txt`) que contenga la configuración inicial de los almacenes, rutas y stock.
   - Mostrar advertencias al usuario si hay datos no guardados en memoria.

2. **Actualizar Repositorio**
   - Guardar los cambios realizados en memoria (almacenes, rutas y stock) en un archivo de texto plano.

3. **Reportes de Disponibilidad**
   - Realizar un recorrido BFS (anchura) y DFS (profundidad) del grafo, mostrando el stock de productos por almacén.
   - Imprimir los resultados en pantalla con el tipo de recorrido.

4. **Realizar Pedido**
   - Permitir al usuario seleccionar productos y cantidades desde un almacén inicial.
   - Si el almacén no tiene stock suficiente, solicitar los productos faltantes desde otro almacén.
   - Determinar la ruta más corta utilizando el algoritmo de Dijkstra.

5. **Solicitar Productos a Otro Almacén**
   - Identificar el almacén más cercano con suficiente stock y mostrar gráficamente la ruta más corta.
   - Imprimir la secuencia textual del camino seguido.

6. **Agregar un Nuevo Almacén**
   - Añadir nodos al grafo con al menos dos conexiones a otros nodos (arcos con pesos).

7. **Agregar un Nuevo Camino**
   - Crear nuevas aristas entre nodos existentes, especificando origen, destino y distancia.

8. **Gestión de Stock**
   - Añadir productos a un almacén y actualizar cantidades existentes.

9. **Mostrar Grafo**
   - Representar visualmente la red de almacenes y rutas disponibles.

---

## Requerimientos Técnicos
1. **Estructuras de Datos**
   - Implementar el grafo mediante matriz o lista de adyacencia, sin utilizar librerías externas para las estructuras básicas.
   - Soportar la representación gráfica del grafo mediante librerías especializadas.

2. **Interfaz Gráfica**
   - Crear una interfaz gráfica que permita cargar archivos, gestionar stock y visualizar el grafo.
   - Utilizar `JFileChooser` para la carga de datos.

3. **Persistencia**
   - Guardar y recuperar información en un archivo de texto.

4. **Documentación**
   - Incluir documentación del código utilizando Javadoc.
   - Proveer un diagrama de clases que explique la arquitectura del sistema.

5. **Control de Versiones**
   - Gestionar el proyecto en GitHub con registro de contribuciones del equipo.
