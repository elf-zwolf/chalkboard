package com.usechalkboard.birthdays.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.usechalkboard.birthdays.domain.entity.Person
import com.usechalkboard.birthdays.domain.interactor.PeopleInteractor
import kotlinx.coroutines.launch

sealed class ScreenState {
    object Loading: ScreenState()
    object Success: ScreenState()
    object Error: ScreenState()
}

class PeopleListViewModel(private val peopleInteractor: PeopleInteractor) : ViewModel() {
    private val _screenState = MutableLiveData<ScreenState>()
    private val _users = MutableLiveData<List<Person>>()

    val screenState: LiveData<ScreenState> = _screenState
    val users: LiveData<List<Person>> = _users

    init {
        _screenState.postValue(ScreenState.Loading)
        load()
    }

    private fun load() {
        viewModelScope.launch {
            val result = peopleInteractor.loadPeople()
            if (result.isSuccess) {
                _screenState.postValue(ScreenState.Success)
                result.getOrNull()?.let {
                    _users.postValue(it.results)
                }
            } else {
                _screenState.postValue(ScreenState.Error)
            }
        }
    }
}