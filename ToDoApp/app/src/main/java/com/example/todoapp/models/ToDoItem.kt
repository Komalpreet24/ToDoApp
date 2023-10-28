package com.example.todoapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(
  tableName = "to_do_items"
)
data class ToDoItem(
  var title: String,
  var description: String,
  @PrimaryKey(autoGenerate = true)
  val id: Int = 0,
): Serializable
