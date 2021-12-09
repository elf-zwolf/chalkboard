package com.usechalkboard.birthdays.domain.entity

data class DateOfBirth(val date: String, val age: Int)
data class PersonName(val title: String, val first: String, val last: String)
data class Person(val name: PersonName, val dob: DateOfBirth)
data class Info(val seed: String, val results: Int, val page: Int, val version: String)
data class Results(val results: List<Person>, val info: Info)