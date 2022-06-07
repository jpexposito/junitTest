<div align="justify">

# JUNIT - MOKITO

<div align="center">
  <img src="https://javadesde0.com/wp-content/uploads/Mockito.jpg" width="400px" />
</div>

## Terminología

Mockito, es un framework de código abierto, que nos permite la creación de objetos simulados, con el propósito de realizar pruebas unitarias en Java.

El nombre y el logotipo del framework Mockito, surge de la bebida alcohólica conocida como Mojito.

### Diferencias entre el testing con JUnit y Mockito

Si realizamos pruebas con una única clase, no necesitaremos realizar Mocks (burlas) a otras clases. Por tanto, estás pruebas, las podremos realizar mediante a JUnit.

En el caso la clase con la que vamos utilice a otras clases, será cuando requerirá la realización de Mocks. Por tanto, el uso de Mockito, se puede decir que, complementa a JUnit, con la finalidad de realizar pruebas más exhaustivas.

### ¿Qué son los Mocks?

Mock, traducido al castellano significa burlarse de… Esta traducción, nos va a servir para entender mejor lo que hace este marco de trabajo. Nos quedamos con dicho significado de la traducción literal para poder entender lo que hace Mockito.

### ¿Para qué necesito un Object Mock?

Como comentábamos en el artículo Introducción a los Test unitarios (Unit Testing), las pruebas unitarias son independientes de otras pruebas unitarias. Cada unidad de trabajo, depende únicamente de la clase que testea.

Por ello, no podemos utilizar datos de fuentes externas como BBDD o ficheros. Sino que los datos se introducen mediante a Mocking, un mecanismo que trata de burlar o engaña a la prueba unitaria. La solución a todo esto es introducir los datos «hardcodeados» (picados a mano) mediante a un Mock.

<div align="center">
  <img src="https://javadesde0.com/wp-content/uploads/atomic-figure-3-450.jpg" width="400px" />
</div>

El engaño y la burla mediante a Mocks, son la herramienta que nos Mockito para poder engañar a JUnit. Es decir, los Mocks impiden que se vaya a otras clases. La finalidad de todo esto, es el poder ejecutar test sobre una funcionalidad de una clase en concreto de forma aislada.

<div align="center">
  <img src="https://javadesde0.com/wp-content/uploads/mocking_overview.png" width="400px" />
</div>

Un mock, realmente, es un simulacro, un suplente para un módulo real. No contiene ninguna funcionalidad real, sino que imita la interfaz de un módulo. Cuando se usa en una prueba, un simulacro intercepta llamadas entre el módulo bajo prueba y el módulo simulado. Si la función a la que se llama tiene un valor de retorno, el simulacro de esa función también devolverá un valor como se especifica en la prueba.

<div align="center">
  <img src="https://javadesde0.com/wp-content/uploads/atomic-figure-1-450.jpg" width="400px" />
</div>

<br>

<div align="center">
  <img src="https://javadesde0.com/wp-content/uploads/1_fCMBDvJQWR6KokIF-H7iwQ.png" width="400px" />
</div>


## Enlaces

- [Junit - Mokito](https://javadesde0.com/introduccion-a-las-pruebas-unitarias-con-junit-y-mockito/)
- [Ejemplo Mokito](https://examples.javacodegeeks.com/core-java/mockito/mockito-mock-database-connection-example/)
</div>