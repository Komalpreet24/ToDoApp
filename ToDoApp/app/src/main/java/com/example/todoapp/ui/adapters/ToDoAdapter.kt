package com.example.todoapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.todoapp.databinding.TodoListItemBinding
import com.example.todoapp.models.ToDoItem

class ToDoAdapter: RecyclerView.Adapter<ToDoAdapter.TodoViewHolder>() {

  private val list = mutableListOf<ToDoItem>()
  var onItemClick: ((ToDoItem) -> Unit)? = null
  var onDeleteClick: ((ToDoItem) -> Unit)? = null

  fun submitList(newData: List<ToDoItem>) {
    list.clear()
    list.addAll(newData)
    notifyDataSetChanged()
  }

  inner class TodoViewHolder(val binding: TodoListItemBinding): ViewHolder(binding.root)

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
    return TodoViewHolder(TodoListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
  }

  override fun getItemCount(): Int {
    return list.size
  }

  override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
    val toDoItem = list[position]
    holder.binding.apply {
      tvTitle.text = toDoItem.title
      tvDescription.text = toDoItem.description
      ibEdit.setOnClickListener{
        onItemClick?.invoke(toDoItem)
      }

      tbDelete.setOnClickListener{
        onDeleteClick?.invoke(toDoItem)
      }

    }
  }



}