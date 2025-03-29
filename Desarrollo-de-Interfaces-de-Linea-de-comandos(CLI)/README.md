
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
import kotlin.system.exitProcess

/**
 * Función principal que maneja la interfaz de línea de comandos
 * @param args Argumentos recibidos desde la terminal
 */
fun main(args: Array<String>) {
    // Verificación básica de argumentos
    if (args.isEmpty()) {
        mostrarAyuda()
        exitProcess(0)  // Salida exitosa sin argumentos
    }

    // Selección del comando principal (primer argumento)
    when (args[0].lowercase()) {  // Case-insensitive para mejor UX
        "saludar" -> saludarUsuario(args)
        "sumar" -> sumarNumeros(args)
        "--help", "-h" -> mostrarAyuda()
        else -> {
            // Manejo de comandos no reconocidos
            println("Comando no reconocido: ${args[0]}")
            mostrarAyuda()
            exitProcess(1)  // Salida con código de error
        }
    }
}

/**
 * Función que maneja el comando 'saludar'
 * @param args Todos los argumentos, donde args[1] debería ser el nombre
 */
fun saludarUsuario(args: Array<String>) {
    // Validación de argumentos requeridos
    if (args.size < 2) {
        println("Error: Falta el nombre para saludar")
        println("Uso: saludar <nombre>")  // Mensaje de uso correcto
        exitProcess(1)
    }
    // Salida del resultado
    println("¡Hola, ${args[1]}!")
}

/**
 * Función que maneja el comando 'sumar'
 * @param args Todos los argumentos, donde args[1] y args[2] son los números
 */
fun sumarNumeros(args: Array<String>) {
    // Validación de cantidad de argumentos
    if (args.size < 3) {
        println("Error: Se necesitan dos números para sumar")
        println("Uso: sumar <num1> <num2>")
        exitProcess(1)
    }
    
    try {
        // Conversión y validación de tipos
        val num1 = args[1].toInt()
        val num2 = args[2].toInt()
        // Operación y muestra de resultado
        println("Resultado: ${num1 + num2}")
    } catch (e: NumberFormatException) {
        // Manejo de error de tipo
        println("Error: Ambos argumentos deben ser números enteros")
        exitProcess(1)
    }
}

/**
 * Función que muestra la ayuda de la aplicación
 * Nota: Usa texto multi-línea para mejor formato
 */
fun mostrarAyuda() {
    println("""
        Uso: programa.kts <comando> [argumentos]
        
        Comandos disponibles:
          saludar <nombre>   - Saluda a la persona especificada
          sumar <num1> <num2> - Suma dos números enteros
          --help, -h        - Muestra esta ayuda
    """.trimIndent())  // trimIndent() para mantener indentación limpia
}
