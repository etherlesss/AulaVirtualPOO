<details>
<summary> Previo aviso </summary>
Todos los RUTs, contraseñas e individuos dentro de este programa fueron generados mediante un generador programado por uno de nuestros integrantes y no pertenecen a ninguna persona en específico y tampoco fueron usados de forma maliciosa.
</details>

### Descripción
Este proyecto consiste de un aula virtual programado en Java, el cual dispone de una variedad de operaciones para realizar, dependiendo del tipo de usuario que esté haciendo uso de este, sea alumno o profesor.

### Uso
Una vez ejecutado el programa, lo primero que se puede apreciar es una interfaz gráfica, aquí debes ingresar tus datos seas alumno o seas profesor. Por razones obvias, para el que este ejecutando esto les facilitamos datos para que puedan probar las operaciones (de todas formas se encuentran disponible en ruta .\src\test\java\in):

###### Profesor: 11.783.189-1 Contraseña: dd37SG7j9rMC
###### Alumno: 25.459.387-0 Contraseña: NYa35v63DDSs

Una vez estando la sesión iniciada, se mostrará un mensaje de retroalimentación al respecto, tanto el inicio de sesión se haya realizado de forma exitosa o no.

Haciendo inicio de sesión como profesor, tenemos las funciones de alto privilegio, donde se cada opción seleccionada en el menú realiza distintas acciones:

<details>
  <summary>Agregar elementos</summary>
  La función agregar elementos abre otro sub-menú interactivo, donde podemos agregar notas a un alumno 'x' en un ramo o agregarle materiales para que este traiga una específica fecha.
</details>

<details>
  <summary>Mostrar elementos</summary>
  La función mostrar datos abre un sub-menú interactivo donde podemos elegir imprimir datos, dentro de esta opción, podemos mostrar datos de la sesión, o mostrar datos de un alumno, buscando por su RUT.
</details>

<details>
  <summary>Eliminar elementos</summary>
  La función eliminar elementos, realiza lo opuesto a agregar elementos, cualquier opción seleccionada imprimirá las listas de lo que tenga para eliminar, simplemente basta con seleccionar el ítem de la lista a eliminar y se realizará la operación.
</details>

<details>
  <summary>Modificar elementos</summary>
  La función modificar elementos nos permite modificar una nota de un alumno, buscando por su rut. Una vez ingresado el RUT del alumno a modificar, nos pedirá el ramo y nos pedirá la nota que queremos reemplazar dentro de la lista.
</details>

Haciendo inicio de sesión como alumno, tenemos las funciones de bajo privilegio, donde se cada opción seleccionada en el menú realiza distintas acciones (aunque todas son del mismo tipo):

<details>
  <summary>Mostrar elementos</summary>
  La función mostrar datos abre un sub-menú interactivo donde podemos elegir imprimir datos, dentro de esta opción, podemos mostrar el avance de notas del alumno, los materiales que el profesor les ha asignado, y podemos exportar su avance de notas en un archivo .txt que estará disponivle en la ruta: .\src\test\java\out.
</details>

Todas las interacciones poseen indicaciones sobre que operación realizar, por lo que no necesitan una profundización mayor.
