package com.usechalkboard.birthdays

import com.usechalkboard.birthdays.domain.interactor.PeopleInteractor
import com.usechalkboard.birthdays.domain.repo.PeopleMockRepository
import com.usechalkboard.birthdays.domain.repo.PeopleRemoteRepository
import com.usechalkboard.birthdays.domain.repo.PeopleRepository
import com.usechalkboard.birthdays.domain.repo.ServerApi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val interactorsModule = module {
    single {
        PeopleInteractor(get())
    }
}

val repoModule = module {
    single<PeopleRepository> {
        //PeopleMockRepository()
        PeopleRemoteRepository(get())
    }

    single {
        Retrofit.Builder()
            .baseUrl("https://randomuser.me/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single {
        get<Retrofit>().create(ServerApi::class.java)
    }
}