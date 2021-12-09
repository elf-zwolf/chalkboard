package com.usechalkboard.birthdays

import android.app.Application
import com.usechalkboard.birthdays.ui.PeopleListViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class BirthdaysApp: Application() {
    override fun onCreate() {
        super.onCreate()

        val vmModule = module {
            viewModel {
                PeopleListViewModel(get())
            }
        }

        startKoin {
            androidContext(this@BirthdaysApp)
            modules(vmModule + interactorsModule + repoModule)
        }
    }
}