
# Concurrencia en Java


Un hilo (Thread) es la unidad de ejecución más pequeña que puede programar el sistema operativo.

Un proceso es un grupo de hilos asociados que se ejecutan en el mismo entorno compartido (shared
environment).

Un proceso single-threaded es aquel proceso que contiene exactamente un hilo.

Un proceso multi-threaded es aquel proceso admite más de un hilo.

Entorno compartido significa que los hilos en el mismo proceso comparten el mismo
espacio de memoria y pueden comunicarse directamente entre sí.  Por ejemplo: variables static, variables de instancia y locales pasadas a un hilo.

Una tarea (Task) es una sola unidad de trabajo realizada por un hilo.

Un hilo puede completar varias tareas independientes, pero solo una tarea a la vez.

La propiedad de ejecutar múltiples hilos y procesos al mismo tiempo se conoce como concurrencia.

¿Cómo decide el sistema qué ejecutar cuando hay más hilos disponibles que CPU?

Los sistemas operativos utilizan un programador de hilos (Thread scheduler) para determinar qué hilos se deben ejecutar actualmente.

Por ejemplo, un thread scheduler puede emplear un programa round-robin en el que cada hilo disponible recibe el mismo número de ciclos de CPU para ejecutarse, con hilos visitados en orden circular.

Cuando se completa el tiempo asignado de un hilo, pero el hilo no ha terminado de procesarse, se produce un cambio de contexto.

Un cambio de contexto es el proceso de almacenar el estado actual de un hilo y luego restaurar el estado del hilo para continuar la ejecución.

El cambio de contexto tiene asociado un coste debido a la pérdida de tiempo y la necesidad de recargar el estado de un hilo.

Se debe minimizar la cantidad de cambios de contexto mientras mantienen una aplicación funcionando sin problemas.

Un hilo puede interrumpir o reemplazar a otro hilo si tiene una prioridad de hilo más alta que el otro hilo.

Una prioridad de hilo es un valor numérico asociado con un hilo que el planificador de hilos (Thread scheduler) tiene en cuenta al determinar qué hilos deben ejecutarse actualmente. En Java, las prioridades de hilos se especifican como valores enteros.

## Tipos de hilos

* Hilos de sistema: La máquina virtual de Java (JVM) crea un hilo y se ejecuta en segundo plano de la aplicación. Por ejemplo, el recolector de basura (garbage collector) es administrada por un hilo del sistema creado por la JVM. Por defecto son hilos daemon, es decir, que si no hay nada más pendiente de ejecución entonces el programa se cierra una vez se terminen.

* Hilos definidos por el usuario: es uno creado por el desarrollador de la aplicación para realizar una tarea específica. No son hilos daemon, por tanto el programa espera a que terminen su trabajo. Se puede convertir en hilos daemon con el método ``.setDaemon(true)``.


## Ciclo de vida de los hilos


Un hilo puede pasar por varios estados durante su ciclo de vida. El método ``getState()`` de Thread devuelve una constante de enumeración que indica el estado actual del hilo, que cae en uno de los siguientes valores:

* **NEW**
- **RUNNABLE**
- **BLOCKED**
- **WAITING**
- **TIMED_WAITING**
- **TERMINATED**

Estas constantes de enumeración se definen en la enumeración ``Thread.State`` y significan lo siguiente:

* NEW: cuando se crea un hilo pero no se ha ejecutado (no se ha invocado el método ``start()``), está en este estado.


* RUNNABLE: cuando se ha invocado el método ``start()``, el hilo entra en el estado ejecutable y su método ``run()`` se está ejecutando. se debe tener en cuenta que el hilo puede volver al estado ejecutable desde otro estado (en espera, bloqueado), pero es posible que el scheduler de hilos no lo seleccione de inmediato, de ahí el término "ejecutable", no en ejecución.


* BLOCKED: cuando un hilo intenta adquirir un bloqueo intrínseco (no un bloqueo en el paquete java.util.concurrent) que actualmente está en manos de otro hilo, se bloquea. Cuando todos los demás hilos han renunciado al bloqueo y el planificador de hilos ha permitido que este hilo mantenga el bloqueo, el hilo se desbloquea y entra en el estado ejecutable.


