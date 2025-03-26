
 
 ## Introducción
 
 En Kotlin, las variables son esenciales para almacenar información y operar con ella dentro de un programa. Podemos pensar en ellas como cajas donde guardamos datos con un nombre específico. Cada variable tiene un tipo de dato que define qué clase de valores puede contener.
 
 Principales Tipos de Datos en Kotlin
 
 Int: Representa números enteros como 5, 100, -20.
 
 Double: Se usa para números decimales de alta precisión como 3.14 o 2.71828.
 
 Float: Similar a Double, pero con menor precisión.
 
 Boolean: Solo puede almacenar true o false, usado para valores lógicos.
 
 Char: Almacena un único carácter, como 'A', '?' o '9'.
 
 String: Representa cadenas de texto, como "Hola Mundo".
 
 ## Declaración de Variables en Kotlin
 
 En Kotlin, podemos definir variables de dos formas principales:
 
 val: Define una variable inmutable, es decir, su valor no puede ser cambiado después de ser asignado.
 
 var: Define una variable mutable, permitiendo modificar su valor en el transcurso del programa.


## Codigo
fun main() {
    // Declaración de variables inmutables (val) y mutables (var)
    val nombre: String = "Carlos"
    val edad: Int = 30
    var saldoCuenta: Double = 1500.75
    var activo: Boolean = true

    println("Nombre: $nombre")
    println("Edad: $edad años")
    println("Saldo en cuenta: $$saldoCuenta")
    println("¿Está activo?: $activo")
    
    // Modificar variable mutable
    saldoCuenta += 500.25
    println("Nuevo saldo en cuenta después de ingreso: $$saldoCuenta")
    
    // Uso de Char y String
    val inicial: Char = nombre[0]
    val mensaje: String = "Hola, mi nombre es $nombre y mi saldo actual es $$saldoCuenta."
    println("Inicial del nombre: $inicial")
    println(mensaje)
    
    // Uso de condiciones con Boolean
    if (saldoCuenta > 1000) {
        println("El usuario tiene suficiente saldo.")
    } else {
        println("El usuario tiene saldo bajo.")
    }
    
    // Ejemplo de uso de listas con diferentes tipos de datos
    val listaProductos: List<String> = listOf("Laptop", "Teléfono", "Tablet")
    println("Productos disponibles: $listaProductos")
    
    // Ejemplo de uso de mapas (diccionarios)
    val preciosProductos: Map<String, Double> = mapOf(
        "Laptop" to 800.0,
        "Teléfono" to 500.0,
        "Tablet" to 300.0
    )
    println("Precios de productos: $preciosProductos")
    
    // Iteración sobre el mapa
    for ((producto, precio) in preciosProductos) {
        println("El producto $producto cuesta $$precio")
    }
}
