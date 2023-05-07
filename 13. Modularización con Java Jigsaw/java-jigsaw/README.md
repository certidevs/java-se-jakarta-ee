# Módulos con Java jigsaw

https://openjdk.org/projects/jigsaw/

Ejemplo 1: 
* module one
* module two

Ejemplo 2: 
* domain: clases de datos
* repository: interfaces
* repository.jdbc: implementación de repository
* repository.jpa: implementación de repository


Qué es un módulo:
- name
- dependencies
- exported packages
- provided packages
- used services

Para crear un módulo se define un archivo module-info.java

Nombre de un módulo:

```java
module com.example {

}
```

Dependencias de un módulo:

```java
module com.example.service {
	requires com.example.repository;
}
```

Exportar paquetes:

```java
module com.example.service {
	exports com.example.service;
}
```

Implementar interfaces de otro módulo:

```java
module com.example.impl{
	requires com.example.service;

	provides com.example.service.CustomerDAO
	with com.example.service.CustomerDAOImpl;
}
```

Usar servicios:

```java

module com.example.client{
	requires com.example.service;

	uses com.example.service.CustomerDAO;
}
```