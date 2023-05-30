package com.mehedi.esappdev2205.class23_room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NoteDao {

    @Insert
    fun insertData(note: Note)

    @Update
    fun updateNote(note: Note)

    @Delete
    fun deleteNote(note: Note)

    @Query("SELECT * FROM Note")
    fun getAllNote(): List<Note>


    @Query("SELECT * FROM Note WHERE noteId IN (:id)")
    fun getNoteBYId(id: List<Int>): List<Note>


}