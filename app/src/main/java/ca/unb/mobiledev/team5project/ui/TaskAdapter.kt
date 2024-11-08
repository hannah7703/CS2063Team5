package mobiledev.unb.ca.roompersistencelab.ui

import android.content.Context
import android.widget.ArrayAdapter
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import ca.unb.mobiledev.team5project.R
import ca.unb.mobiledev.team5project.model.Task

class TaskAdapter(context: Context, items: List<Task>) : ArrayAdapter<Task>(
    context, 0, items) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Get the data item for this position
        val item = getItem(position)

        // Check if an existing view is being reused, otherwise inflate the view
        var currView: View
        if (convertView == null) {
            currView = LayoutInflater.from(context).inflate(R.layout.task_layout, parent, false)
        } else {
            currView = convertView
        }

        // Lookup view for data population
        val textViewName: TextView = currView.findViewById(R.id.taskTextView)

        if (item != null) {
            //  Set the text used by textViewName and textViewNum using the data object
            //  This will need to updated once the entity model has been updated
            textViewName.text = item.title
        }

        // Return the completed view to render on screen
        return currView
    }
}