* WAITING: un hilo entra en este estado si espera a que otro hilo le notifique, lo cual es el resultado de llamar a Object.wait() o Thread.join(). El hilo también entra en estado de espera si espera un Bloqueo o una Condición en el paquete java.util.concurrent. Cuando otro hilo llama al método notify()/notifyAll() de Object o a signal()/signalAll() de Condition, el hilo vuelve al estado ejecutable.


* TIMED_WAITING: un hilo entra en este estado si se llama a un método con parámetro de tiempo de espera: sleep(), wait(), join(), Lock.tryLock() y Condition.await(). El hilo sale de este estado si se agota el tiempo de espera o si se ha recibido la notificación adecuada.


* TERMINATED: un hilo entra en estado terminado cuando ha completado la ejecución. El subproceso termina por una de dos razones:

    + el método run() sale termina exitosamente.
    + el método run() sale termina de forma abrupta debido a que ocurre una excepción no detectada.


## Polling

Aunque la programación de multihilo permite ejecutar varias tareas al mismo tiempo, es común que un hilo necesite esperar a obtener los resultados de otro hilo.

Una solución es utilizar el polling, es el proceso de verificar datos de forma intermitente en un intervalo fijo.

Métodos para pausar, parar, esperar:

* ``sleep()``
* ``interrupt()``
* ``isAlive()``
* ``getState()``
* ``join()``

## API Concurrency

``java.util.concurrent``

Al escribir programas de hilos múltiples en la práctica, es mejor usar la API de concurrencia en lugar de trabajar con objetos de hilos directamente.

La interfaz Callable a menudo es preferible a Runnable, ya que permite recuperar fácilmente más detalles de la tarea una vez que se completa.


### Pool de hilos

Un pool de hilos es un grupo de hilos reutilizables instanciados previamente que están disponibles para realizar un conjunto de tareas arbitrarias.

1. Se puede crear un **executor de un solo hilo**:

``ExecutorService executor = Executors.newSingleThreadExecutor();``

Los resultados se procesan secuencialmente en el orden en que se envían.

2. Se puede crear un **executor de un pool de hilos**:

``ExecutorService executor = Executors.newFixedThreadPool(10);``

Los resultados se procesan paralelamente siempre que el executor no tenga todos los hilos ocupados.


## Sincronización
### volatile

La palabra clave ``volatile`` se usa para garantizar que el acceso a los datos dentro de la memoria sea consistente.

Un atributo con el modificador ``volatile`` garantiza que solo un hilo esté modificando esa variable a la vez y que los datos leídos entre varios hilos sean coherentes.

En la práctica, rara vez se usa ``volatile``.

Puede dar problemas ya que dependiendo de cómo se accede o modifica una variable entonces será thread-safe o no, por ejemplo:

``private volatile int age = 0;``

El siguiente código es thread-safe:

``age = age + 1;``

Pero el siguiente código no es thread-safe debido a que el operador de incremento ++ no es thread-safe para hilos, incluso cuando se usa ``volatile``. Esto se produce porque la operación ++ no es atómica, realizando dos tareas, lectura y escritura, que pueden ser interrumpidas por otros subprocesos.

``++age;``

### Operaciones atómicas

**Atomicidad** es la propiedad de una operación para llevarse a cabo como una sola unidad de ejecución sin ninguna interferencia de otro hilo.

Una versión atómica segura para hilos del operador de incremento realizaría la lectura y escritura de la variable como una sola operación, sin permitir que ningún otro subproceso acceda a la variable durante la operación.

El paquete ``java.util.concurrent.atomic`` contiene clases atómicas para distintos tipos de datos, por ejemplo:

* ``AtomicBoolean``
* ``AtomicInteger``
* ``AtomicLong``

Estas clases contienen métodos especiales que se comportan como una sola unidad de trabajo, por ejemplo: ``incrementAndGet()``.

Si bien las clases atómicas ayudan a proteger una sola variable, no son útiles si se necesita ejecutar una serie de comandos o llamar a un método. No podemos usarlas para actualizar dos variables atómicas al mismo tiempo.


