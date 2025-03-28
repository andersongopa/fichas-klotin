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


### Escribe una nota del cómo funciona la estructura  

```kotlin
import java.util.concurrent.ConcurrentHashMap

class CacheSimple<Clave, Valor> {
    // `almacenamientoCache` es un mapa donde guardamos los datos en memoria.
    // Usamos `ConcurrentHashMap` porque es seguro para ser accedido por múltiples hilos
    // al mismo tiempo sin causar problemas (aunque este ejemplo `main` no es concurrente).
    private val almacenamientoCache = ConcurrentHashMap<Clave, Valor>()

    /**
     * Intenta obtener un valor de la caché para la clave dada.
     * Si el valor no está en la caché, llama a la función `obtenerValor` para buscarlo,
     * guarda el resultado en la caché y luego lo devuelve.
     *
     * @param clave La clave del valor que se desea obtener.
     * @param obtenerValor Una función lambda (sin parámetros) que se llama para obtener el valor
     * si no está presente en la caché. Esta función debería realizar la
     * operación "costosa" para obtener el dato.
     * @return El valor asociado a la clave, ya sea recuperado de la caché o recién obtenido.
     */
    fun obtener(clave: Clave, obtenerValor: () -> Valor): Valor {
        // `getOrPut` es una función conveniente de los mapas de Kotlin.
        // Intenta obtener el valor para la clave. Si no existe, ejecuta la función lambda
        // proporcionada, guarda el resultado en el mapa bajo esa clave y devuelve el resultado.
        return almacenamientoCache.getOrPut(clave) {
            println("Obteniendo valor para la clave: $clave")
            // Aquí llamamos a la función `obtenerValor` para obtener el dato real
            obtenerValor()
        }
    }

    /**
     * Remueve la entrada asociada a la clave dada de la caché.
     * Esto forzará a que el valor se vuelva a obtener la próxima vez que se solicite.
     *
     * @param clave La clave de la entrada que se desea invalidar (remover).
     */
    fun invalidar(clave: Clave) {
        almacenamientoCache.remove(clave)
        println("Clave invalidada: $clave")
    }
}

fun main() {
    // Creamos una instancia de nuestra `CacheSimple` que almacenará Strings como claves y valores.
    val miCache = CacheSimple<String, String>()

    /**
     * Simula una función que va a buscar datos a una fuente (por ejemplo, una base de datos).
     * Esta función tarda un poco en ejecutarse (simulado con `Thread.sleep`).
     *
     * @param clave La clave de los datos que se quieren obtener.
     * @return Los datos asociados a la clave.
     */
    fun obtenerDatos(clave: String): String {
        println("Intentando obtener datos reales para la clave: $clave...")
        // Simula una operación que consume tiempo
        Thread.sleep(500)
        return "Datos para $clave desde la fuente"
    }

    println("Primera solicitud para 'elemento1': ${miCache.obtener("elemento1") { obtenerDatos("elemento1") }}")
    // La primera vez, "elemento1" no está en la caché, así que se llama a `obtenerDatos`.

    println("Segunda solicitud para 'elemento1': ${miCache.obtener("elemento1") { obtenerDatos("elemento1") }}")
    // La segunda vez, "elemento1" ya está en la caché, así que se devuelve directamente
    // sin llamar a `obtenerDatos` de nuevo.

    println("Primera solicitud para 'elemento2': ${miCache.obtener("elemento2") { obtenerDatos("elemento2") }}")
    // "elemento2" no está en la caché, así que se llama a `obtenerDatos`.

    miCache.invalidar("elemento1")
    // Removemos "elemento1" de la caché.

    println("Tercera solicitud para 'elemento1' después de invalidar: ${miCache.obtener("elemento1") { obtenerDatos("elemento1") }}")
    // Como "elemento1" fue invalidado, no está en la caché, y `obtenerDatos` se llama de nuevo.
}


