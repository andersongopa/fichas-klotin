# Estructuras de Decisión, Control y Manejo de Errores en Kotlin

## Introducción
En Kotlin, el control de flujo es fundamental para definir la lógica de un programa. Existen diversas estructuras de decisión y control que permiten ejecutar diferentes acciones según condiciones específicas. Además, Kotlin proporciona mecanismos para manejar errores de manera eficiente.

## Estructuras de Decisión
Las estructuras de decisión permiten ejecutar bloques de código basados en condiciones lógicas.

### `if-else`
```kotlin
val numero = -5
if (numero > 0) {
    println("Número positivo")
} else if (numero < 0) {
    println("Número negativo")
} else {
    println("Es cero")
}
```

### `when` (Alternativa a `switch` en otros lenguajes)
```kotlin
val opcion = 2
when (opcion) {
    1 -> println("Seleccionaste la opción 1")
    2 -> println("Seleccionaste la opción 2")
    3 -> println("Seleccionaste la opción 3")
    else -> println("Opción inválida")
}
```

## Bucles y Control de Flujo
Los bucles permiten repetir una acción varias veces.

### `for`
```kotlin
for (i in 1..5) {
    println("Iteración número: $i")
}
```

### `while`
```kotlin
var contador = 3
while (contador > 0) {
    println("Contador: $contador")
    contador--
}
```

### `do-while`
```kotlin
var numero = 0
do {
    println("Número: $numero")
    numero++
} while (numero < 3)
```

### `break` y `continue`
```kotlin
for (i in 1..5) {
    if (i == 3) break
    println("Con break, valor de i: $i")
}

for (i in 1..5) {
    if (i == 3) continue
    println("Con continue, valor de i: $i")
}
```

## Manejo de Errores en Kotlin
El manejo de excepciones permite capturar y controlar errores para evitar que el programa se detenga inesperadamente.

### `try-catch`
```kotlin
try {
    val resultado = 10 / 0
    println("Resultado: $resultado")
} catch (e: ArithmeticException) {
    println("Error: División por cero no permitida")
}
```

### `try-catch-finally`
```kotlin
try {
    val lista = listOf(1, 2, 3)
    println(lista[5]) // Error: índice fuera de rango
} catch (e: IndexOutOfBoundsException) {
    println("Error: Índice fuera de los límites")
} finally {
    println("Este bloque siempre se ejecuta")
}
```

## Codigo

fun main() {
    // Estructura if-else
    val edad = 18
    if (edad >= 18) {
        println("Eres mayor de edad")
    } else {
        println("Eres menor de edad")
    }

    // Uso de when
    val dia = 3
    val nombreDia = when (dia) {
        1 -> "Lunes"
        2 -> "Martes"
        3 -> "Miércoles"
        4 -> "Jueves"
        5 -> "Viernes"
        6, 7 -> "Fin de semana"
        else -> "Día inválido"
    }
    println("Hoy es $nombreDia")

    // Uso de for
    for (i in 1..5) {
        println("Número: $i")
    }

    // Uso de while
    var contador = 3
    while (contador > 0) {
        println("Cuenta regresiva: $contador")
        contador--
    }

    // Uso de do-while
    var numero = 0
    do {
        println("Número actual: $numero")
        numero++
    } while (numero < 3)

    // Manejo de excepciones con try-catch
    try {
        val resultado = 10 / 0
        println("Resultado: $resultado")
    } catch (e: ArithmeticException) {
        println("Error: División por cero no permitida")
    }

    // Manejo de excepciones con finally
    try {
        val lista = listOf(1, 2, 3)
        println(lista[5]) // Error: índice fuera de rango
    } catch (e: IndexOutOfBoundsException) {
        println("Error: Índice fuera de los límites")
    } finally {
        println("Este bloque siempre se ejecuta")
    }
}

