package com.usechalkboard.birthdays.domain.repo

import com.usechalkboard.birthdays.domain.entity.*
import kotlinx.coroutines.delay
import java.lang.RuntimeException

class PeopleMockRepository: PeopleRepository {
    override suspend fun loadPeople(): Result<Results> {
        delay(1000)
        return if (Math.random() < 0.5) { // Flip a coin
            val results = Results(
                listOf(
                    Person(
                        PersonName(
                            "Mr",
                            "John",
                            "Doe"
                        ),
                        DateOfBirth(
                            "1946-03-03T10:34:51.447Z",
                            75
                        )
                    ),
                    Person(
                        PersonName(
                            "Miss",
                            "Pamela",
                            "Howell"
                        ),
                        DateOfBirth(
                            "1980-02-26T07:16:39.510Z",
                            41
                        )
                    )
                ),
                Info("chalkboard",
                1,
                1,
                "1.3")
            )
            Result.success(results)
        } else {
            Result.failure(RuntimeException("Next time ladies and gentlemen!"))
        }
    }
}