### synchronized

La técnica más común para sincronizar el acceso es usar un monitor. Un monitor, también llamado **bloqueo** o **lock**, es una estructura que admite la exclusión mutua, que es la propiedad de que, como máximo, un hilo está ejecutando un segmento particular de código en un momento dado.

En Java, cualquier objeto se puede usar como monitor, junto con la palabra clave ``synchronized``.

La palabra ``synchronized`` puede ser aplicada también a un bloque entero de código.

Cada hilo que llega primero verificará si algún otro hilo ya está ejecutando el bloque.

Si el bloqueo no está disponible, el hilo pasará a un estado BLOCKED hasta que pueda "adquirir el bloqueo".

Si el bloqueo está disponible (o el hilo ya tiene el bloqueo), el único hilo ingresará al bloque, evitando que todos los demás hilos accedan. Una vez que el hilo termina de ejecutar el bloque, liberará el bloqueo, permitiendo que uno de los hilos en espera continúe.

Para sincronizar el acceso a través de varios hilos, cada hilo debe tener acceso al mismo objeto. Si cada hilo se sincroniza en diferentes objetos, el código no es seguro para hilos (thread-safe).

``synchronized`` también puede ser aplicado a métodos.

Un bloque ``synchronized`` solo admite un conjunto limitado de funciones. Por ejemplo, ¿Qué pasa si queremos comprobar si hay un bloqueo disponible y, en caso contrario, realizar alguna otra tarea?

Además, si el bloqueo nunca está disponible y lo sincronizamos, podríamos esperar todo el tiempo, produciendo así un **deadlock**. Un deadlock es una situación en la que el progreso de un sistema se detiene ya que cada hilo está esperando adquirir un recurso en poder de algún otro hilo.


### Lock Framework

Una solución más avanzada a `synchronized` es usar Lock framework.

La API de concurrencia de java incluye la interfaz ``Lock``, que es conceptualmente similar a usar la palabra clave `synchronized` pero con muchas más funcionalidades.

Sin embargo, en lugar de sincronizar en cualquier objeto, podemos "bloquear" solo en un objeto que implemente la interfaz ``Lock``.

Ejemplo con ``synchronized``:

```java
// Implementation #1 with a synchronized block 
Object object = new Object(); 
synchronized(object) { 
	// Protected code
	// ....
}
```

Ejemplo equivalente con Framework Lock:


```java
// Implementation #2 with a Lock 
Lock lock = new ReentrantLock(); 

try {
	lock.lock(); 
	// Protected code
	// ...
} finally {
	lock.unlock(); 
}
```


### CyclicBarrier

A mayores de las técnicas anteriores, surge la necesidad de orquestar tareas complejas en múltiples pasos, teniendo en cuenta escenarios thread-safe.

La clase ``CyclicBarrier`` es una ayuda de sincronización que permite que un conjunto de hilos esperen unos a otros para alcanzar un punto de barrera común.

Los CyclicBarriers son útiles en programas que involucran un grupo de hilos de tamaño fijo que ocasionalmente deben esperar el uno al otro. La barrera se llama cíclica porque se puede reutilizar después de que se liberan los hilos en espera.

Esta solución es superior a una solución de hilo único, ya que las tareas individuales, pueden ser realizadas en paralelo.

``CyclicBarrier`` toma en sus constructores un valor límite, indicando el número de hilos a esperar. A medida que finaliza cada hilo, llama al método ``await()`` en la barrera cíclica. Una vez que el número especificado de hilos ha llamado ``await()``, la barrera se libera y todos los hilos pueden continuar.

Después de que se alcanza el límite de CyclicBarrier (lo que quiere decir que la barrera se rompe), todos los hilos se liberan y la cantidad de hilos que esperan en CyclicBarrier vuelve a cero.

En este punto, CyclicBarrier se puede usar nuevamente para un nuevo conjunto de hilos en espera. Por ejemplo, si nuestro límite de CyclicBarrier es 5 y tenemos 15 hilos que llaman await(), CyclicBarrier se activará un total de tres veces.

