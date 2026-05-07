# Taller Ahorcado
## 📌Taller #5 de Logica de Programación


## ⦗📑⦘ Contenido:

- Repositorio.
- Diapositivas.
- Exposicion.
- Preguntas de Teoria.
- Creditos.

>Este Repositorio Tiene como finalidad, presentar el Taller #5 de la clase de Logica de Programación, que tiene por titulo Taller del Ahorcado.
>Y que tiene lo siguiente: 
>En este taller construirán el juego del **Ahorcado** en Java. Las palabras estarán organizadas en categorías y se cargarán desde un archivo **CSV**, poniendo en práctica cadenas de texto y funciones (métodos).

## ⦗⚠️⦘ Pasos Durante la realización del Proyecto:


> ## Paso 1: Arq. del Proyecto 🏗️ (1/2)

Clases principales del proyecto:

-   `Main.java`  — punto de entrada y menú principal.
-   `Juego.java`  — lógica del ahorcado (intentos, estado, resultado).
-   `CargadorCSV.java`  — lee el CSV y devuelve la lista de palabras.

> ## Paso 1: Arq. del Proyecto 🏗️ (2/2)

Clases de apoyo y archivo de datos:

-   `ConsoleInput.java`  — clase del profe para leer datos del usuario.
-   `palabras.csv`  — archivo de datos incluido en el repositorio.

>## Paso 2: CSV y Categorías 📄

El archivo  `palabras.csv`  debe tener este formato:

```plaintext
categoria,palabra,pista
ANIMALES,elefante,mamifero grande de orejas grandes
ANIMALES,leon,animal salvaje del sabana
PAISES,colombia,pais suramericano bañado por dos oceanos
PAISES,guatemala,pais centroamericano con volcanes
ANIMALES,nutria,animal acuático con cola larga

```

Categorías obligatorias:  **ANIMALES, TECNOLOGIA, PAISES, COLOMBIA, PROGRAMACION**. Mínimo  **10 palabras por categoría**  (50 palabras en total).

>## Paso 3: Leer el CSV en Java 📂

Implementar en  `CargadorCSV.java`  el método  `cargarPalabras()`  usando  `BufferedReader`  y  `String.split()`:

```java
BufferedReader br = new BufferedReader(
    new FileReader("palabras.csv"));
String linea = br.readLine(); // saltar encabezado
while ((linea = br.readLine()) != null) {
    String[] partes = linea.split(",");
    lista.add(new Palabra(
        partes[0], partes[1], partes[2]));
}
br.close();
```

⚠️ Manejar la excepción  `IOException`  con try-catch para que el programa no se cierre si el archivo no se encuentra.

> ## Paso 4: Lógica del Juego 🎮 (1/2)

El flujo del juego en  `Juego.java`:

1.  El usuario elige una categoría del menú.
2.  Se selecciona una palabra aleatoria de esa categoría.
3.  Se muestra la palabra como guiones, para que el usuario complete:  `_ec_e_o`  (secreto)

> ## Paso 4: Lógica del Juego 🎮 (2/2)

4.  El usuario ingresa una letra por turno.
5.  Si acierta, se revelan las posiciones correctas; si falla, se dibuja una parte del ahorcado.
6.  El juego termina al completar la palabra (victoria) o acumular 6 errores (derrota).

> ## Paso 5: ASCII Art del Ahorcado 🖼️

Definir los 7 estados (0–6 errores) en el método  `mostrarAhorcado(int errores)`  usando un  `switch`  o un arreglo de Strings:

```java
// Estado final - 6 errores (partida perdida)
"  +---+\n" +
"  |   |\n" +
"  O   |\n" +
" /|\\  |\n" +
" / \\  |\n" +
"      |\n" +
"=========\n"
```

>## Paso 6: Funciones ⚙️ (1/2)

El taller exige separar la lógica en métodos con nombres descriptivos:

-   `mostrarAhorcado(int errores)`  — imprime el estado ASCII.
-   `mostrarPalabra(char[] estado)`  — imprime letras descubiertas y guiones.
-   `validarLetra(char letra, String palabra, char[] estado)`  — retorna  `boolean`.

>## Paso 6: Funciones ⚙️ (2/2)

-   `seleccionarPalabraAleatoria(String[] lista,int categoria)`  — usa  `Math.random()`.
-   `estaCompleta(char[] estado)`  — verifica si el jugador ganó.
-   `verificarEasterEgg(String nombre)`  — activa el modo secreto (bonus).

>## Paso 7: Menú Principal 📋

Implementar en  `Main.java`  un menú con ASCII art propio ejecutado en un  `do-while`:

-   1. Jugar (seleccionar categoría)
-   2. Ver instrucciones
-   3. Tabla de récords
-   4. Salir

El programa debe manejar entradas inválidas sin cerrarse, y al seleccionar "Jugar" mostrar un submenú con las categorías disponibles cargadas desde el CSV.

>## 🥚 BONUS: Easter Egg (1/2)

Al iniciar el juego, el programa pide el nombre del jugador. Si el nombre ingresado es exactamente  **`XACARANA`**, se activa el  **Modo Dios**:

-   🎉 Aparece un ASCII art especial de celebración.
-   🔓 Se desbloquea la categoría oculta  **SECRETOS**  (palabras geek:  `DARTHVADER`,  `KONAMI`,  `MATRIX`,  `TARDIS`,  `ZELDA`…).
-   ⚡ La primera letra de la partida se revela automáticamente.

>## 🥚 BONUS: Easter Egg (2/2)

Implementarlo en el método  `verificarEasterEgg(String nombre)`  que retorna  `boolean`.


## ⦗📁⦘ Repositorio:

>En este repositorio esta la explicacion de cada uno de los pasos del Programa pedido por las inidicaciones del Profesor, se llevo a cabo en el lenguaje de Programación de Java para grantizar un trabajo ordenado, se repartio de manera equitativa entre los integrantes del Grupo y esto se puede ver evidenciado en los comits del repositorio.
>Dentro de Este se encuentra un archivo con las preguntas de Teoría Respectivas para poder realizar este trabajo, la presentación de las diapositivas explicando de manera coherente lo que se hizo y los codigos necesarios y archivos para la realización completa.

## ⦗📽️⦘ Diapositivas:

>A continuación se encontraran las Diapositivas que contiene la exposición y la en esta la explicación oral a detalle del proyecto: 
>[Diapositivas](https://canva.link/gumecm0omlcb1ms)


## ⦗🗣⦘ Exposición:

>Explicación del proceso de realización del taller#5, sustentando el como hicimos los programas y también mostrando las diapositivas explicando que son los Strings y las Funciones, que metodos se usan en este proyecto.


## ⦗🪪⦘ Créditos:

>`Luis Leonardo Rodriguez`

>`Esteban Presiga Posada`

>`Emanuel Tamayo Florez`
