import com.anma.db.DBExe
import models.Person
import models.PropsConfig
import java.sql.*
import java.util.*

fun main(args: Array<String>) {

   DBExe().allPersons().forEach { println(it) }
}