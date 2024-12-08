# Proyecto Universitario: Análisis de un Dataset de IMDB

Este repositorio contiene un proyecto desarrollado como parte de un trabajo práctico universitario. El objetivo principal es cargar un dataset de IMDB en memoria, representando cada registro como un objeto, y realizar un procesamiento básico para visualizar los datos mediante un diagrama de barras o un histograma.

## Descripción del Proyecto

El programa realiza las siguientes tareas principales:

1. **Diseño de Clases**:
   - Se crea una clase `Title` que representa un registro del dataset.
   - Cada atributo de la clase (`title`, `year`, `duration`) corresponde a una columna del dataset.
   - Se implementan métodos como constructores, getters, setters y `toString()`.

2. **Carga del Dataset**:
   - Se lee un archivo TSV que contiene los datos del dataset.
   - Para cada registro del archivo, se crea un objeto de la clase `Title` con los valores correspondientes.

3. **Procesamiento de Datos**:
   - Se analiza un atributo del dataset (en este caso, la duración de los títulos) para agruparlos en rangos predefinidos.
   - Se almacena la información procesada en un `HashMap` que asocia cada rango con su frecuencia.

4. **Visualización**:
   - Se genera un histograma simple en la consola que muestra la distribución de los títulos según su duración.

## Archivos Principales

- **`Main.java`**:
  - Contiene la lógica principal para cargar el dataset, procesar los datos y mostrar el resultado.
- **`Title.java`**:
  - Define la clase que representa un título del dataset con sus atributos y métodos asociados.

## Ejemplo de Uso

El programa procesa un archivo llamado `title.basics.tsv` ubicado en el directorio especificado. Los resultados se agrupan en rangos de duración y se imprimen en la consola en el siguiente formato:

91-120 -> 242289
121-150 -> 60651
+150 -> 54921
61-90 -> 330828
0-30 -> 9630674
31-60 -> 971301
