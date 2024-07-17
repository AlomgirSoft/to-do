package com.inteligenixsolutions.roomdmi.ui.fragment.task

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.inteligenixsolutions.roomdmi.data.source.Task


@BindingAdapter("app:items")
fun setItem(recyclerView: RecyclerView, items: List<Task?>?) {
    items?.let {
        (recyclerView.adapter as? TaskAdapter)?.submitList(it)
    } ?: run {
        // Handle the null case if necessary, e.g., clear the adapter's list
        (recyclerView.adapter as? TaskAdapter)?.submitList(emptyList())
    }
}
