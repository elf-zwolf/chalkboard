package com.usechalkboard.birthdays.domain.repo

import com.usechalkboard.birthdays.domain.entity.Results
import retrofit2.http.GET

interface ServerApi {
    @GET("?results=200&seed=chalkboard&inc=name,dob")
    suspend fun load(): Results
}

class PeopleRemoteRepository(private val serverApi: ServerApi): PeopleRepository {
    override suspend fun loadPeople(): Result<Results> =
        try {
            Result.success(serverApi.load())
        } catch (throwable: Throwable) {
            Result.failure(throwable)
        }
}