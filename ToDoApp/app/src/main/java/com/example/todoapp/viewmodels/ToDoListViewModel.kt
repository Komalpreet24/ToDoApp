package com.example.todoapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.models.ToDoItem
import com.example.todoapp.repository.ToDoRepository
import kotlinx.coroutines.launch

class ToDoListViewModel(private val repository: ToDoRepository): ViewModel() {

  fun insertItem(toDoItem: ToDoItem) = viewModelScope.launch {
    repository.insertItem(toDoItem)
  }

  fun updateItem(toDoItem: ToDoItem) = viewModelScope.launch {
    repository.updateItem(toDoItem)
  }

  fun deleteItem(toDoItem: ToDoItem) = viewModelScope.launch {
    repository.deleteItem(toDoItem)
  }

  fun getAllItems() = repository.getAllItems()
}