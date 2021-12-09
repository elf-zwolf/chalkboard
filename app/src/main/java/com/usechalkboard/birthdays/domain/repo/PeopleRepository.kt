package com.usechalkboard.birthdays.domain.repo

import com.usechalkboard.birthdays.domain.entity.Results

/**
 * SSOT for obtaining a list of people
 */
interface PeopleRepository {
    suspend fun loadPeople(): Result<Results>
}