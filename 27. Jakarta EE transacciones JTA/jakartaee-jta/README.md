
# Jakarta EE: transacciones JTA

https://jakarta.ee/specifications/transactions/

* ``jakarta.transaction.UserTransaction`` para controlar transacciones de forma programática.

* jakarta.transaction.TransactionManager
* jakarta.transaction.Transaction
* jakarta.transaction.Synchronization
* javax.transaction.xa.XAResource

```java
@Resource 
UserTransaction userTransaction; 

public void updateData() {
	// Start a transaction. 
	userTransaction.begin(); // ...
	// Perform transactional operations on data 
	// Commit the transaction. 
	userTransaction.commit();
}
```


JTA es una API general para administrar transacciones en Java. Le permite iniciar, confirmar y revertir transacciones de una manera neutral en cuanto a recursos. El estado transaccional generalmente se almacena en TLS (almacenamiento local de subprocesos) y se puede propagar a otros métodos en una pila de llamadas sin necesidad de pasar algún objeto de contexto explícito. Los recursos transaccionales pueden unirse a la transacción en curso. Si hay más de un recurso participando en tal transacción, al menos uno de ellos tiene que ser un llamado recurso XA.

Una transacción local de recursos es una transacción que tiene con un único recurso específico que utiliza su propia API específica. Dicha transacción generalmente no se propaga a otros métodos en una pila de llamadas y se requiere que pase algún objeto de contexto explícito. En la mayoría de las transacciones locales de recursos, no es posible tener múltiples recursos participando en la misma transacción.

Usaría una transacción local de recursos en, por ejemplo, código JDBC de bajo nivel en Java SE. Aquí, el objeto de contexto se expresa mediante una instancia de java.sql.Connection. Otros ejemplos de transacciones locales de recursos son los desarrolladores que crean aplicaciones empresariales alrededor de 2002. Dado que los administradores de transacciones (utilizados por JTA) eran costosos, de código cerrado y complicados de configurar en esa época, la gente optó por las variantes locales de recursos más baratas y fáciles de obtener.

Básicamente, usaría una transacción JTA en cualquier otro escenario. Servidores muy simples, pequeños, gratuitos y de código abierto como TomEE (25 MB) o GlassFish (35 MB) tienen soporte JTA listo para usar. No hay nada que configurar y simplemente funcionan.

Finalmente, tecnologías como EJB y Spring hacen que incluso JTA sea más fácil de usar al ofrecer transacciones declarativas. En la mayoría de los casos, se recomienda usarlos, ya que son más fáciles, más limpios y menos propensos a errores. Tanto EJB como Spring pueden usar JTA bajo las sábanas.


## Unidad de persistencia

El archivo persistence.xml contiene la unidad de persistencia que reúne toda la información necesaria para la creación del EntityManagerFactory. 

``<persistence-unit transaction-type="RESOURCE_LOCAL">`` implica que:

* Las transacciones son manejadas por el desarrollador.
* El ciclo de vida del contexto de persistencia es manejado por el desarrollador.
* Las transacciones tienen lugar en una sola unidad de persistencia / sistema (una sola base de datos.)

``<persistence-unit transaction-type="JTA">`` implica que:

* Las transacciones son manejadas por el servidor de aplicaciones.
* El ciclo de vida del contexto de persistencia es manejado por el servidor de aplicaciones.
* Las transacciones tienen lugar a lo largo de varias unidades de persistencia / sistemas (múltiples bases de datos).