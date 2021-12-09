package com.usechalkboard.birthdays.domain.interactor

import com.usechalkboard.birthdays.domain.repo.PeopleRepository

class PeopleInteractor(private val peopleRepository: PeopleRepository) {
    suspend fun loadPeople() = peopleRepository.loadPeople()
}