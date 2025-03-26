# Operadores Matemáticos y Lógicos en Kotlin

## Introducción

En Kotlin, los operadores matemáticos y lógicos son fundamentales para realizar cálculos y tomar decisiones en un programa. Estos operadores permiten manipular valores numéricos y evaluar condiciones lógicas para controlar el flujo de ejecución.

Tipos de Operadores en Kotlin


### 1. Operadores Matemáticos

Los operadores matemáticos permiten realizar operaciones aritméticas con valores numéricos:

Suma (+): val suma = 10 + 5 // Resultado: 15

Resta (-): val resta = 10 - 5 // Resultado: 5

Multiplicación (*): val multiplicacion = 10 * 5 // Resultado: 50

División (/): val division = 10 / 2 // Resultado: 5

Módulo (%): val modulo = 10 % 3 // Resultado: 1


### 2. Operadores de Comparación

Se utilizan para comparar valores y devuelven un resultado booleano (true o false):

Mayor que (>): val resultado = 10 > 5 // true

Menor que (<): val resultado = 10 < 5 // false

Mayor o igual (>=): val resultado = 10 >= 10 // true

Menor o igual (<=): val resultado = 5 <= 10 // true

Igualdad (==): val resultado = 10 == 10 // true

Diferencia (!=): val resultado = 10 != 5 // true


### 3. Operadores Lógicos

Se usan para combinar expresiones booleanas:

AND (&&): val resultado = (10 > 5) && (5 < 8) // true

OR (||): val resultado = (10 > 5) || (5 > 8) // true

NOT (!): val resultado = !(10 > 5) // false


## Codigo 
fun main() {

    val a = 10
    val b = 5
    val c = 3
    
    // Operaciones matemáticas
    println("Suma: ${a + b}")
    println("Resta: ${a - b}")
    println("Multiplicación: ${a * c}")
    println("División: ${a / c}")
    println("Módulo: ${a % c}")
    
    // Comparaciones
    println("¿a es mayor que b? ${a > b}")
    println("¿b es igual a c? ${b == c}")
    
    // Operadores lógicos
    val condicion1 = (a > b)
    val condicion2 = (b < c)
    println("AND: ${condicion1 && condicion2}")
    println("OR: ${condicion1 || condicion2}")
    println("NOT: ${!condicion1}")
}
