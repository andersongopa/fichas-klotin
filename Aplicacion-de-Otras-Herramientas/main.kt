import java.io.File
import java.io.IOException

fun main() {
    val nombreArchivo = "miarchivo.txt"
    val contenido = "Hola, mundo! Esto es un ejemplo de manejo de archivos en Kotlin."

    // 1. Escritura de un archivo
    // Se crea un archivo y se escribe contenido en él.
    try {
        File(nombreArchivo).writeText(contenido)
        println("Archivo '$nombreArchivo' escrito correctamente.")
    } catch (e: IOException) {
        println("Error al escribir el archivo: ${e.message}")
    }

    // 2. Lectura de un archivo
    // Se verifica si el archivo existe antes de leer su contenido.
    try {
        val archivo = File(nombreArchivo)
        if (archivo.exists()) {
            val contenidoLeido = archivo.readText()
            println("Contenido del archivo '$nombreArchivo':\n$contenidoLeido")
        } else {
            println("El archivo '$nombreArchivo' no existe.")
        }
    } catch (e: IOException) {
        println("Error al leer el archivo: ${e.message}")
    }

    // 3. Agregar contenido a un archivo existente
    // Se añade una línea adicional al archivo sin sobrescribir el contenido previo.
    try {
        File(nombreArchivo).appendText("\nEsta es una línea adicional.")
        println("Contenido agregado al archivo '$nombreArchivo'.")
    } catch (e: IOException) {
        println("Error al agregar contenido al archivo: ${e.message}")
    }

    // 4. Leer el archivo línea por línea (usando useLines)
    // Se usa useLines para leer y procesar el archivo línea por línea.
    try {
        File(nombreArchivo).useLines { lines ->
            lines.forEach { linea ->
                println(linea)
            }
        }
    } catch (e: IOException) {
        println("Error al leer el archivo línea por línea: ${e.message}")
    }

    // 5. Eliminar el archivo
    // Se elimina el archivo después de haberlo utilizado.
    try {
        File(nombreArchivo).delete()
        println("Archivo '$nombreArchivo' eliminado.")
    } catch (e: IOException) {
        println("Error al eliminar el archivo: ${e.message}")
    }
}
