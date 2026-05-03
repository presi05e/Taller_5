## 📌 Teoría: Strings y Funciones (1/3)

### ❓ ¿Qué es un String en Java y cómo se diferencia de un `char[]`?

Un **String** en Java es una clase que se usa para representar cadenas de texto (palabras o frases completas).  

Lo más importante es que los **Strings son inmutables**, es decir, una vez que creas un String, no puedes cambiar su contenido directamente. Si quieres modificarlo, Java crea un nuevo String en memoria.

En cambio, un **`char[]`** (arreglo de caracteres) es un array normal donde cada posición guarda un solo carácter. Este **sí es mutable**, puedes cambiar los valores directamente sin crear un nuevo arreglo.

**Diferencias principales:**
- **String**: Más fácil de usar, trae muchos métodos útiles, pero consume más memoria cuando se modifica frecuentemente.
- **`char[]`**: Más básico y eficiente a bajo nivel, pero no tiene métodos listos, hay que manejarlo manualmente.

---

### ❓ ¿Qué métodos de String usamos en el taller? Explica `split()`, `toLowerCase()`, `charAt()` y `length()`

Durante el taller utilizamos varios métodos importantes de la clase String:

- **`length()`**: Devuelve la cantidad de caracteres que tiene el String.  
  Ejemplo: `"Hola".length()` → `4`

- **`charAt(int índice)`**: Retorna el carácter que está en una posición específica (los índices empiezan en 0).  
  Ejemplo: `"Hola".charAt(1)` → `'o'`

- **`toLowerCase()`**: Convierte todo el texto a minúsculas. Muy útil para comparar textos ignorando mayúsculas/minúsculas.  
  Ejemplo: `"Hola Mundo".toLowerCase()` → `"hola mundo"`

- **`split(String delimitador)`**: Divide el String en partes según un separador y devuelve un arreglo de Strings.  
  Ejemplo: `"Juan,Pedro,María".split(",")` → `["Juan", "Pedro", "María"]`

Estos métodos nos ayudaron mucho a trabajar de forma más fácil con el texto en el taller.

---

## 📌 Teoría: Strings y Funciones (2/3)

### ❓ ¿Qué es un método en Java? ¿Cuál es la diferencia entre un método `void` y uno con tipo de retorno?

Un **método** en Java es un bloque de código que realiza una tarea específica. Nos permite reutilizar código fácilmente. Todo método tiene nombre, paréntesis y llaves.

**Diferencias:**

- **Método `void`**: No devuelve ningún valor. Solo hace una acción (imprimir, modificar, etc.).  
  Ejemplo:
  ```java
  public void saludar() {
      System.out.println("Hola");
  }

### ❓ ¿Qué es el paso por valor en Java y cómo afecta a los arreglos?

En Java todo se pasa por valor. Esto significa que cuando pasamos una variable a un método, se envía una copia.

- Con variables primitivas (int, double, char, boolean...): se copia el valor. Si lo cambias dentro del método, la variable original no se modifica.
Con arreglos (y objetos): se copia la referencia (la dirección en memoria). Por eso, aunque técnicamente es paso por valor, sí podemos modificar el contenido del arreglo desde dentro del método.

En el taller esto nos sirvió bastante porque podíamos alterar arreglos sin necesidad de retornarlos.

## 📌 Teoría: Strings y Funciones (3/3)

### ❓ ¿Qué es StringBuilder y cómo se diferencia de un arreglo normal?

- StringBuilder es una clase que permite crear y modificar cadenas de texto de manera eficiente. A diferencia del String normal (que es inmutable), con StringBuilder podemos cambiar el texto sin crear nuevos objetos cada vez.
Diferencia con un arreglo normal (char[]):

- StringBuilder tiene métodos muy útiles como append(), insert(), delete(), reverse(), etc.
Un char[] es más básico: solo puedes acceder y modificar por índice manualmente.
StringBuilder maneja automáticamente el tamaño y es mucho más cómodo de usar.

### ❓ ¿Qué es la sobrecarga de métodos? ¿Pudimos usarla en el taller? Da un ejemplo
La sobrecarga de métodos (overloading) es tener varios métodos con el mismo nombre, pero con diferente número o tipo de parámetros.
Sí, pudimos usarla (o al menos entender su utilidad) en el taller.
Ejemplo sencillo: 
```java

Javapublic void mostrar(String texto) {
    System.out.println("Texto: " + texto);
}

public void mostrar(String texto, int veces) {
    for(int i = 0; i < veces; i++) {
        System.out.println(texto);
    }
}
```

### ❓ ¿Cómo funciona Math.random() y cómo lo usaron para seleccionar palabras aleatorias?
Math.random() devuelve un número decimal aleatorio entre 0.0 (incluido) y 1.0 (excluido).
Para elegir un elemento aleatorio de un arreglo se hace lo siguiente:
```java
Javaint indice = (int)(Math.random() * palabras.length);
String palabraElegida = palabras[indice];
```
### ❓ ¿Qué es un archivo CSV y por qué es útil frente a datos hardcodeados?
Un archivo CSV (Comma Separated Values) es un archivo de texto plano donde los datos están separados por comas (o punto y coma). Cada línea representa un registro.
Ejemplo de contenido:
```java
textmanzana,roja,15
banana,amarilla,20
uva,morada,30
```

## 📌 LINKS DE LA INFORMACIÓN:
- Documentación oficial de Java - Clase String (la más importante)
https://docs.oracle.com/javase/8/docs/api/java/lang/String.html
- Tutorial oficial de Oracle - Manipulating Strings (muy bueno para métodos como charAt, length, toLowerCase, split)
https://docs.oracle.com/javase/tutorial/java/data/manipstrings.html
- Tutorial oficial - Strings en Java
https://docs.oracle.com/javase/tutorial/java/data/strings.html
- StringBuilder (comparación con String)
https://docs.oracle.com/javase/8/docs/api/java/lang/StringBuilder.html
- Métodos en Java (void vs return)
https://www.geeksforgeeks.org/java/difference-between-void-and-non-void-methods-in-java/
- Paso por valor en Java y arreglos
https://stackoverflow.com/questions/12757841/are-arrays-passed-by-value-or-passed-by-reference-in-java
- Sobrecarga de métodos (Method Overloading)
https://www.geeksforgeeks.org/java/method-overloading-in-java/
Math.random() y selección aleatoria
https://www.baeldung.com/java-random-list-element
- Archivos CSV - Explicación general
https://davemabe.com/what-is-the-csv-format-and-why-is-it-useful
