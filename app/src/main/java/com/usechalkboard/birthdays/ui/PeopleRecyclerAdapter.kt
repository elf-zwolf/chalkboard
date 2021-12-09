package com.usechalkboard.birthdays.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.usechalkboard.birthdays.R
import com.usechalkboard.birthdays.domain.entity.Person
import com.usechalkboard.birthdays.domain.entity.dateOfBirth
import com.usechalkboard.birthdays.domain.entity.initials
import com.usechalkboard.birthdays.domain.entity.name
import com.usechalkboard.birthdays.ui.PeopleRecyclerAdapter.ViewHolder

class PeopleRecyclerAdapter(
    private val data: List<Person>,
    private val onItemClick: (Person) -> Unit
) :
    RecyclerView.Adapter<ViewHolder>() {

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

        holder.name.text = person.name()
        holder.initials.text = person.initials()
        holder.dateOfBirth.text = person.dateOfBirth()
        holder.itemView.setOnClickListener {
            onItemClick(person)
        }
    }

    override fun getItemCount(): Int = data.size


}