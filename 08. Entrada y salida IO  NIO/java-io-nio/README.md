
# IO / NIO

No confundir Streams de la API Stream con IO Streams de la API IO/NIO

Las operaciones de entrada y salida son muy comunes en cualquier aplicación.

## API `java.io`

Se introduce por primera vez en Java 1.0, actualmente consta de:

* `File`: representa un archivo/directorio y le permitió realizar algunas operaciones, como verificar si existe un archivo/directorio, obtener propiedades y eliminarlo.

* `InputStream` y `OutputStream`: clases abstractas para leer/escribir byte a byte. Los datos se almacenan en el sistema como 0 o 1, es decir, bit, estos se agrupan en conjuntos de 8 bits formando un byte.Se utilizan estos IO Streams para almacenar datos de forma binaria, como por ejemplo una imagen o un archivo ejecutable.
    * Clases concretas:
        * `FileInputStream`, `FileOutputStream`
        * `BufferedInputStream`, `BufferedOutputStream`

* `Reader` y `Writer`: clases abstractas para leer/escribir caracteres en vez de byte. Se
  utilizan estos Character Streams para almacenar archivos de texto.
    * Clases concretas:
        * `FileReader`, `FileWriter`
        * `BufferedReader`, `BufferedWriter`

Otra forma de entender esta API es con base en su nivel de abstracción:

* **Low-level**: conecta directamente con la fuente de datos, por ejemplo: ``FileInputStream``.

* **High-level**: se construye sobre otro IO Stream usando wrapping o un envoltorio. Por ejemplo: ``BufferedReader``.

## API `java.nio`

La API `java.nio` aparece para solucionar los problemas de La API `java.io` tiene algunos problemas:

* La clase `File` carece de algunas funciones importantes, como un método de copia.
* También definió muchos métodos que devolvían valores booleanos, que en caso
  de error, se devolvía falso, en lugar de lanzar una excepción lo que dificulta saber por qué falló.
* No proporcionó un buen manejo en el soporte de enlaces simbólicos.
* Se proporcionó un conjunto limitado de atributos de archivo.

Para solucionar estos problemas se introduce en Java 1.4 la API java New Input/Output (NIO) dentro del paquete `java.nio`:

* Channels y Selectors: un canal es una abstracción de las funciones del sistema de archivos de nivel inferior, por ejemplo archivos mapeados en memoria.
* Buffers: almacenamiento en búfer para todas las clases primitivas (excepto para Boolean).
* Charset: Charset (java.nio.charset), codificadores y decodificadores para mapear bytes y símbolos Unicode.

## API `java.nio` 2

En Java 1.7 se actualiza Java NIO introduciendo un nuevo paquete `java.nio.file` con el nombre de Java Non Blocking Input / Output (NIO.2). APIs clave que introduce:

* `Files`
* `Path`
* `Paths`
* `FileSystem`
* `FileSystems`
* `BasicFileAttributes`

