package com.usechalkboard.birthdays.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.usechalkboard.birthdays.R
import com.usechalkboard.birthdays.domain.entity.Person
import com.usechalkboard.birthdays.domain.entity.initials
import com.usechalkboard.birthdays.domain.entity.name
import java.lang.IllegalArgumentException

class DetailsActivity : AppCompatActivity() {

    companion object {
        private val PARAM_PERSON = "person"

        fun start(startingContext: Context, person: Person) {
            val intent = Intent(startingContext, DetailsActivity::class.java)
            intent.putExtra(PARAM_PERSON, person)
            startingContext.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val person = intent.getSerializableExtra(PARAM_PERSON)
        val initials: TextView = findViewById(R.id.initials)
        val name: TextView = findViewById(R.id.name)
        val age: TextView = findViewById(R.id.age)
        val goBack: Button = findViewById(R.id.goBack)

        goBack.setOnClickListener {
            finish()
        }

        person?.let {
            it as Person
            initials.text = it.initials()
            name.text = it.name()
            age.text = it.dob.age.toString()
           it
        } ?: run {
            throw IllegalArgumentException("Use method start to start the activity")
        }

    }
}