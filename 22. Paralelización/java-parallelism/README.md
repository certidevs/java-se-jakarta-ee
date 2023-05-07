
# Paralelización en Java

## Paralelización vs. concurrencia

Se debe tener en cuenta que la ejecución en **paralelo** es diferente de la ejecución **concurrente**:

- En la **ejecución en paralelo**,
	- es cuando las tareas se ejecutan literalmente al mismo tiempo, por ejemplo, en un procesador multinúcleo. Cada hilo se ejecuta en un core de procesamiento independiente. Por lo tanto, las tareas se ejecutan realmente de forma paralela no de forma secuencial.
	- el paralelismo es la ejecución simultánea de cálculos.
	- El paralelismo consiste en hacer muchas cosas a la vez

- En la **ejecución concurrente**:
	- es cuando dos o más tareas pueden comenzar, ejecutarse y completarse en períodos de tiempo superpuestos. No significa necesariamente que ambos se ejecutarán al mismo tiempo. Por ejemplo, multitarea en una máquina de un solo núcleo, significa que las tareas en realidad se ejecutan de forma intercalada, compartiendo el tiempo de procesamiento de un núcleo de procesamiento.
	- consiste en tratar con muchas cosas a la vez.


## Mecanismos de paralelización

* Framework Fork/Join (introducido en java 7)
* Streams paralelos (API Stream se introduce en java 8)


### Streams paralelos

Con los Stream paralelos, se puede dividir el código en múltiples streams que se ejecutan en paralelo en núcleos separados y el resultado final es la combinación de los resultados individuales.

El orden de ejecución no está bajo nuestro control, por lo tanto, es recomendable utilizar secuencias paralelas en los casos en que, independientemente del orden de ejecución, el resultado no se ve afectado y el estado de un elemento no afecta al otro, así como la fuente de los datos tampoco se ve afectada.

Se implementa por medio de:

* Método ``parallel()`` de un Stream.
* Método ``parallelStream()`` de una colección.


### Framework Fork/Join

El framework **Fork/Join** de Java es un conjunto de APIs que permite a los programadores aprovechar la ejecución paralela respaldada por procesadores multinúcleo.

* **Fork**: Utiliza la estrategia de "divide y vencerás": divide un problema muy grande en partes más pequeñas, que a su vez, la parte pequeña se puede dividir más en otras más pequeñas, recursivamente hasta que una parte se pueda resolver directamente. A esta parte se le llama "fork".

* **Join**: todas las partes obtenidas en la etapa fork se ejecutan en paralelo en múltiples núcleos de procesamiento. Los resultados de cada parte se "unen" para producir el resultado final. A esta parte se le llama "join". De ahí el nombre del framework "Fork/Join".

La API Fork/Join se implementa en el paquete ``java.util.concurrent``. En su core se encuentran las siguientes 4 clases:

* ``ForkJoinTask<V>``: una clase abstracta que define una tarea que se ejecuta dentro de un ``ForkJoinPool``.

* ``ForkJoinPool``: un grupo de hilos que gestiona la ejecución de ``ForkJoinTask``.

* ``RecursiveAction``: una subclase de ``ForkJoinTask`` para tareas que no devuelven valores.

* ``RecursiveTask<V>``: una subclase de ``ForkJoinTask`` para tareas que devuelven valores.

Básicamente, se debe implementar código para resolver problemas en una subclase de ``RecursiveAction`` o ``RecursiveTask``.

Luego se envía la tarea para que la ejecute ``ForkJoinPool``, que maneja todo, desde la gestión de hilos hasta la utilización del procesador multinúcleo.

Conclusión:

- El framework Fork/Join está diseñado para simplificar la programación paralela para los programadores de Java.

- ForkJoinPool es la parte central de Fork/Join. Permite que muchas ForkJoinTask sean ejecutadas por una pequeña cantidad de hilos, con cada hilo ejecutándose en un núcleo de procesamiento separado.

- Se puede obtener una instancia de ForkJoinPool utilizando su constructor o el método estático commonPool() que devuelve el pool de hilos.

- ForkJoinTask es una clase abstracta que representa una tarea que es más liviana que un hilo normal. Se debe implementar la lógica sobrescribiendo el método compute().

- RecursiveAction es una ForkJoinTask que no devuelve ningún resultado.

- RecursiveTask es una ForkJoinTask que devuelve un resultado.

- ForkJoinPool es diferente a otros pools, ya que utiliza un algoritmo "work-stealing" que permite que un hilo que se queda sin cosas para hacer, robe tareas de otros hilos que todavía están ocupados.

- Los subprocesos en ForkJoinPool son daemon. No es necesario que finalicemos con shutdown el pool.

- Se puede ejecutar una ForkJoinTask invocando sus propios métodos invoke() o fork(), o enviando la tarea a un ForkJoinPool y luego llamar a invoke() o execute() en el pool.

- Llamar a invoke() o fork() en una ForkJoinTask hará que la tarea se ejecute en el pool común, si aún no se está ejecutando en un ForkJoinPool.

- Se usa el método join() en ForkJoinTasks para combinar los resultados.

- El método invoke() espera la finalización de la tarea, pero el método de execute() no lo hace.