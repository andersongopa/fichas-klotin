# Programación Orientada a Objetos en Kotlin

## Introducción
La Programación Orientada a Objetos (POO) en Kotlin permite organizar el código en clases y objetos, promoviendo la reutilización y mantenimiento del software. En este documento exploraremos conceptos clave como clases, herencia, encapsulación, polimorfismo y más.

## Clases y Objetos
En Kotlin, las clases se definen con la palabra clave `class`. Para crear una instancia de una clase, usamos el operador `()`.

```kotlin
class Persona(val nombre: String, val edad: Int) {
    fun presentarse() {
        println("Hola, mi nombre es $nombre y tengo $edad años.")
    }
}

fun main() {
    val persona = Persona("Juan", 25)
    persona.presentarse()
}
```

## Encapsulación
La encapsulación restringe el acceso a los datos de una clase. Kotlin utiliza `private`, `protected`, `internal` y `public` para controlar la visibilidad.

```kotlin
class CuentaBancaria(private var saldo: Double) {
    fun depositar(monto: Double) {
        saldo += monto
        println("Depósito de $$monto realizado. Saldo actual: $$saldo")
    }
    fun obtenerSaldo(): Double {
        return saldo
    }
}

fun main() {
    val cuenta = CuentaBancaria(100.0)
    cuenta.depositar(50.0)
    println("Saldo final: ${cuenta.obtenerSaldo()}")
}
```

## Herencia
La herencia permite que una clase derive de otra. En Kotlin, usamos `open` para permitir la herencia.

```kotlin
open class Animal(val nombre: String) {
    open fun hacerSonido() {
        println("El animal hace un sonido.")
    }
}

class Perro(nombre: String) : Animal(nombre) {
    override fun hacerSonido() {
        println("$nombre ladra: Guau Guau!")
    }
}

fun main() {
    val perro = Perro("Firulais")
    perro.hacerSonido()
}
```

## Polimorfismo
El polimorfismo permite que un objeto adopte múltiples formas, generalmente mediante la sobrecarga de métodos o la herencia.

```kotlin
open class Vehiculo {
    open fun acelerar() {
        println("El vehículo está acelerando")
    }
}

class Coche : Vehiculo() {
    override fun acelerar() {
        println("El coche está acelerando a 100 km/h")
    }
}

fun main() {
    val vehiculo: Vehiculo = Coche()
    vehiculo.acelerar()
}
```

## Interfaces
Las interfaces en Kotlin permiten definir métodos sin implementación que deben ser implementados por las clases que las heredan.

```kotlin
interface Volador {
    fun volar()
}

class Pajaro : Volador {
    override fun volar() {
        println("El pájaro está volando.")
    }
}

fun main() {
    val pajaro = Pajaro()
    pajaro.volar()
}
```

## Ejemplo Completo
Este ejemplo combina clases, herencia y polimorfismo.

```kotlin
abstract class Empleado(val nombre: String, val salario: Double) {
    abstract fun calcularBono(): Double
}

class Gerente(nombre: String, salario: Double) : Empleado(nombre, salario) {
    override fun calcularBono(): Double {
        return salario * 0.2
    }
}

class Desarrollador(nombre: String, salario: Double) : Empleado(nombre, salario) {
    override fun calcularBono(): Double {
        return salario * 0.1
    }
}

fun main() {
    val empleados = listOf(
        Gerente("Carlos", 5000.0),
        Desarrollador("Ana", 3000.0)
    )
    
    empleados.forEach {
        println("${it.nombre} recibe un bono de ${it.calcularBono()}")
    }
}
```
