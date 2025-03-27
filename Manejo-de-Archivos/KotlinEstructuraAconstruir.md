#### ESTRUCTURA 1  
# MANEJO DE VARIABLES  

1. **Describa el por qué y para qué se utiliza.** 
R//El manejo de archivos en Kotlin es una funcionalidad esencial
para cualquier aplicación que necesite interactuar con datos almacenados en el sistema de archivos. 
Se utiliza por diversas razones y para múltiples propósito:
-Guardar datos: Permite que las aplicaciones recuerden información importante.
-Compartir datos: Facilita el intercambio de información con otras aplicaciones.
-Trabajar con grandes cantidades de información: Ayuda a analizar y procesar datos masivos.

2. **Genere un ejemplo internamente en el recuadro.**  
   - Utilice un editor de código para lograrlo.  
R//
import java.io.File
import java.io.IOException

fun main() {
    val nombreArchivo = "miarchivo.txt"
    val contenido = "Hola, mundo! Esto es un ejemplo de manejo de archivos en Kotlin."

    // 1. Escritura de un archivo
    try {
        File(nombreArchivo).writeText(contenido)
        println("Archivo '$nombreArchivo' escrito correctamente.")
    } catch (e: IOException) {
        println("Error al escribir el archivo: ${e.message}")
    }

    // 2. Lectura de un archivo
    try {
        val archivo = File(nombreArchivo)
        if (archivo.exists()){
            val contenidoLeido = archivo.readText()
            println("Contenido del archivo '$nombreArchivo':\n$contenidoLeido")
        } else {
            println("El archivo '$nombreArchivo' no existe.")
        }

    } catch (e: IOException) {
        println("Error al leer el archivo: ${e.message}")
    }

    // 3. Agregar contenido a un archivo existente
    try {
        File(nombreArchivo).appendText("\nEsta es una línea adicional.")
        println("Contenido agregado al archivo '$nombreArchivo'.")
    } catch (e: IOException) {
        println("Error al agregar contenido al archivo: ${e.message}")
    }

    // 4. Leer el archivo línea por línea (usando useLines)
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
    try {
        File(nombreArchivo).delete()
        println("Archivo '$nombreArchivo' eliminado.")
    } catch (e: IOException) {
        println("Error al eliminar el archivo: ${e.message}")
    }
}



### EN EL LISTADO COMPARTIDO BUSQUE EL ALGORITMO QUE CORRESPONDA Y EXPLÍQUELO PASO A PASO  
- Genere el link del audio y el link de GitHub.  

🔗 **[LINK DEL AUDIO](#)**  
🔗 **[LINK CÓDIGO PROBADO POR US Y GUARDADO EN GITHUB](#)**  

---

### Escribe una nota del cómo funciona la estructura  

```kotlin
// NOTA

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

