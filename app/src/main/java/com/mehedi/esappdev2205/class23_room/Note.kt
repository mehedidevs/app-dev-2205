package com.mehedi.esappdev2205.class23_room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(

    @PrimaryKey(autoGenerate = true)
    var noteId: Int=0,

    var title: String,
    var time: String,
    var date: String,
    var priority: String


)
