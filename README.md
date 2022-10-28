<details>
<summary> Previo aviso </summary>
Todos los RUTs, contraseñas e individuos dentro de este programa fueron generados mediante un generador programado por uno de nuestros integrantes y no pertenecen a ninguna persona en especifica y tampoco fueron usados de forma maliciosa.
</details>

### Descripcion
Este proyecto consiste de un aula virtual programado en Java, el cual dispone de una variedad de operaciones para realizar, dependiendo del tipo de usuario que este haciendo uso de este, sea alumno o profesor.




### Uso
Una vez ejecutado el programa, lo primero que se puede apreciar es una interfaz grafica, aqui debes ingresar tus datos seas alumno o seas profesor. Por razones obvias, para el que este ejecutando esto les facilitamos datos para que puedan probar las operaciones (de todas formas se encuentran disponible en ruta .\src\test\java\in):

###### Profesor: 11.783.189-1 Contraseña: dd37SG7j9rMC
###### Alumno: 25.459.387-0 Contraseña: NYa35v63DDSs

Una vez estando la sesion iniciada, se mostrara un mensaje de retroalimentacion al respecto, tanto el inicio de sesion se haya realizado de forma exitosa o no.

Haciendo inicio de sesion como profesor, tenemos las funciones de alto privilegio, donde se cada opcion seleccionada en el menu realiza distintas acciones:

<details>
  <summary>Agregar elementos</summary>
  La funcion agregar elementos abre otro sub-menu interactivo, donde podemos agregar notas a un alumno 'x' en un ramo o agregarle materiales para que este traiga una especifica fecha.
</details>

<details>
  <summary>Mostrar elementos</summary>
  La funcion mostrar datos abre un sub-menu interactivo donde podemos elegir imprimir datos, dentro de esta opcion, podemos mostrar datos de la sesion, o mostrar datos de un alumno, buscando por su RUT.
</details>

<details>
  <summary>Eliminar elementos</summary>
  La funcion eliminar elementos, realiza lo opuesto a agregar elementos, cualquier opcion seleccionada imprimira las listas de lo que tenga para eliminar, simplemente basta con seleccionar el item de la lista a eliminar y se realizara la operacion.
</details>

<details>
  <summary>Modificar elementos</summary>
  La funcion modificar elementos nos permite modificar una nota de un alumno, buscando por su rut. Una vez ingresado el RUT del alumno a modificar, nos pedira el ramo y nos pedira la nota que queremos reemplazar dentro de la lista.
</details>

Haciendo inicio de sesion como alumno, tenemos las funciones de bajo privilegio, donde se cada opcion seleccionada en el menu realiza distintas acciones (aunque todas son del mismo tipo):

<details>
  <summary>Mostrar elementos</summary>
  La funcion mostrar datos abre un sub-menu interactivo donde podemos elegir imprimir datos, dentro de esta opcion, podemos mostrar el avance de notas del alumno, los materiales que el profesor les ha asignado, y podemos exportar su avance de notas.
</details>

Todas las interacciones poseen indicaciones sobre que operacion realizar, por lo que no necesitan una profundizacion.
