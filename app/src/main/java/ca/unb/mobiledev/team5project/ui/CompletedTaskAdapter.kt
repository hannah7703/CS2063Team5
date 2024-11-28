package ca.unb.mobiledev.team5project.ui

import android.app.Activity
import android.util.Log
import ca.unb.mobiledev.team5project.R
import ca.unb.mobiledev.team5project.model.Task

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CompletedTaskAdapter(private val viewModel: TaskViewModel, private val mList: List<Task>) : RecyclerView.Adapter<CompletedTaskAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.completed_task_layout, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val task = mList[position]
        holder.checkBox.text = task.title

        holder.checkBox.setOnClickListener {
            viewModel?.completeTask(task.title!!, holder.checkBox.isChecked)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(taskView: View) : RecyclerView.ViewHolder(taskView) {
        val checkBox: CheckBox = itemView.findViewById(R.id.taskCheckBox)
    }
}
