# Loopers y Bucles en Kotlin

## Introducción
Los **loopers y bucles** en Kotlin permiten la ejecución repetitiva de bloques de código bajo ciertas condiciones. Son esenciales para la automatización, el manejo de eventos y la programación en segundo plano, especialmente en aplicaciones Android.

## Tipos de Bucles en Kotlin
### 1. `for`
Se usa para recorrer rangos y colecciones de datos.
```kotlin
for (i in 1..5) {
    println("Número: $i")
}
```
También se puede usar con índices:
```kotlin
val lista = listOf("A", "B", "C")
for ((index, valor) in lista.withIndex()) {
    println("Índice: $index, Valor: $valor")
}
```

### 2. `while`
Ejecuta un bloque de código mientras una condición sea verdadera.
```kotlin
var contador = 3
while (contador > 0) {
    println("Cuenta regresiva: $contador")
    contador--
}
```

### 3. `do-while`
Ejecuta al menos una vez el bloque de código antes de evaluar la condición.
```kotlin
var numero = 0
do {
    println("Número actual: $numero")
    numero++
} while (numero < 3)
```

## Control de Flujo en Bucles
### `break`
Finaliza el bucle completamente.
```kotlin
for (i in 1..5) {
    if (i == 3) break
    println("Valor de i: $i")
}
```

### `continue`
Salta la iteración actual y continúa con la siguiente.
```kotlin
for (i in 1..5) {
    if (i == 3) continue
    println("Valor de i: $i")
}
```

## Uso de Loopers en Kotlin
Los **loopers** permiten la ejecución continua de tareas en un hilo específico, lo que es útil en entornos Android para manejar tareas en segundo plano.

Ejemplo básico en Android:
```kotlin
import android.os.Looper
import android.os.Handler

fun iniciarLooper() {
    val handlerThread = Thread {
        Looper.prepare()
        val handler = Handler(Looper.myLooper()!!)
        handler.post {
            println("Mensaje en el looper")
        }
        Looper.loop()
    }
    handlerThread.start()
}
```

## Ejemplo Completo de Uso de Loopers y Bucles
```kotlin
fun main() {
    println("Ejemplo de bucles y loopers")

    // Uso de for
    for (i in 1..3) {
        println("Iteración: $i")
    }

    // Uso de while
    var x = 3
    while (x > 0) {
        println("Valor de x: $x")
        x--
    }

    // Uso de do-while
    var y = 0
    do {
        println("Valor de y: $y")
        y++
    } while (y < 3)

    // Uso de break y continue
    for (i in 1..5) {
        if (i == 3) break
        println("Con break, valor de i: $i")
    }

    for (i in 1..5) {
        if (i == 3) continue
        println("Con continue, valor de i: $i")
    }
}
```
