package com.inteligenixsolutions.roomdmi.ui.fragment.add_task_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.inteligenixsolutions.roomdmi.R
import com.inteligenixsolutions.roomdmi.databinding.FragmentAddTaskBinding
import com.inteligenixsolutions.roomdmi.showSnackBar


class AddTaskFragment : Fragment() {

lateinit var binding: FragmentAddTaskBinding
val viewModel by viewModels<AddTaskViewModel> ()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_add_task, container, false)

        binding.viewModel= viewModel
        binding.lifecycleOwner=this.viewLifecycleOwner

        viewModel.navigateToTaskFragment.observe(viewLifecycleOwner) { shouldNavigate ->
            if (shouldNavigate) {
                findNavController().navigate(R.id.action_addTaskFragment_to_taskFragment)
                viewModel.doneNavigating()
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindMag(view)
    }

    private fun bindMag(view: View) {

        view.showSnackBar(viewLifecycleOwner,viewModel.snackbar,Snackbar.LENGTH_LONG)
    }

}