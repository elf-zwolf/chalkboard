package com.usechalkboard.birthdays.domain.entity

import java.io.Serializable
import java.time.OffsetDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

data class DateOfBirth(val date: String, val age: Int) : Serializable
data class PersonName(val title: String, val first: String, val last: String) : Serializable
data class Person(val name: PersonName, val dob: DateOfBirth) : Serializable
data class Info(val seed: String, val results: Int, val page: Int, val version: String)
data class Results(val results: List<Person>, val info: Info)

fun Person.name() = "${this.name.first} ${this.name.last}"
fun Person.initials() = "${this.name.first.first()}${this.name.last.first()}"
fun Person.dateOfBirth(): String {
    val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")!!
    val offsetDateTime = OffsetDateTime.parse(this.dob.date)
    val dateTimeInUTC = offsetDateTime.withOffsetSameInstant(ZoneOffset.UTC)
    return dateTimeInUTC.format(formatter)
}