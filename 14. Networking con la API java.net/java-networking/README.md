
# API java.net

## HTTP

API java antigua: ``java.net.HttpUrlConnection``

Librerías: Apache HttpClient, Jetty, Spring RestTemplate (deprecated), Spring WebClient.

API java nueva (>= JDK 11): ``java.net.http.HttpClient``

## Socket
El término programación con **sockets** se refiere a la escritura de programas que se ejecutan en varios ordenadores en los que los dispositivos están conectados entre sí mediante una red.

Hay dos protocolos de comunicación que podemos utilizar para la programación de sockets: El Protocolo de Datagramas de Usuario (UDP) y el Protocolo de Control de Transferencia (TCP).

La principal diferencia entre ambos es que el UDP no tiene conexión, es decir, no hay sesión entre el cliente y el servidor, mientras que el TCP está orientado a la conexión, lo que significa que primero debe establecerse una conexión exclusiva entre el cliente y el servidor para que se produzca la comunicación.

Es común que los sockets se establezcan sobre redes TCP/IP con el fin de crear aplicaciones cliente/servidor en el caso de Java. UDP no es un protocolo corriente, y como tal, puede que no se encuentre a menudo.

## HTTP vs. Sockets

El Protocolo de Transferencia de Hipertexto (HTTP) es un protocolo a nivel de aplicación para sistemas de información distribuidos, colaborativos e hipermedia. Es un protocolo genérico, sin estado, que puede utilizarse para muchas tareas más allá de su uso para el hipertexto, como servidores de nombres y sistemas de gestión de objetos distribuidos, mediante la ampliación de sus métodos de solicitud, códigos de error y cabeceras. Una de las características de HTTP es la tipificación y negociación de la representación de los datos, lo que permite construir sistemas independientes de los datos que se transfieren.

Por su parte, un Socket es un punto final de un enlace de comunicación bidireccional entre dos programas que se ejecutan en la red. El Socket está vinculado a un número de puerto para que la capa TCP pueda identificar la aplicación a la que se destinan los datos. En otras palabras, los Sockets proporcionan una interfaz para programar redes en la capa de transporte. La comunicación de red utilizando Sockets es muy similar a la realización de E/S (I/O) de archivos. De hecho, el manejador del socket se trata como el manejador del archivo. La comunicación basada en sockets es independiente del lenguaje de programación utilizado para implementarla. Esto significa que un programa de socket escrito en lenguaje Java puede comunicarse con un programa escrito en un programa de socket que no sea Java (por ejemplo, C o C++).


## Sockets en Java
Java proporciona una colección de clases e interfaces que se encargan de los detalles de comunicación de **bajo nivel** entre el cliente y el servidor.

La mayoría de ellas están contenidas en el paquete ``java.net``, por lo que tenemos que hacer la siguiente importación:

```java
import java.net.*;
```

También necesitamos el paquete ``java.io``, que nos proporciona flujos de entrada y salida para escribir y leer mientras nos comunicamos:


```java
import java.io.*;
```


