# Funciones de Strings y Printing en Kotlin

## Introducción
Las cadenas de texto (**Strings**) en Kotlin son secuencias de caracteres que permiten almacenar y manipular texto de manera eficiente. Kotlin proporciona una variedad de funciones para trabajar con Strings, permitiendo operaciones como concatenación, formateo, transformación y búsqueda de caracteres.

## Declaración y Uso de Strings
```kotlin
val mensaje: String = "Hola, Kotlin!"
println(mensaje)
```
En Kotlin, los Strings son inmutables, lo que significa que su valor no puede cambiar después de ser asignado.

## Operaciones Básicas con Strings
- **Concatenación:** Se puede usar el operador `+` o interpolación con `$`.
- **Longitud de un String:** `.length`
- **Acceder a un carácter específico:** `mensaje[indice]`
- **Comparación de Strings:** `==` o `.equals()`

### Ejemplo de Uso:
```kotlin
val nombre = "Carlos"
val saludo = "Hola, " + nombre + "!"
val longitud = saludo.length
println(saludo) // Imprime: Hola, Carlos!
println("Longitud del saludo: $longitud")
```

## Métodos Comunes en Strings
```kotlin
val texto = "Kotlin es Genial!"
println(texto.toUpperCase()) // Convertir a mayúsculas
println(texto.toLowerCase()) // Convertir a minúsculas
println(texto.replace("Genial", "increíble")) // Reemplazo de palabras
println(texto.contains("Kotlin")) // Verifica si contiene una palabra
```

## Impresión de Texto (Printing)
La función `println()` se usa para imprimir texto en la consola.

### Uso Avanzado de `print` y `println`
```kotlin
print("Este texto se imprimirá en la misma línea. ")
println("Este texto irá en una nueva línea.")
```

También podemos formatear Strings con `String.format()` o usando `"""` para Strings multilínea:
```kotlin
val nombre = "Ana"
val edad = 25
println("""
    Nombre: $nombre
    Edad: $edad años
""")
```




