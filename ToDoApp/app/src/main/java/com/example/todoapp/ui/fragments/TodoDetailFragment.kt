package com.example.todoapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.todoapp.R
import com.example.todoapp.databinding.FragmentTodoDetailBinding
import com.example.todoapp.models.ToDoItem
import com.example.todoapp.ui.MainActivity
import com.example.todoapp.viewmodels.ToDoListViewModel

class TodoDetailFragment : Fragment() {
  lateinit var binding: FragmentTodoDetailBinding
  lateinit var viewModel: ToDoListViewModel

  val args : TodoDetailFragmentArgs by navArgs()
  var toDoItem: ToDoItem? = null

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {

    binding = FragmentTodoDetailBinding.inflate(inflater, container, false)

    return binding.root
  }


  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    args.let {
      toDoItem = args.toDoItem
      binding.etTitle.setText(toDoItem?.title)
      binding.etDescription.setText(toDoItem?.description)
    }

    viewModel = (activity as MainActivity).viewModel

    binding.btnSave.setOnClickListener {

      val title = binding.etTitle.text.toString()
      val description = binding.etDescription.text.toString()

      if(isValid(title, description)) {
        if(toDoItem != null) {
          viewModel.updateItem(ToDoItem(title, description, toDoItem!!.id))
          Toast.makeText(context, "Item updated successfully", Toast.LENGTH_SHORT).show()
        }
        else {
          viewModel.insertItem(ToDoItem(title, description))
          Toast.makeText(context, "Item added successfully", Toast.LENGTH_SHORT).show()
        }
      }
      else{
        Toast.makeText(context, "Please set description and title", Toast.LENGTH_SHORT).show()
      }

    }

  }


  private fun isValid(title: String, description: String): Boolean {

    if(title.isEmpty() || description.isEmpty()) return false

    return true

  }


}