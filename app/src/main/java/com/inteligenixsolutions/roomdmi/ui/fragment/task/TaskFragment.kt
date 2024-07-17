package com.inteligenixsolutions.roomdmi.ui.fragment.task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController

import com.inteligenixsolutions.roomdmi.R
import com.inteligenixsolutions.roomdmi.databinding.FragmentTaskBinding


class TaskFragment : Fragment() {

    lateinit var binding: FragmentTaskBinding
    lateinit var adapter: TaskAdapter


    val taskViewModel by viewModels<TaskViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_task, container, false)



        binding.floatingActionButton.setOnClickListener {

            val navOptions = NavOptions.Builder()
                .setEnterAnim(R.anim.zoom_in) // Enter animation for the destination fragment
                //.setExitAnim(R.anim.zoom_in) // Exit animation for the current fragment
                .build()

            findNavController().navigate(R.id.action_taskFragment_to_addTaskFragment, null, navOptions)
        }




        binding.viewModel = taskViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        setAdapter()



        return binding.root


    }

    private fun setAdapter() {

        val viewModel = binding.viewModel
        if (viewModel != null) {
            adapter = TaskAdapter(viewModel)
            binding.taskRcv.adapter = adapter

        }
    }


}