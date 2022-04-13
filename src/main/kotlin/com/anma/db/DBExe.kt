package com.anma.db

import models.Person
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import java.util.*

class DBExe {

    fun connect(): Optional<Connection> {
        try {
//            Class.forName("org.postgresql.Driver")
            println(System.getenv("DB_URL"))
            return Optional.of(
                DriverManager.getConnection(
                    System.getenv("DB_URL"),
                    System.getenv("DB_USER"),
                    System.getenv("DB_PASS")
                )
            )
        } catch (e: SQLException) {
            e.printStackTrace()
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }
        return Optional.empty()
    }

    fun allPersons(): List<Person> {
        val persons: MutableList<Person> = ArrayList<Person>()
        try {
            connect().get().use { connection ->
                val statement = connection.prepareStatement("select * from public.persons limit 2000")
                val resultSet = statement.executeQuery()
                while (resultSet.next()) {
                    val name = resultSet.getString("name")
                    val email = resultSet.getString("email")
                    val gender = resultSet.getString("gender")
                    val countryCode = resultSet.getString("country_code")
                    val age = resultSet.getInt("age")
                    persons.add(Person(name, email, age, gender, countryCode))
                }
            }
        } catch (e: SQLException) {
            e.printStackTrace()
        }
        return persons
    }

    fun getPersonById(id: Long): Person {

        try {
            connect().get().use { connection ->
                val statement =
                    connection.prepareStatement("select from public.persons where person_id = $id")
                val resultSet = statement.executeQuery()

                val name = resultSet.getString("name")
                val email = resultSet.getString("email")
                val gender = resultSet.getString("gender")
                val countryCode = resultSet.getString("country_code")
                val age = resultSet.getInt("age")

                return Person(name, email, age, gender, countryCode)

            }
        } catch (e: SQLException) {
            e.printStackTrace()
        }
        return Person("","",0,"","")
    }
}