# Programación Funcional y Expresiones Lambda en Kotlin

## Introducción
Kotlin permite utilizar programación funcional para escribir código más conciso y expresivo. Con **expresiones lambda**, **funciones de orden superior** y **colecciones funcionales**, se pueden manejar datos de forma eficiente sin necesidad de estructuras de control tradicionales.

## Expresiones Lambda en Kotlin
Las expresiones lambda son funciones anónimas que pueden asignarse a variables o pasarse como argumentos a otras funciones.

```kotlin
val suma = { a: Int, b: Int -> a + b }
println(suma(3, 5)) // Imprime 8
```

También pueden utilizarse en operaciones sobre listas:

```kotlin
val numeros = listOf(1, 2, 3, 4, 5)
numeros.forEach { println(it) }
```

## Uso de Funciones de Orden Superior
Las funciones de orden superior aceptan otras funciones como parámetros o devuelven funciones.

```kotlin
fun operar(a: Int, b: Int, operacion: (Int, Int) -> Int): Int {
    return operacion(a, b)
}

val resultado = operar(4, 2) { x, y -> x * y }
println(resultado) // Imprime 8
```

## Transformaciones Funcionales en Colecciones
En lugar de usar bucles tradicionales, Kotlin proporciona funciones de alto nivel como `map`, `filter` y `reduce`.

### `map`
Aplica una función a cada elemento de la colección y devuelve una nueva lista.

```kotlin
val cuadrados = numeros.map { it * it }
println(cuadrados) // [1, 4, 9, 16, 25]
```

### `filter`
Filtra los elementos según una condición dada.

```kotlin
val pares = numeros.filter { it % 2 == 0 }
println(pares) // [2, 4]
```

### `reduce`
Reduce la lista a un solo valor acumulando los elementos.

```kotlin
val sumaTotal = numeros.reduce { acc, num -> acc + num }
println(sumaTotal) // 15
```

## Ejemplo Completo

```kotlin
fun main() {
    println("Ejemplo de programación funcional")

    // Expresión lambda
    val multiplica = { a: Int, b: Int -> a * b }
    println(multiplica(3, 4))

    // Uso de funciones de orden superior
    fun operar(a: Int, b: Int, operacion: (Int, Int) -> Int): Int {
        return operacion(a, b)
    }
    println(operar(5, 2) { x, y -> x + y })

    // Uso de map, filter y reduce
    val numeros = listOf(1, 2, 3, 4, 5)
    val filtrados = numeros.filter { it > 2 }
    val cuadrados = filtrados.map { it * it }
    val suma = cuadrados.reduce { acc, num -> acc + num }
    println("Suma de cuadrados de números mayores a 2: $suma")
}
```
