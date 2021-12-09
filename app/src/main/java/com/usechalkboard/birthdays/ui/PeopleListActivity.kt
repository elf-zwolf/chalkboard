package com.usechalkboard.birthdays.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.usechalkboard.birthdays.R
import com.usechalkboard.birthdays.domain.entity.Person
import org.koin.androidx.viewmodel.ext.android.viewModel

class PeopleListActivity : AppCompatActivity() {
    private val vm: PeopleListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_people_list)

        vm.screenState.observe(this, this::handleState)
        vm.users.observe(this, this::handlePeople)
    }

    private fun handlePeople(people: List<Person>) {
        val peopleList: RecyclerView = findViewById(R.id.peopleList)
        val adapter = PeopleRecyclerAdapter(people) { person ->
            DetailsActivity.start(this@PeopleListActivity, person)
        }
        peopleList.adapter = adapter
    }

    private fun handleState(state: ScreenState) {
        val activityIndicator: ProgressBar = findViewById(R.id.activityIndicator)
        when (state) {
            ScreenState.Loading -> {
                activityIndicator.isVisible = true
            }
            ScreenState.Success -> {
                activityIndicator.isVisible = false
                Toast.makeText(this, "Loaded successfully!", Toast.LENGTH_LONG).show()
            }
            ScreenState.Error -> {
                activityIndicator.isVisible = false
                Toast.makeText(this, "Could not load, sorry!", Toast.LENGTH_LONG).show()
            }
        }
    }
}