
1. **Describa el por qué y para qué se utiliza.** 
R//La interoperabilidad con Java es una de las características más potentes de Kotlin, que permite:

-Llamar código Java desde Kotlin y viceversa
-Usar bibliotecas Java existentes directamente
-Integrar Kotlin en proyectos Java gradualmente
-Conversión automática de tipos y estructuras

2. **Genere un ejemplo internamente en el recuadro.**  
   - Utilice un editor de código para lograrlo.  
R//
package com.example

import java.util.*
import java.util.concurrent.ConcurrentHashMap

/**
 * Clase para gestión de usuarios con interoperabilidad Java
 */
class UserManager private constructor() {
    companion object {
        @JvmStatic
        private val instance: UserManager by lazy { UserManager() }

        /**
         * Obtiene la instancia singleton
         */
        @JvmStatic
        fun getInstance(): UserManager = instance
    }

    private val users = ConcurrentHashMap<String, User>()

    /**
     * Añade un nuevo usuario
     * @param name Nombre del usuario
     * @param email Email del usuario (opcional)
     * @return Usuario creado
     */
    @JvmOverloads
    fun addUser(name: String, email: String? = null): User {
        require(name.isNotBlank()) { "El nombre no puede estar vacío" }
        val id = UUID.randomUUID().toString()
        val user = User(id, name, email)
        users[id] = user
        return user
    }

    /**
     * Encuentra un usuario por ID
     * @param id ID del usuario a buscar
     * @return User o null si no se encuentra
     */
    fun findUser(id: String): User? {
        require(id.isNotBlank()) { "El ID no puede estar vacío" }
        return users[id]
    }

    /**
     * Obtiene todos los usuarios
     * @return Lista no modificable de usuarios
     */
    fun getAllUsers(): List<User> = Collections.unmodifiableList(users.values.toList())

    /**
     * Data class para representar un usuario
     * @property id Identificador único
     * @property name Nombre del usuario
     * @property email Email (puede ser null)
     */
    data class User(
        val id: String,
        val name: String,
        val email: String?
    ) {
        init {
            require(name.isNotBlank()) { "El nombre no puede estar vacío" }
        }

        /**
         * Método conveniente para Java
         * @param includeEmail Si se debe incluir el email en la descripción
         * @return Descripción del usuario
         */
        @JvmOverloads
        fun describe(includeEmail: Boolean = false): String {
            return if (includeEmail && email != null) {
                "$name ($email)"
            } else {
                name
            }
        }

        // Método adicional para Java (getter)
        @JvmName("getUserId") // Mejor nombre para Java
        fun getId(): String = id
    }
}

object MainApp {
    @JvmStatic
    fun main(args: Array<String>) {
        val userManager = UserManager.getInstance()

        try {
            // Añadir usuarios
            val user1 = userManager.addUser("Alice", "alice@example.com")
            val user2 = userManager.addUser("Bob") // email opcional

            // Intento inválido (debería fallar)
            // userManager.addUser("") // Esto lanzaría una excepción

            // Buscar usuario
            val foundUser = userManager.findUser(user1.id)
            foundUser?.let {
                println("Usuario encontrado: ${it.describe(true)}")
            }

            // Obtener todos los usuarios
            println("\nTodos los usuarios:")
            userManager.getAllUsers().forEach { user ->
                println("- ${user.describe()}")
            }

            // Manejo de null safety
            val nonExistent = userManager.findUser("invalid-id")
            println("\nBúsqueda de usuario inexistente: ${nonExistent?.describe() ?: "No encontrado"}")

        } catch (e: IllegalArgumentException) {
            System.err.println("Error: ${e.message}")
        }
    }
}



### EN EL LISTADO COMPARTIDO BUSQUE EL ALGORITMO QUE CORRESPONDA Y EXPLÍQUELO PASO A PASO  
- Genere el link del audio y el link de GitHub.  

🔗 **[LINK DEL AUDIO](#)**  
🔗 **[LINK CÓDIGO PROBADO POR US Y GUARDADO EN GITHUB](#)**  

---

### Escribe una nota del cómo funciona la estructura  
package com.example

import java.util.*
import java.util.concurrent.ConcurrentHashMap

/**
 * Clase para gestión de usuarios con interoperabilidad Java
 */
class UserManager private constructor() {
    companion object {
        @JvmStatic
        private val instance: UserManager by lazy { UserManager() }

        /**
         * Obtiene la instancia singleton
         */
        @JvmStatic
        fun getInstance(): UserManager = instance
    }

    private val users = ConcurrentHashMap<String, User>()

    /**
     * Añade un nuevo usuario
     * @param name Nombre del usuario
     * @param email Email del usuario (opcional)
     * @return Usuario creado
     */
    @JvmOverloads
    fun addUser(name: String, email: String? = null): User {
        require(name.isNotBlank()) { "El nombre no puede estar vacío" }
        val id = UUID.randomUUID().toString()
        val user = User(id, name, email)
        users[id] = user
        return user
    }

    /**
     * Encuentra un usuario por ID
     * @param id ID del usuario a buscar
     * @return User o null si no se encuentra
     */
    fun findUser(id: String): User? {
        require(id.isNotBlank()) { "El ID no puede estar vacío" }
        return users[id]
    }

    /**
     * Obtiene todos los usuarios
     * @return Lista no modificable de usuarios
     */
    fun getAllUsers(): List<User> = Collections.unmodifiableList(users.values.toList())

    /**
     * Data class para representar un usuario
     * @property id Identificador único
     * @property name Nombre del usuario
     * @property email Email (puede ser null)
     */
    data class User(
        val id: String,
        val name: String,
        val email: String?
    ) {
        init {
            require(name.isNotBlank()) { "El nombre no puede estar vacío" }
        }

        /**
         * Método conveniente para Java
         * @param includeEmail Si se debe incluir el email en la descripción
         * @return Descripción del usuario
         */
        @JvmOverloads
        fun describe(includeEmail: Boolean = false): String {
            return if (includeEmail && email != null) {
                "$name ($email)"
            } else {
                name
            }
        }

        // Método adicional para Java (getter)
        @JvmName("getUserId") // Mejor nombre para Java
        fun getId(): String = id
    }
}

object MainApp {
    @JvmStatic
    fun main(args: Array<String>) {
        val userManager = UserManager.getInstance()

        try {
            // Añadir usuarios
            val user1 = userManager.addUser("Alice", "alice@example.com")
            val user2 = userManager.addUser("Bob") // email opcional

            // Intento inválido (debería fallar)
            // userManager.addUser("") // Esto lanzaría una excepción

            // Buscar usuario
            val foundUser = userManager.findUser(user1.id)
            foundUser?.let {
                println("Usuario encontrado: ${it.describe(true)}")
            }

            // Obtener todos los usuarios
            println("\nTodos los usuarios:")
            userManager.getAllUsers().forEach { user ->
                println("- ${user.describe()}")
            }

            // Manejo de null safety
            val nonExistent = userManager.findUser("invalid-id")
            println("\nBúsqueda de usuario inexistente: ${nonExistent?.describe() ?: "No encontrado"}")

        } catch (e: IllegalArgumentException) {
            System.err.println("Error: ${e.message}")
        }
    }
}
