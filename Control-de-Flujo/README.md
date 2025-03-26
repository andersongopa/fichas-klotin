# Control de Flujo en Kotlin

## Introducción
El control de flujo en Kotlin permite tomar decisiones y repetir acciones dentro de un programa. Kotlin proporciona diversas estructuras de control, como condicionales y bucles, para manejar la lógica del código de manera eficiente.

## Condicionales en Kotlin
Los condicionales permiten ejecutar diferentes bloques de código según una condición.

### 1. `if-else`
```kotlin
val numero = 10
if (numero > 0) {
    println("El número es positivo")
} else if (numero < 0) {
    println("El número es negativo")
} else {
    println("El número es cero")
}
```

### 2. `when` (Alternativa a `switch` en otros lenguajes)
```kotlin
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
```

## Bucles en Kotlin
Los bucles permiten repetir una acción varias veces.

### 1. `for`
```kotlin
for (i in 1..5) {
    println("Número: $i")
}
```

### 2. `while`
```kotlin
var contador = 3
while (contador > 0) {
    println("Cuenta regresiva: $contador")
    contador--
}
```

### 3. `do-while`
```kotlin
var numero = 0
do {
    println("Número: $numero")
    numero++
} while (numero < 3)
```

## Control de Flujo con `break` y `continue`
- **`break`**: Sale completamente del bucle.
- **`continue`**: Salta la iteración actual y pasa a la siguiente.

```kotlin
for (i in 1..5) {
    if (i == 3) break // Se detiene cuando i es 3
    println("Valor de i: $i")
}

for (i in 1..5) {
    if (i == 3) continue // Salta la iteración cuando i es 3
    println("Valor de i: $i")
}
```

## Codigo

fun main() {
    // Uso de if-else
    val edad = 20
    if (edad >= 18) {
        println("Eres mayor de edad")
    } else {
        println("Eres menor de edad")
    }

    // Uso de when
    val opcion = 2
    when (opcion) {
        1 -> println("Seleccionaste la opción 1")
        2 -> println("Seleccionaste la opción 2")
        3 -> println("Seleccionaste la opción 3")
        else -> println("Opción inválida")
    }

    // Uso de for
    for (i in 1..5) {
        println("Iteración número: $i")
    }

    // Uso de while
    var contador = 3
    while (contador > 0) {
        println("Contador: $contador")
        contador--
    }

    // Uso de do-while
    var numero = 0
    do {
        println("Número actual: $numero")
        numero++
    } while (numero < 3)

    // Uso de break y continue
    for (i in 1..5) {
        if (i == 3) break // Detiene el bucle cuando i es 3
        println("Con break, valor de i: $i")
    }

    for (i in 1..5) {
        if (i == 3) continue // Salta la iteración cuando i es 3
        println("Con continue, valor de i: $i")
    }
}



