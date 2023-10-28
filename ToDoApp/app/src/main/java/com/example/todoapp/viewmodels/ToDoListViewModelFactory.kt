package com.example.todoapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.todoapp.repository.ToDoRepository

class ToDoListViewModelFactory(private val repository: ToDoRepository): ViewModelProvider.Factory {

  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    return ToDoListViewModel(repository) as T
  }
}