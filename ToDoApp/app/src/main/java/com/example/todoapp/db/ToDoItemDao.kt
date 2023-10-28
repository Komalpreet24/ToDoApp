package com.example.todoapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todoapp.models.ToDoItem

@Dao
interface ToDoItemDao {

  @Insert
  suspend fun insertToDoItem(toDoItem: ToDoItem)

  @Update
  suspend fun updateToDoItem(toDoItem: ToDoItem)

  @Delete
  suspend fun deleteToDoItem(toDoItem: ToDoItem)

  @Query("SELECT * FROM to_do_items")
  fun getAllItems(): LiveData<List<ToDoItem>>

}