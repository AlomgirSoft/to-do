package com.inteligenixsolutions.roomdmi.data.source

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int=0,
    val title: String? = null,
    val description: String? = null,
    val isCompleted: Boolean = false
){

    val isActive get()= !isCompleted


    val isEmpty get() = title?.isEmpty()==true || description?.isEmpty()== true



}