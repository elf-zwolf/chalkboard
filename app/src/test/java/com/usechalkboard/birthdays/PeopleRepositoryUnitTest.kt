package com.usechalkboard.birthdays

import com.usechalkboard.birthdays.domain.repo.PeopleMockRepository
import com.usechalkboard.birthdays.domain.repo.PeopleRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * Unit test for PeopleRepository
 */
class PeopleRepositoryUnitTest {

    private lateinit var peopleRepository: PeopleRepository

    @Before
    fun setUp() {
        peopleRepository = PeopleMockRepository()
    }

    @Test
    fun addition_isCorrect() {
        runBlocking {
            val result = peopleRepository.loadPeople()
            assertEquals(result.isSuccess, true)
            System.out.println("People repository test successful!")
        }
    }
}