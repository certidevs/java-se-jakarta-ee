
# JavaFX

JavaFX es una biblioteca para crear aplicaciones de cliente enriquecidas con Java.

Proporciona una API para diseñar aplicaciones GUI que se ejecutan en casi todos los dispositivos compatibles con Java.

En Java 8, 9 y 10 no es necesaria ninguna configuración adicional para comenzar a trabajar con la biblioteca JavaFX.

A partir de JDK 11, los módulos javafx.* ya no se incluyen como parte de JDK. Ahora se distribuyen por separado como una versión independiente y desagregada de OpenJFX. Están disponibles como artefactos maven para usar con maven/gradle o como un SDK independiente.

JavaFX utiliza un lenguaje de marcado FXML especial para crear las interfaces de vista.

Esto proporciona una estructura basada en XML para separar la vista de la lógica empresarial. XML es más adecuado aquí, ya que puede representar de forma bastante natural una jerarquía de Scene Graph.

Finalmente, para cargar el archivo .fxml, usamos la clase FXMLLoader, que da como resultado el gráfico de objetos de la jerarquía de la escena.


Dependencias maven:

* javafx-controls
* javafx-fxml
* bootstrapfx-core

Plugins maven:

* javafx-maven-plugin

Otra opción es descargar el empaquetado:

https://gluonhq.com/products/javafx/

## FXML

https://openjfx.io/javadoc/17/javafx.fxml/javafx/fxml/doc-files/introduction_to_fxml.html

FXML es un lenguaje de marcado basado en XML que admite secuencias de comandos para construir gráficos de objetos Java.

Proporciona una alternativa conveniente a la construcción de dichos gráficos en código java y es ideal para definir la interfaz de usuario de una aplicación JavaFX, ya que la estructura jerárquica de un documento XML es muy similar a la estructura del escenario gráfico JavaFX.


## Ciclo de vida

La clase con método main es el método de entrada a la aplicación, y extiende de ``javafx.application.Application``.

Al extender puede sobrescribir los siguientes métodos que permiten controlar el ciclo de vida:

* init()
* start()
* stop()
