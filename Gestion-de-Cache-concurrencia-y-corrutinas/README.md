#### ESTRUCTURA 1  
# MANEJO DE VARIABLES  

1. **Describa el por qué y para qué se utiliza.** 
R//La gestión de caché, en general, sirve para mejorar el rendimiento y la eficiencia de una aplicación al almacenar copias de datos a los que se accede con frecuencia. En lugar de tener que buscar o calcular los datos originales cada vez, la aplicación puede recuperarlos rápidamente desde la caché.

Cuando hablamos de concurrencia y corrutinas en el contexto de la gestión de caché, nos referimos a cómo manejar las operaciones de acceso y modificación de la caché de manera eficiente cuando múltiples partes de la aplicación (o múltiples hilos) intentan interactuar con ella al mismo tiempo.

Aquí te explico los beneficios clave:

Mejora del Rendimiento:

Reducción de la Latencia: Acceder a datos desde la memoria caché es mucho más rápido que acceder a una base de datos, un servicio de red o realizar cálculos complejos.
Aumento del Rendimiento: Al reducir el tiempo de acceso a los datos, la aplicación puede procesar más solicitudes en el mismo periodo de tiempo.
Reducción de la Carga en Recursos:

Menor Carga en la Base de Datos/Servicios Externos: Al servir las solicitudes desde la caché, se reduce la cantidad de peticiones que llegan a los sistemas subyacentes, lo que puede ser crucial para la escalabilidad y la reducción de costos.
Menor Uso de CPU: Evitar cálculos repetitivos gracias a la caché libera recursos de CPU.
Mejora de la Experiencia del Usuario:

Aplicaciones más Responsivas: Los usuarios experimentan tiempos de carga más rápidos y una interacción más fluida.
¿Por qué Concurrencia y Corrutinas son Importantes en la Gestión de Caché?

En aplicaciones modernas, es común que múltiples partes del código necesiten acceder a la caché simultáneamente. Sin una gestión adecuada, esto puede llevar a problemas como:

Condiciones de Carrera: Múltiples hilos intentando leer y escribir en la caché al mismo tiempo pueden llevar a estados inconsistentes.
Sobrecarga: Si muchas solicitudes intentan acceder o actualizar la caché simultáneamente, el sistema subyacente que gestiona la caché puede verse sobrecargado.
Ineficiencia: Bloquear toda la caché para una sola operación puede ralentizar el acceso para otras partes de la aplicación.
Las corrutinas en Kotlin proporcionan una forma más eficiente y ligera de manejar la concurrencia en comparación con los hilos tradicionales. Permiten escribir código asíncrono que parece síncrono, lo que facilita la gestión de operaciones de caché que pueden ser bloqueantes (por ejemplo, al cargar datos en la caché por primera vez).

2. **Genere un ejemplo internamente en el recuadro.**  
   - Utilice un editor de código para lograrlo.  
R//
import java.util.concurrent.ConcurrentHashMap

class CacheSimple<Clave, Valor> {
    private val almacenamientoCache = ConcurrentHashMap<Clave, Valor>()

    fun obtener(clave: Clave, obtenerValor: () -> Valor): Valor {
        return almacenamientoCache.getOrPut(clave) {
            println("Obteniendo valor para la clave: $clave")
            obtenerValor()
        }
    }

    fun invalidar(clave: Clave) {
        almacenamientoCache.remove(clave)
        println("Clave invalidada: $clave")
    }
}

fun main() {
    val miCache = CacheSimple<String, String>()

    fun obtenerDatos(clave: String): String {
        // Simula una operación costosa (ej., lectura de base de datos)
        Thread.sleep(500)
        return "Datos para $clave desde la fuente"
    }

    println("Primera solicitud para 'elemento1': ${miCache.obtener("elemento1") { obtenerDatos("elemento1") }}")
    println("Segunda solicitud para 'elemento1': ${miCache.obtener("elemento1") { obtenerDatos("elemento1") }}") // Se seimport java.util.concurrent.ConcurrentHashMap

class CacheSimple<Clave, Valor> {
    private val almacenamientoCache = ConcurrentHashMap<Clave, Valor>()

    fun obtener(clave: Clave, obtenerValor: () -> Valor): Valor {
        return almacenamientoCache.getOrPut(clave) {
            println("Obteniendo valor para la clave: $clave")
            obtenerValor()
        }
    }

    fun invalidar(clave: Clave) {
        almacenamientoCache.remove(clave)
        println("Clave invalidada: $clave")
    }
}

fun main() {
    val miCache = CacheSimple<String, String>()

    fun obtenerDatos(clave: String): String {
        // Simula una operación costosa (ej., lectura de base de datos)
        Thread.sleep(500)
        return "Datos para $clave desde la fuente"
    }

    println("Primera solicitud para 'elemento1': ${miCache.obtener("elemento1") { obtenerDatos("elemento1") }}")
    println("Segunda solicitud para 'elemento1': ${miCache.obtener("elemento1") { obtenerDatos("elemento1") }}") // Se servirá desde la caché

    println("Primera solicitud para 'elemento2': ${miCache.obtener("elemento2") { obtenerDatos("elemento2") }}")

    miCache.invalidar("elemento1")

    println("Tercera solicitud para 'elemento1' después de invalidar: ${miCache.obtener("elemento1") { obtenerDatos("elemento1") }}") // Se volverá a obtener
}rvirá desde la caché

    println("Primera solicitud para 'elemento2': ${miCache.obtener("elemento2") { obtenerDatos("elemento2") }}")

    miCache.invalidar("elemento1")

    println("Tercera solicitud para 'elemento1' después de invalidar: ${miCache.obtener("elemento1") { obtenerDatos("elemento1") }}") // Se volverá a obtener
}

### Escribe una nota del cómo funciona la estructura  

```kotlin


