
# Jakarta EE: Servicios web XML JAX-WS

https://jakarta.ee/specifications/xml-web-services/

La API de Java para servicios web XML (JAX-WS) es una API estandarizada para crear y consumir servicios web SOAP (Protocolo simple de acceso a objetos).

SOAP es una especificación XML para enviar mensajes a través de una red. Los mensajes SOAP son independientes de cualquier sistema operativo y pueden usar una variedad de protocolos de comunicación, incluidos HTTP y SMTP.

SOAP es extenso en XML, por lo tanto, se usa mejor con herramientas/marcos. JAX-WS es un marco que simplifica el uso de SOAP. Es parte de Java estándar.

## WSDL

Lenguaje de definición de servicios web (WSDL)

WSDL es una definición de contrato de los servicios disponibles. Es una especificación de mensajes de entrada/salida y cómo invocar el servicio web. Es de lenguaje neutral y está definido en XML.

En un enfoque de abajo hacia arriba (último contrato), las clases de Java se escriben y el WSDL se genera a partir de las clases de Java.

SOAP significa Protocolo simple de acceso a objetos. SOAP es un protocolo estándar de la industria basado en XML para diseñar y desarrollar servicios web. Dado que está basado en XML, es independiente de la plataforma y el idioma. Entonces nuestro servidor puede estar basado en JAVA y el cliente puede estar en .NET, PHP, etc. y viceversa.

WSDL significa Lenguaje de descripción de servicios web. WSDL es un documento basado en XML que proporciona detalles técnicos sobre el servicio web. Parte de la información útil en el documento WSDL es: nombre del método, tipos de puerto, punto final del servicio, enlace, parámetros del método, etc.

UDDI es el acrónimo de Universal Description, Discovery and Integration. UDDI es un directorio de servicios web donde las aplicaciones cliente pueden buscar servicios web. Los servicios web pueden registrarse en el servidor UDDI y ponerlos a disposición de las aplicaciones cliente.

## Ventajas

Algunas de las ventajas de los servicios web son:

- Interoperabilidad: debido a que los servicios web funcionan en red y usan tecnología XML para comunicarse, se pueden desarrollar en cualquier lenguaje de programación que admita el desarrollo de servicios web.
- Reutilización: un servicio web puede ser utilizado por muchas aplicaciones cliente al mismo tiempo. Por ejemplo, podemos exponer un servicio web para el análisis técnico de una acción y puede ser utilizado por todos los bancos e instituciones financieras.
- Acoplamiento flexible: el código del cliente de los servicios web es totalmente independiente del código del servidor, por lo que hemos logrado un acoplamiento flexible en nuestra aplicación. Esto conduce a un fácil mantenimiento y fácil de ampliar.
- Fácil de implementar e integrar
- Se pueden ejecutar varias versiones de servicio al mismo tiempo.

## Crear proyecto

En caso de utilizar un servidor de aplicaciones que proporcione implementaciones de jakarta ee como por ejemplo wildfly, será suficiente con añadir solo las apis en el pom.xml:

* jakarta.jakartaee-api
* jakarta.xml.ws-api

En el caso de utilizar un contenedor de servlets que no proporciona implementaciones de ws-api entonces de debe añadir la implementación al pom.xml:

```xml
<!-- https://mvnrepository.com/artifact/com.sun.xml.ws/jaxws-rt -->
<dependency>
    <groupId>com.sun.xml.ws</groupId>
    <artifactId>jaxws-rt</artifactId>
    <version>4.0.0</version>
</dependency>
```

Plugin IntelliJ IDEA:

* Jakarta EE: Web Services (JAX-WS)

## Anotaciones

``@WebService``: se utiliza para indicar que una clase java es un servicio web.

``@WebMethod``: se utiliza para configurar un método de java para exponer como un método de servicio web.

``@SOAPBinding`` se usa para especificar el estilo de mensajería SOAP, que puede ser ``RPC`` o ``DOCUMENT``. Este estilo representa el estilo de codificación del mensaje enviado de un lado a otro mientras se usa el servicio web:

* ``RPC``: un servicio web solo puede usar tipos de datos simples como enteros o String.
* ``DOCUMENT``: es capaz de tipos de datos más ricos para una clase, como por ejemplo Employee, que puede tener atributos como name, age, salary, etc.

WSDL generado: 

Este archivo WSDL es un formato XML que describe el servicio web. Este es un contrato estricto y describe mensajes y operaciones en un nivel abstracto. Etiquetas del archivo WSDL:

- types: esta etiqueta opcional representa tipos de datos en un XSD. Esta etiqueta puede contener o apuntar a un XSD. Si encontramos esta etiqueta tan vacía como en el WSDL anterior, significa que el servicio web utiliza tipos de datos simples. Para tipos de datos complejos, se implementan servicios web de estilo DOCUMENT, que se explican en la siguiente sección.
- message: Esta etiqueta define los mensajes que implementan el servicio web. Estos mensajes se construyen a partir de mensajes que se definen en la sección de tipos, también se define en el orden de los mensajes que representan el patrón de respuesta de solicitud de la operación del servicio web.
- portType: esta etiqueta representa el servicio como operaciones con nombre, y cada operación utiliza uno o más mensajes. Estas operaciones se definen después de los nombres de métodos definidos en la anotación @WebMethods. Es una especie de interfaz Java que define el servicio web a un nivel abstracto.
- binding: esta etiqueta es una especie de implementación de una interfaz Java. Aquí están presentes detalles concretos del servicio web.
- service: esta etiqueta contiene información sobre uno o más puntos finales donde la funcionalidad del servicio web está disponible.