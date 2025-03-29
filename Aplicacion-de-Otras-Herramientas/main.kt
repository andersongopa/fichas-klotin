import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

// Definición de la tabla 'Users' que hereda de la clase 'Table' de Exposed.
object Users : Table() {
    // Define una columna 'id' de tipo entero, que será la clave primaria y se autoincrementará.
    val id = integer("id").autoIncrement()
    // Define una columna 'name' de tipo varchar (string de longitud variable) con una longitud máxima de 50 caracteres.
    val name = varchar("name", 50)
    // Define una columna 'email' de tipo varchar con una longitud máxima de 100 caracteres.
    val email = varchar("email", 100)
    // Sobrescribe la propiedad 'primaryKey' para indicar que la columna 'id' es la clave primaria de esta tabla.
    override val primaryKey = PrimaryKey(id)
}

// La función principal 'main' es el punto de entrada de la aplicación.
fun main() {
    // Configuración de la conexión a la base de datos.
    // Se utiliza una base de datos H2 en memoria ('jdbc:h2:mem:test'), lo que significa que los datos se perderán al finalizar la ejecución.
    // Se especifica el driver de la base de datos H2 ('org.h2.Driver').
    Database.connect("jdbc:h2:mem:test", driver = "org.h2.Driver")

    // Se inicia una transacción. Todas las operaciones dentro de este bloque se ejecutarán como una unidad atómica.
    transaction {
        // Creación de la tabla 'Users' en la base de datos si aún no existe.
        SchemaUtils.create(Users)

        // Inserción de la primera fila en la tabla 'Users'.
        Users.insert {
            // Dentro de este bloque lambda, 'it' representa una instancia de InsertStatement.
            // Se asigna el valor "Juan Pérez" a la columna 'name'.
            it[name] = "Juan Pérez"
            // Se asigna el valor "juan@example.com" a la columna 'email'.
            it[email] = "juan@example.com"
            // La columna 'id' se autoincrementará, por lo que no es necesario especificar un valor.
        }

        // Inserción de la segunda fila en la tabla 'Users'.
        Users.insert {
            it[name] = "María García"
            it[email] = "maria@example.com"
        }

        // Consulta de todos los registros de la tabla 'Users'.
        println("Todos los usuarios:")
        // 'Users.selectAll()' devuelve un 'ResultRowSet' que contiene todas las filas de la tabla.
        for (user in Users.selectAll()) {
            // Se itera sobre cada fila ('ResultRow') en el 'ResultRowSet'.
            // Se accede a los valores de las columnas utilizando el operador de indexación [] y la referencia a la columna (Users.id, Users.name, Users.email).
            println("ID: ${user[Users.id]}, Nombre: ${user[Users.name]}, Email: ${user[Users.email]}")
        }

        // Consulta de registros con un filtro.
        println("\nUsuarios con nombre que contiene 'María':")
        // 'Users.select { Users.name like "%María%" }' crea una consulta que selecciona filas donde la columna 'name' contiene la cadena "María" (usando el operador 'like').
        // '.forEach' itera sobre cada 'ResultRow' devuelta por la consulta.
        Users.select { Users.name like "%María%" }.forEach {
            // Se imprime el valor de la columna 'name' para cada usuario que cumple con el filtro.
            println("Nombre: ${it[Users.name]}")
        }

        // Actualización de registros.
        // 'Users.update({ Users.name eq "Juan Pérez" })' crea una operación de actualización que afectará a las filas donde la columna 'name' es igual a "Juan Pérez" (usando el operador 'eq' para igualdad).
        val updatedRows = Users.update({ Users.name eq "Juan Pérez" }) {
            // Dentro de este bloque lambda, 'it' representa una instancia de UpdateStatement.
            // Se actualiza el valor de la columna 'email' a "nuevoemail@example.com" para las filas coincidentes.
            it[email] = "nuevoemail@example.com"
        }
        // Se imprime el número de filas que fueron actualizadas.
        println("\nFilas actualizadas: $updatedRows")

        // Eliminación de registros.
        // 'Users.deleteWhere { Users.name like "%García%" }' crea una operación de eliminación que afectará a las filas donde la columna 'name' contiene la cadena "García".
        val deletedRows = Users.deleteWhere { Users.name like "%García%" }
        // Se imprime el número de filas que fueron eliminadas.
        println("Filas eliminadas: $deletedRows")

        // Al finalizar el bloque 'transaction', si no hubo excepciones, los cambios se confirman en la base de datos (aunque en este caso, al ser en memoria, se perderán al terminar el programa). Si hubo una excepción, la transacción se revierte.
    }
}
