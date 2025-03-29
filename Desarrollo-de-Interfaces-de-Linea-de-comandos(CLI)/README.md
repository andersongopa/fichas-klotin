
1. **Describa el por qué y para qué se utiliza.** 
R//El desarrollo de interfaz de línea de comando (CLI) en Kotlin se refiere a la creación de programas que interactúan con el usuario a través de la terminal o consola, procesando comandos y argumentos ingresados por el usuario para realizar diversas tareas.

Características principales de un CLI en Kotlin:
Lectura de entrada desde la terminal

Procesamiento de argumentos y parámetros

Salida formateada a la consola

Manejo de flujos de ejecución basados en comandos

2. **Genere un ejemplo internamente en el recuadro.**  
   - Utilice un editor de código para lograrlo.  
R//
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        mostrarAyuda()
        exitProcess(0)
    }

    when (args[0].lowercase()) {
        "saludar" -> saludarUsuario(args)
        "sumar" -> sumarNumeros(args)
        "--help", "-h" -> mostrarAyuda()
        else -> {
            println("Comando no reconocido: ${args[0]}")
            mostrarAyuda()
            exitProcess(1)
        }
    }
}

fun saludarUsuario(args: Array<String>) {
    if (args.size < 2) {
        println("Error: Falta el nombre para saludar")
        println("Uso: saludar <nombre>")
        exitProcess(1)
    }
    println("¡Hola, ${args[1]}!")
}

fun sumarNumeros(args: Array<String>) {
    if (args.size < 3) {
        println("Error: Se necesitan dos números para sumar")
        println("Uso: sumar <num1> <num2>")
        exitProcess(1)
    }
    
    try {
        val num1 = args[1].toInt()
        val num2 = args[2].toInt()
        println("Resultado: ${num1 + num2}")
    } catch (e: NumberFormatException) {
        println("Error: Ambos argumentos deben ser números enteros")
        exitProcess(1)
    }
}

fun mostrarAyuda() {
    println("""
        Uso: programa.kts <comando> [argumentos]
        
        Comandos disponibles:
          saludar <nombre>   - Saluda a la persona especificada
          sumar <num1> <num2> - Suma dos números enteros
          --help, -h        - Muestra esta ayuda
    """.trimIndent())
}




### Escribe una nota del cómo funciona la estructura  
R//
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    // La función `main` es el punto de entrada de la aplicación Kotlin.
    // Recibe un array de strings (`args`) que representan los argumentos de la línea de comandos.

    // Primero, se verifica si no se proporcionaron argumentos al ejecutar el programa.
    if (args.isEmpty()) {
        // Si no hay argumentos, se llama a la función `mostrarAyuda()` para mostrar las instrucciones de uso.
        mostrarAyuda()
        // Luego, se termina la ejecución del programa con un código de salida 0, indicando una terminación exitosa.
        exitProcess(0)
    }

    // Si hay argumentos, se utiliza una estructura `when` (similar a un switch en otros lenguajes)
    // para determinar qué acción realizar basándose en el primer argumento proporcionado.
    when (args[0].lowercase()) {
        // Se convierte el primer argumento a minúsculas para hacer la comparación insensible a mayúsculas.

        // Si el primer argumento es "saludar":
        "saludar" -> saludarUsuario(args) // Se llama a la función `saludarUsuario` y se le pasa el array de argumentos.

        // Si el primer argumento es "sumar":
        "sumar" -> sumarNumeros(args) // Se llama a la función `sumarNumeros` y se le pasa el array de argumentos.

        // Si el primer argumento es "--help" o "-h":
        "--help", "-h" -> mostrarAyuda() // Se llama a la función `mostrarAyuda()` para mostrar la ayuda.

        // Si el primer argumento no coincide con ninguno de los casos anteriores:
        else -> {
            // Se imprime un mensaje indicando que el comando no se reconoce, mostrando el argumento inválido.
            println("Comando no reconocido: ${args[0]}")
            // Se llama a la función `mostrarAyuda()` para recordar al usuario los comandos válidos.
            mostrarAyuda()
            // Se termina la ejecución del programa con un código de salida 1, indicando que hubo un error.
            exitProcess(1)
        }
    }
}

// Esta función se encarga de saludar al usuario.
fun saludarUsuario(args: Array<String>) {
    // Primero, se verifica si se proporcionó al menos un argumento además del comando "saludar" (es decir, el nombre).
    if (args.size < 2) {
        // Si no se proporciona un nombre, se muestra un mensaje de error indicando que falta el nombre.
        println("Error: Falta el nombre para saludar")
        // Se muestra la forma correcta de usar el comando "saludar".
        println("Uso: saludar <nombre>")
        // Se termina la ejecución del programa con un código de salida 1 debido al error.
        exitProcess(1)
    }
    // Si se proporciona un nombre (está en la posición `args[1]`), se imprime un saludo personalizado.
    println("¡Hola, ${args[1]}!")
}

// Esta función se encarga de sumar dos números proporcionados como argumentos.
fun sumarNumeros(args: Array<String>) {
    // Primero, se verifica si se proporcionaron al menos tres argumentos: el comando "sumar" y los dos números.
    if (args.size < 3) {
        // Si faltan números, se muestra un mensaje de error indicando que se necesitan dos números.
        println("Error: Se necesitan dos números para sumar")
        // Se muestra la forma correcta de usar el comando "sumar".
        println("Uso: sumar <num1> <num2>")
        // Se termina la ejecución del programa con un código de salida 1 debido al error.
        exitProcess(1)
    }

    // Se utiliza un bloque `try-catch` para manejar posibles errores al convertir los argumentos a números enteros.
    try {
        // Se intenta convertir el segundo argumento (`args[1]`) a un entero y se guarda en la variable `num1`.
        val num1 = args[1].toInt()
        // Se intenta convertir el tercer argumento (`args[2]`) a un entero y se guarda en la variable `num2`.
        val num2 = args[2].toInt()
        // Si las conversiones son exitosas, se calcula la suma y se muestra el resultado.
        println("Resultado: ${num1 + num2}")
    } catch (e: NumberFormatException) {
        // Si ocurre una excepción `NumberFormatException` (por ejemplo, si los argumentos no son números),
        // se entra en este bloque `catch`.
        println("Error: Ambos argumentos deben ser números enteros")
        // Se termina la ejecución del programa con un código de salida 1 debido al error de formato.
        exitProcess(1)
    }
}

// Esta función muestra la ayuda del programa, listando los comandos disponibles y su uso.
fun mostrarAyuda() {
    println("""
    Uso: programa.kts [argumentos]
    Comandos disponibles:
      saludar <nombre>   - Saluda a la persona especificada
      sumar <num1> <num2> - Suma dos números enteros
      --help, -h        - Muestra esta ayuda
    """.trimIndent())
    // `trimIndent()` se utiliza para eliminar el margen común de las líneas dentro del string multilínea.
}
