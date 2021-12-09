package com.usechalkboard.birthdays

import com.usechalkboard.birthdays.domain.interactor.PeopleInteractor
import com.usechalkboard.birthdays.domain.repo.PeopleMockRepository
import com.usechalkboard.birthdays.domain.repo.PeopleRepository
import org.koin.dsl.module

val interactorsModule = module {
    single {
        PeopleInteractor(get())
    }
}

val repoModule = module {
    single<PeopleRepository> {
        PeopleMockRepository()
    }
}