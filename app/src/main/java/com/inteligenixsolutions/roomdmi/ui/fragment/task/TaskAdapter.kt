package com.inteligenixsolutions.roomdmi.ui.fragment.task


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

import com.inteligenixsolutions.roomdmi.data.source.Task
import com.inteligenixsolutions.roomdmi.databinding.ItemTaskBinding

class TaskAdapter(val viewModel: TaskViewModel) :
    ListAdapter<Task, TaskAdapter.TaskViewHolder>(COMPARETOR) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {

        val task:Task=getItem(position)
        holder.bind(task, viewModel)
    }


    class TaskViewHolder(val binding: ItemTaskBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(task: Task, viewModel: TaskViewModel) {

                binding.apply {
                    taskAdapter = viewModel
                    taskITem = task
                    executePendingBindings()

            }

        }


        companion object {

            fun from(parent: ViewGroup): TaskViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)

                val _binding = ItemTaskBinding.inflate(layoutInflater, parent, false)
                return TaskViewHolder(_binding)

            }
        }


    }


    companion object {

        val COMPARETOR = object : DiffUtil.ItemCallback<Task>() {
            override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
                return oldItem==newItem

            }

            override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
             return oldItem.id==newItem.id
            }


        }
    }

}