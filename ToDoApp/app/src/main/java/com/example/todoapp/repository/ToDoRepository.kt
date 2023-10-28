package com.example.todoapp.repository

import com.example.todoapp.db.ToDoItemDatabase
import com.example.todoapp.models.ToDoItem

class ToDoRepository(private val db: ToDoItemDatabase) {

  suspend fun insertItem(toDoItem: ToDoItem) = db.getToDoItemDao().insertToDoItem(toDoItem)
  suspend fun updateItem(toDoItem: ToDoItem) = db.getToDoItemDao().updateToDoItem(toDoItem)
  suspend fun deleteItem(toDoItem: ToDoItem) = db.getToDoItemDao().deleteToDoItem(toDoItem)
  fun getAllItems() = db.getToDoItemDao().getAllItems()

}