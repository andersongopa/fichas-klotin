# Pruebas y Depuración en Kotlin

## Introducción
Las pruebas y la depuración son fundamentales en el desarrollo de software para garantizar la calidad del código y detectar errores antes de su implementación en producción. Kotlin soporta pruebas unitarias con JUnit y Kotest, además de herramientas de depuración para analizar el comportamiento del programa.

## Pruebas en Kotlin

### Pruebas Unitarias con JUnit
JUnit es un framework ampliamente utilizado para escribir y ejecutar pruebas en Kotlin.

#### Configuración
Para usar JUnit en Kotlin, agrega la dependencia en `build.gradle.kts`:

```kotlin
dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.7.0")
}
```

#### Ejemplo de Prueba Unitaria

```kotlin
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CalculadoraTest {
    @Test
    fun testSuma() {
        val resultado = suma(3, 5)
        assertEquals(8, resultado)
    }
}

fun suma(a: Int, b: Int) = a + b
```

### Pruebas con Kotest
Kotest proporciona una sintaxis más expresiva y opciones avanzadas para testing en Kotlin.

```kotlin
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CalculadoraKotest : StringSpec({
    "la suma de 3 y 5 debe ser 8" {
        suma(3, 5) shouldBe 8
    }
})
```

## Depuración en Kotlin

### Uso de `println` para Depuración
El método más simple para depuración es imprimir valores en la consola.

```kotlin
fun main() {
    val valor = 42
    println("El valor es: $valor")
}
```

### Uso de `debug` en IntelliJ IDEA
Kotlin permite depurar código con **puntos de interrupción** en IntelliJ IDEA:
1. Coloca un breakpoint haciendo clic en el margen izquierdo del código.
2. Ejecuta el programa en modo **Debug**.
3. Inspecciona variables y evalúa expresiones en tiempo de ejecución.

### Uso de `Logger` para Registros
Para depuración avanzada, se recomienda usar `Logger` en lugar de `println`.

```kotlin
import java.util.logging.Logger

val logger: Logger = Logger.getLogger("Depuración")

fun main() {
    logger.info("Inicio del programa")
    logger.warning("Este es un mensaje de advertencia")
    logger.severe("Mensaje de error crítico")
}
```

## Ejemplo Completo con Pruebas y Depuración

```kotlin
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import java.util.logging.Logger

val logger: Logger = Logger.getLogger("Depuración")

fun suma(a: Int, b: Int): Int {
    logger.info("Sumando $a + $b")
    return a + b
}

class Pruebas {
    @Test
    fun testSuma() {
        assertEquals(10, suma(7, 3))
    }
}

fun main() {
    val resultado = suma(4, 6)
    println("Resultado de la suma: $resultado")
}
```
