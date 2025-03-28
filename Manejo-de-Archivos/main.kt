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
    println("Segunda solicitud para 'elemento1': ${miCache.obtener("elemento1") { obtenerDatos("elemento1") }}") // Se servirá desde la caché

    println("Primera solicitud para 'elemento2': ${miCache.obtener("elemento2") { obtenerDatos("elemento2") }}")

    miCache.invalidar("elemento1")

    println("Tercera solicitud para 'elemento1' después de invalidar: ${miCache.obtener("elemento1") { obtenerDatos("elemento1") }}") // Se volverá a obtener
}
