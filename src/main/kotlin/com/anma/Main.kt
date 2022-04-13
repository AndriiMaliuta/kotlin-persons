package com.anma

import com.anma.db.DBExe
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonArray

import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*
import models.Person


fun main(args: Array<String>) {
    val start = System.currentTimeMillis()

    // ==========
    val db = DBExe()
    val gson: Gson = GsonBuilder().create()
//    val obj = JsonArray()
    val persons = ArrayList<Person>()

    db.allPersons().forEach {
        persons.add(it)
    }
//    println(obj)

    //==

    val app = Javalin.create { config ->
        config.enableCorsForAllOrigins()
        config.asyncRequestTimeout = 10_000L
        config.enforceSsl = true
    }
//      .routes {
//      path("users") {
//         get("/persons")
//         post(UserController::create)
//         path("{userId}") {
//            get(UserController::getOne)
//            patch(UserController::update)
//            delete(UserController::delete)
//         }
//         ws("events", userController::webSocketEvents)
//      }
//   }.start(8088)
    app.get("/persons") { ctx ->
        ctx.contentType("application/json")
            .json(persons)
            .status(200)
    }
    app.start(8088)

    //==========
    println(System.currentTimeMillis() - start)
}