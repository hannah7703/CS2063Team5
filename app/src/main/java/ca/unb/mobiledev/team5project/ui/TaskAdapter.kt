package ca.unb.mobiledev.team5project.ui

import android.content.Intent
import ca.unb.mobiledev.team5project.R
import ca.unb.mobiledev.team5project.model.Task

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskAdapter(private val mList: List<Task>) : RecyclerView.Adapter<TaskAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.task_layout, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val task = mList[position]
        holder.textView.text = task.title


        holder.textView.setOnClickListener {
            // Set task to completed, update lists
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(taskView: View) : RecyclerView.ViewHolder(taskView) {
        val textView: TextView = itemView.findViewById(R.id.taskCheckBox)
    }
}
