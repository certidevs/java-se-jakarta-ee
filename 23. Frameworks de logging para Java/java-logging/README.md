
# Frameworks de logging en Java

https://mvnrepository.com/open-source/logging-frameworks

Implementaciones en **desuso** o poco utilizados actualmente:

* Apache Log4j (versión 1, sin mantenimiento desde 2015)
    * log4j
* java.util.logging (JUL, desde java 1.4): viene integrado en java, pero en su lugar se usa cualquiera de los otros debido a sus carencias
* Apache Commons Logging (JCL): poco flexible y problemas con classloaders.

Implementaciones en **uso** actualmente:

*  SLF4J (Simple Logging Facade for Java)
    * **slf4j-api** proporciona una API estándar que es implementada por la mayoría de frameworks de logging. Al usarla, podemos cambiar el framework de logging sin tener que realizar cambios en el código, solamente cambiar la implementación por medio de una dependencia.
* Logback: no necesita SLF4J, lo integra nativamente
    * logback-classic
* Apache Log4j2 (versión 2)
    * log4j-api
    * log4j-core
    * log4j-slf4j-impl (solo si se quiere usar a través de SLF4j)
* JBoss logging
    * jboss-logging
* tinylog

¿Por qué utilizar los frameworks de logging a través de la API SLF4j? Al escribir bibliotecas, simplemente no sabe qué framework de registro desea usar un usuario de su biblioteca en su propia aplicación. Por lo tanto, tiene sentido escribir su biblioteca para usar una interfaz de registro, y luego el usuario puede conectar cualquier implementación de registro que desee, siempre que implemente su propia aplicación.

El framework Spring Boot se usa Logback por defecto. El framework Quarkus utiliza JBoss Logging.

## Apache Log4j2

https://logging.apache.org/log4j/2.x/

La configuración se puede realizar por medio de un archivo log4j.properties o log4j.xml dentro del directorio src/main/resources de los proyectos java configurados con maven.

Para la configuración xml, estos son los nodos a configurar en el archivo:

* ``Configuration``: el elemento raíz de un archivo de configuración log4j2; el atributo de estado representa el nivel en el que se deben registrar los eventos log4j internos.
* ``Appenders``: este elemento contiene una lista de anexadores; en nuestro ejemplo, se define un appender correspondiente a la consola del sistema.
* ``Loggers``: este elemento contiene una lista de instancias de registradores. El elemento raíz es un registrador estándar que genera todos los mensajes.

Como appenders se puede utilizar distintas estrategias:

- ``ConsoleAppender``: registra mensajes en la consola del sistema
- ``FileAppender``: escribe mensajes de registro en un archivo
- ``RollingFileAppender``: escribe los mensajes en un archivo de registro continuo
- ``JDBCAppender``: utiliza una base de datos relacional para registros
- ``AsyncAppender``: contiene una lista de otros anexadores y determina los registros para que estos se escriban en un hilo separado

## Logback

- ``ConsoleAppender``: escribe mensajes en la consola del sistema
- ``FileAppender``: agrega mensajes a un archivo
- ``RollingFileAppender``: amplía FileAppender con la capacidad de pasar archivos de registro
- ``SMTPAppender``: envía mensajes de registro en un correo electrónico, por defecto solo para mensajes de ERROR
- ``DBAppender``: agrega eventos de registro a una base de datos
- ``SiftingAppender``: separa los registros en función de un atributo de tiempo de ejecución.

## Niveles

* ALL
* TRACE
* DEBUG
* INFO
* WARN
* ERROR
* FATAL

Cuando se activa uno se activan los anteriores, por ejemplo, DEBUG habilita INFO, WARN, ERROR, FATAL:

ALL < TRACE < DEBUG < INFO < WARN < ERROR < FATAL

## Logging centralizado

Cuando se trabaja con arquitecturas de microservicios una opción muy común es optar por tener el logging centralizado. Para ello se envían todos los logs a un sistema externo como Graylog, Splunk o Elastic Stack.

De esta forma se accede a los logs mediante un dashboard con visualizaciones donde se puede observar lo que ocurre en todas las aplicaciones a la vez.

## Recomendación

Utilizar SLF4J con una implementación popular como logback o log4j v2.