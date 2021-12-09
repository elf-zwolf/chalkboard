package com.usechalkboard.birthdays.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.usechalkboard.birthdays.R
import com.usechalkboard.birthdays.domain.entity.Person
import com.usechalkboard.birthdays.ui.PeopleRecyclerAdapter.ViewHolder
import java.time.OffsetDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

class PeopleRecyclerAdapter(private val data: List<Person>) :
    RecyclerView.Adapter<ViewHolder>() {

    val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")!!

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView
        val dateOfBirth: TextView
        val initials: TextView

        init {
            name = view.findViewById(R.id.name)
            dateOfBirth = view.findViewById(R.id.dateOfBirth)
            initials = view.findViewById(R.id.initials)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.birthday_item, parent, false)
    )


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val person = data[position]
        val personName = "${person.name.first} ${person.name.last}"
        val initials = "${person.name.first.first()}${person.name.last.first()}"

        val offsetDateTime = OffsetDateTime.parse(person.dob.date)
        val dateTimeInUTC = offsetDateTime.withOffsetSameInstant(ZoneOffset.UTC)

        holder.name.text = personName
        holder.initials.text = initials
        holder.dateOfBirth.text = dateTimeInUTC.format(formatter)
    }

    override fun getItemCount(): Int = data.size


}