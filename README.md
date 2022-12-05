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
  <summary>Ver datos</summary>
  La opción ver datos nos permite mostrar los datos del usuario logueado.
</details>

<details>
  <summary>Ver datos de alumno</summary>
  La opción ver datos de alumno nos permite mostrar los datos de un alumno, buscándolo en base al RUT.
</details>

<details>
  <summary>Alumnos con promedio mas bajo y alto</summary>
  La opción nos permite mostrar por terminal los alumnos que tienen el promedio más bajo y más alto entre todos los cursos.
</details>

<details>
  <summary>Notas alumno por más y menos aceptable</summary>
  La opcion nos permite mostrar por terminal los alumnos con promedio general mayor a 4.0 y menor a 5.0 (aceptable) y los alumnos con promedio inferior a 4.0 (inaceptable).
</details>

<details>
  <summary>Cambiar nota</summary>
  La opción nos permite cambiar la nota de un alumno, primero buscandolo por el RUT, después nos mostrará una lista de los ramos en los cuales podemos cambiar una nota y luego nos mostrara por terminal las notas que podemos reemplazar, a lo que deberemos ingresar un valor entre el intervalo que deje.
</details>

<details>
  <summary>Agregar nota</summary>
  La opción nos permite agregar una nota a un alumno, primero buscandolo por el RUT, después nos mostrará una lista de los ramos en los cuales podemos cambiar una nota y luego deberemos ingresar la cantidad de notas a agregar y posteriormente las notas que queramos.
</details>

<details>
  <summary>Agregar material</summary>
  La opción nos permite agregar un material a un curso, para que los alumnos traigan en un dia específico.
</details>

<details>
  <summary>Eliminar material</summary>
  La opción nos permite eliminar un material de un curso.
</details>

<details>
  <summary>Eliminar nota</summary>
  La opción nos permite eliminar una nota de algun alumno primero buscandolo por el RUT, después nos mostrará una lista de los ramos en los cuales podemos eliminar una nota y luego nos mostrara por terminal las notas que podemos eliminar, a lo que deberemos ingresar un valor entre el intervalo que deje.
</details>

Haciendo inicio de sesión como alumno, tenemos las funciones de bajo privilegio, donde se cada opción seleccionada en el menú realiza distintas acciones (aunque todas son del mismo tipo):

<details>
  <summary>Ver materiales</summary>
  La función ver materiales nos permite ver los materiales que debe traer un alumno en sus distintos ramos.
</details>

<details>
  <summary>Exportar notas</summary>
  La función exportar notas exportará el avance de notas del alumno en un archivo .csv que estará disponible en la ruta: .\src\test\java\out.
</details>

<details>
  <summary>Mostrar notas</summary>
  La función mostrar notas nos mostrará las notas del alumno en la terminal.
</details>

Todas las interacciones poseen indicaciones sobre que operación realizar, por lo que no necesitan una profundización mayor.
