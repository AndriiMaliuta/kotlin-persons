package models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Person(val name:String,
                  val email: String,
                  val age: Int,
                  val gender: String,
                  val countryCode:String)
