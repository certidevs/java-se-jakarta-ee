
# Cómo elegir el mejor JDK

## Java


¿Qué es Java?

1.  **Lenguaje de programación** de alto nivel que permite a los desarrolladores crear varios tipos de aplicaciones software:

	- **Aplicaciones de consola:** programas que se ejecutan a través de la consola.
	- **Aplicaciones cliente**: programa de ordenador: calculadora, procesador de texto, hojas de cálculo…
	- **Aplicaciones cliente-servidor**: aplicaciones cliente que se conectan a un servidor remoto para obtener/almacenar información.
	- **Aplicaciones de servidor**: aplicaciones web como las que podemos utilizar hoy en día a través de nuestros navegadores.

2.  **Plataforma informática** que permite ejecutar aplicaciones desarrolladas en lenguaje Java u otros lenguajes compilados a bytecode, es una máquina virtual encargada de la ejecución de aplicaciones y un conjunto de bibliotecas estándar que permiten desarrollar esas aplicaciones.

Para desarrollar aplicaciones con la tecnología Java se necesitan herramientas que implementen Java Standard Edition (Java SE, antes J2SE). Java SE es una edición de java que incorpora paquetes de clases de uso general, utilizados en cualquier tipo de aplicación (tratamiento cadenas, colecciones, etc) y paquetes para entornos gráficos.


## JDK

**JRE o Java Runtime Environment** es un paquete con todo lo necesario para ejecutar un programa compilado de Java. Incluye la JVM, las bibliotecas de Java, y el comando java. Sólo sirve para ejecutar un programa ya existente, no permite crear uno nuevo.

**JDK o Java Development Kit** es un SDK para Java, contiene todo lo necesario para ejecutar programas pero también para crearlos, por tanto contiene: JRE, el compilador javac y herramientas como javadoc, etc.

**SDK o Software Development Kit** consiste en un kit de desarrollo que provee APIs y herramientas para facilitar el desarrollo de software. Este término SDK no hace referencia a ningún lenguaje de programación en particular, cada lenguaje o plataforma podrá definir un SDK y podrá tener un nombre concreto. En el caso del lenguaje de programación Java el kit de desarrollo SDK se llama JDK.

Por tanto, JDK o Java Development Kit es un conjunto de herramientas de programación que juntas proporcionan una implementación de Java SE.


## Versionado

### Versiones

Desde 2017 se lanza una nueva versión cada 6 meses:

https://mail.openjdk.org/pipermail/discuss/2017-September/004281.html

- 20 (in development)
- 19 (in development)
- 18 (GA 2022/03/22)
- 17 (GA 2021/09/14)
- 16 (GA 2021/03/16)
- 15 (GA 2020/09/15)
- 14 (GA 2020/03/17)
- 13 (GA 2019/09/17)
- 12 (GA 2019/03/19)
- 11 (GA 2018/09/25)
- 10 (GA 2018/03/20)

(GA: General Availability)


### Versiones LTS 

Cada 3 años se lanza una versión Long-Term-Support (LTS) en septiembre que recibe actualizaciones por al menos 3 años.

* 8
* 11
* 17


## Distribuciones JDK

### Open JDK 

https://openjdk.org/

OpenJDK es la implementación Open Source de referencia.

Oracle proporciona builds de OpenJDK para Linux, macOS y Windows en un formato de archivo comprimido.

Estas builds solo se actualizarán durante un período de 6 meses. 

Las actualizaciones y los parches de seguridad no estarán disponibles después de este breve período. 

Esto también se aplica a las versiones LTS.

⛔ Recomendación: no usar builds de OpenJDK de Oracle, especialmente si queremos quedarnos con las versiones LTS por un largo periodo.


### Oracle JDK

https://www.oracle.com/java/technologies/downloads/

Oracle proporciona una versión comercial de OpenJDK, que se basa exactamente en las mismas fuentes de OpenJDK: el kit de desarrollo de Oracle Java SE (JDK). 

Oracle proporciona actualizaciones periódicas y parches de seguridad para estas compilaciones (builds).

El problema principal con estas compilaciones es la política de licencias de Oracle.

Hasta la versión 10 las compilaciones se publicaron bajo la licencia "Oracle Binary Code License Agreement", que permitió se usaran para proyectos comerciales.

Desde la versión 11 a la versión 16, las compilaciones se publicaron bajo la licencia 
"Oracle Technology Network License Agreement for Oracle Java SE", que requiere una licencia de pago para su uso en producción. 

Esta es la razón por la que han surgido muchas distribuciones nuevas de OpenJDK. Las versiones anteriores se mantienen gratuitas, pero de la 11 a la 16 se paga una 
licencia que puede ser por cada usuario de escritorio o por procesador en caso de aplicaciones de servidor.

Desde la versión 17 se publica bajo otra licencia: "Oracle No-Fee Terms and Conditions (NFTC)", que permite el uso de las compilaciones para ejecutar operaciones comerciales internas. Esto produce cierta ambigüedad en su interpretación, por ejemplo: ¿Un sitio web público ejecuta operaciones 
comerciales internas?

Dada esta trayectoria de cambios en sus licencias, no es predecible cómo se licenciarán las próximas versiones.

⛔ Recomendación: No utilizar Oracle Java SE Development Kit (JDK) sin consultar un abogado.


### Eclipse Adoptium

https://adoptium.net/es/temurin/releases/

Eclipse Adoptium es un proyecto de la Fundación Eclipse, fundación que gestiona gran cantidad de proyectos software de código abierto. 

El grupo de trabajo de Adoptium está formado por las principales empresas y organizaciones que tienen un interés estratégico en la tecnología Java, incluidas Red Hat, IBM, Microsoft, Azul e iJUG. 

El antiguo proyecto AdoptOpenJDK se ha trasladado a Eclipse Adoptium.

Las compilaciones de Adoptium OpenJDK se denominan Eclipse Temurin para distinguir el proyecto de las compilaciones.

Las compilaciones de Eclipse Temurin son independientes de proveedor y probadas por TCK bajo una licencia permisiva.

Adoptium afirma que continuará creando archivos binarios para las versiones LTS siempre que la fuente ascendente correspondiente se mantenga activa.

✅ Recomendación: Se recomiendan las compilaciones Adoptium Eclipse Temurin OpenJDK.


### Otras versiones 

Todas son implementaciones de la especificación Java aprobada por el TCK (Java Technology Certification Kit).

La mayoría de los proveedores de JDK están escritos sobre OpenJDK, pero haciendo algunos ajustes a los componentes, principalmente para reemplazar partes patentadas con licencia / reemplazar con elementos de más alto rendimiento que solo funcionan en sistemas operativos específicos sin romper la compatibilidad con TCK.

Muchos proveedores implementaron la especificación Java y aprobaron TCK. Por ejemplo, IBM J9, Azul Zulu, Azul Zing y Oracle JDK.

Casi todos los JDK existentes se derivan de OpenJDK.