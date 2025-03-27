# Collections, JSON y Manejo de Datos en Kotlin

Este repositorio contiene ejemplos y explicaciones sobre cómo trabajar con **Collections**, **JSON** y **manejo de datos** en Kotlin.

## ¿Qué son Collections, JSON y Manejo de Datos?

### Collections (Colecciones)
Son estructuras de datos que permiten almacenar y manipular múltiples elementos de manera eficiente. Kotlin ofrece tres tipos principales de colecciones:
- **List**: Una lista ordenada de elementos (puede ser mutable o inmutable).
- **Set**: Un conjunto que no permite elementos duplicados.
- **Map**: Un diccionario clave-valor para asociar datos.

### JSON (JavaScript Object Notation)
Es un formato ligero para intercambiar datos entre sistemas. Se usa en APIs, bases de datos y configuraciones. Kotlin puede manejar JSON con librerías como `kotlinx.serialization` y `Gson`.

### Manejo de Datos
Incluye técnicas para leer, escribir y manipular datos desde diferentes fuentes, como:
- Archivos (`File` en Kotlin)
- Bases de datos (SQLite con Room)
- APIs (JSON, XML)

## Collections en Kotlin
Kotlin ofrece colecciones mutables e inmutables para almacenar y manipular datos estructurados.

### List
```kotlin
val listaInmutable = listOf("Manzana", "Banana", "Cereza") // Lista inmutable
val listaMutable = mutableListOf("Perro", "Gato", "Conejo") // Lista mutable
listaMutable.add("Pájaro") // Se puede modificar
```

### Set
```kotlin
val conjunto = setOf(1, 2, 3, 3, 4) // Eliminación automática de duplicados
val conjuntoMutable = mutableSetOf("Rojo", "Verde", "Azul")
conjuntoMutable.add("Amarillo")
```

### Map
```kotlin
val mapa = mapOf(1 to "Uno", 2 to "Dos", 3 to "Tres")
val mapaMutable = mutableMapOf("A" to 10, "B" to 20)
mapaMutable["C"] = 30 // Agrega un nuevo par clave-valor
```

## JSON en Kotlin
### Uso de kotlinx.serialization
Agregar la dependencia en `build.gradle.kts`:
```kotlin
dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
}
```
Serialización y deserialización:
```kotlin
import kotlinx.serialization.*
import kotlinx.serialization.json.*

@Serializable
data class Usuario(val nombre: String, val edad: Int)

fun main() {
    val usuario = Usuario("Carlos", 25)
    val jsonString = Json.encodeToString(usuario)
    println(jsonString)
    val usuarioObjeto = Json.decodeFromString<Usuario>(jsonString)
    println(usuarioObjeto.nombre)
}
```

### Uso de Gson
Agregar dependencia:
```kotlin
dependencies {
    implementation("com.google.code.gson:gson:2.8.8")
}
```
Serialización y deserialización con Gson:
```kotlin
import com.google.gson.Gson

data class Producto(val nombre: String, val precio: Double)

fun main() {
    val gson = Gson()
    val producto = Producto("Laptop", 1200.0)
    val json = gson.toJson(producto)
    println(json)
    val productoObjeto = gson.fromJson(json, Producto::class.java)
    println(productoObjeto.nombre)
}
```

## Manejo de Datos
### Lectura y Escritura de Archivos
Escribir en un archivo:
```kotlin
import java.io.File

fun main() {
    val archivo = File("datos.txt")
    archivo.writeText("Hola, este es un archivo de texto en Kotlin.")
}
```
Leer desde un archivo:
```kotlin
fun main() {
    val archivo = File("datos.txt")
    val contenido = archivo.readText()
    println(contenido)
}
```

### Uso de SQLite con Room
Agregar dependencias:
```kotlin
dependencies {
    implementation("androidx.room:room-runtime:2.3.0")
    kapt("androidx.room:room-compiler:2.3.0")
}
```
Definir una entidad y una base de datos:
```kotlin
import androidx.room.*

@Entity
data class Usuario(@PrimaryKey val id: Int, val nombre: String)

@Dao
interface UsuarioDao {
    @Insert
    fun insertar(usuario: Usuario)
    @Query("SELECT * FROM Usuario")
    fun obtenerUsuarios(): List<Usuario>
}

@Database(entities = [Usuario::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun usuarioDao(): UsuarioDao
}
```



