
# Jakarta EE: lógica de negocio con CDI y EJB

## CDI

Aparece por primera vez en Java EE 6 en 2009.

CDI: Contexts and Dependency Injection

https://jakarta.ee/specifications/cdi/

CDI en una de las especificaciones más importantes de todas para Jakarta EE. De hecho, la mayoría de las especificaciones de Jakarta EE hacen uso de CDI de una forma u otra, actúa como pegamento entre diferentes especificaciones del ecosistema Jakarta EE.

CDI obtuvo su nombre al proporcionar:

* ciclo de vida de objetos contextuales para aplicaciones y servicios.
* un mecanismo de inyección de dependencias con seguridad de tipos. 

Todo esto es posible utilizando anotaciones programáticas en lugar de configuración. Esas dos características por sí solas mejoran la productividad y la capacidad de mantenimiento de software.

Otras características:

* Programación orientada a aspectos: proporcionada por los interceptores, 
* Notificación de eventos.
* Contextos de conversación web: para mantener el estado de los beans entre múltiples peticiones.

La implementación de referencia para la API Jakarta CDI es [weld](https://weld.cdi-spec.org/).

### Inyección de dependencias

A menudo, existen requisitos para usar objetos en varias clases dentro de una aplicación. Por ejemplo, si un objeto se llena con valores, puede tener sentido usar los valores de ese objeto en su estado actual dentro de otra clase para algún proceso. Aquí es donde entra en juego el concepto de inyección de dependencias. 

La inyección de dependencias permite "inyectar" objetos en otras clases de una manera segura, mientras se conserva el contexto. También permite elegir una implementación de interfaz particular en tiempo de ejecución, lo que permite inyectar diferentes versiones de un bean en diferentes entornos, como entornos de producción y desarrollo.

Formas de declarar beans inyectables con Jakarta CDI:

* ``@ApplicationScoped``: el objeto se instancia una vez por aplicación y permanece disponible para todos los demás objetos dentro de la misma aplicación.
* ``@SessionScoped``: el objeto se instancia una vez por sesión y permanece disponible para todos los demás objetos dentro de la misma sesión.
* ``@ConversationScoped``: el objeto se instancia una vez por conversación y permanece disponible para todos los demás objetos dentro de la misma conversación.
* ``@RequestScoped``: se crea una instancia del objeto una vez por solicitud y permanece disponible durante todo el ciclo de vida de la solicitud.
* ``@Dependent``: el objeto existe para servir exactamente a un bean y conserva el mismo ciclo de vida que ese bean.

Existen otras anotaciones, como por ejemplo `@ViewScoped` que pertenece a Jakarta Server Faces API, sirve para retener el estado de un bean mientras la vista actual esté activa.

Cuando es necesario construir un bean complejo y que pueda ser inyectable se utiliza la anotación ``@Producer`` sobre un método encargado de construir ese objeto, después el contenedor CDI podrá utilizarlo para inyectarlo donde sea necesario.

``@Qualifier`` permite distinguir que bean debe ser inyectado cuando hay múltiples posibilidades para un mismo tipo, por ejemplo, cuando se usan interfaces.

`@Vetoed` aplicado sobre un tipo permite que ese tipo no sea descubrible por el contenedor CDI, es decir, que se excluya y quede fuera del mecanismo de inyección de dependencias.


## EJB

Enterprise Java Beans: https://jakarta.ee/specifications/enterprise-beans/

Aparece por primera vez en 1996.

EJB proporciona beans de sesión y beans de mensajería. Los beans de sesión que proporciona son en realidad beans de CDI, pero proporciona 3 anotaciones que no están en CDI:

* @Stateful: 
	* El estado de un objeto consta de los valores de sus variables de instancia. En un bean stateful, las variables de instancia representan el estado de una sesión única de cliente/bean. Porque el cliente interactúa con su bean. 
	* Como sugiere su nombre, un bean stateful es similar a una sesión interactiva. Un bean de sesión no se comparte; solo puede tener un cliente, de la misma forma que una sesión interactiva puede tener solo un usuario. Cuando el cliente termina, su bean de sesión parece terminar y ya no está asociado con el cliente. 
	* El estado se conserva durante la sesión de cliente/bean. Si el cliente elimina el bean, la sesión finaliza y el estado desaparece. Cuando finaliza la conversación entre el cliente y el bean no hay necesidad de retener el estado.

* @Stateless: 
	* Un bean stateless no mantiene un estado conversacional con el cliente. Cuando un cliente invoca los métodos de un bean sin estado, las variables de instancia del bean pueden contener un estado específico para ese cliente, pero solo durante la invocación. Cuando finaliza el método, no se debe conservar el estado específico del cliente. 
	* Debido a que pueden admitir múltiples clientes, los beans de sesión sin estado pueden ofrecer una mejor escalabilidad para aplicaciones que requieren una gran cantidad de clientes. Por lo general, una aplicación requiere menos beans stateless que beans stateful para admitir la misma cantidad de clientes. Un bean stateless puede implementar un servicio web, pero un bean stateful no puede.

* @Singleton:
	* Se crea una instancia de un bean de sesión singleton una vez por aplicación y existe durante el ciclo de vida de la aplicación. Los beans Singleton están diseñados para circunstancias en las que los clientes comparten una sola instancia de bean y acceden al mismo tiempo. 
	* Los beans singleton ofrecen una funcionalidad similar a los beans stateless, pero se diferencian de ellos en que solo hay un bean singleton por aplicación, a diferencia de un grupo de beans stateless, cualquiera de los cuales puede responder a una solicitud de cliente. Al igual que los beans stateless, los beans singleton pueden implementar endpoints de servicios web.
	* Los beans Singleton mantienen su estado entre las invocaciones de los clientes, pero no es necesario que lo mantengan durante los bloqueos o apagados del servidor. Las aplicaciones que utilizan un bean singleton pueden especificar que se debe crear una instancia del singleton al iniciar la aplicación, lo que permite que el singleton realice tareas de inicialización para la aplicación. El singleton también puede realizar tareas de limpieza al cerrar la aplicación, porque el singleton funcionará durante todo el ciclo de vida de la aplicación.
	* el equivalente en CDI es @ApplicationScoped


EJB proporciona ciertas funcionalidades que CDI no:

* Beans para mensajería @MessageDriven
* Acceso local/remoto con @Local y @Remote
* Tareas programadas con @Schedule y API Timer
* Métodos asíncronos @Asynchronous
* Locks para concurrencia con @Lock
* Integración con JPA-JTA y transacciones distribuidas
* Instancias de inicio con @Startup para inicialización personalizada en el arranque de la aplicación

Los beans de CDI son también beans de EJB, pero no al revés, es decir, el orden sería:

EJB > CDI > POJOs java.