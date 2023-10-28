package com.example.todoapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapp.R
import com.example.todoapp.databinding.FragmentTodoListBinding
import com.example.todoapp.models.ToDoItem
import com.example.todoapp.ui.MainActivity
import com.example.todoapp.ui.adapters.ToDoAdapter
import com.example.todoapp.viewmodels.ToDoListViewModel
import com.google.android.material.snackbar.Snackbar

class TodoListFragment : Fragment(R.layout.fragment_todo_list) {

  private lateinit var toDoAdapter: ToDoAdapter
  private lateinit var viewModel: ToDoListViewModel

  private lateinit var binding: FragmentTodoListBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    super.onCreateView(inflater, container, savedInstanceState)

    binding = FragmentTodoListBinding.inflate(inflater, container, false)

    return binding.root

  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    viewModel = (activity as MainActivity).viewModel


    binding.fabAddItem.setOnClickListener {
      findNavController().navigate(R.id.action_todoListFragment2_to_todoDetailFragment2)
    }

    setUpRecyclerView()

    viewModel.getAllItems().observe(viewLifecycleOwner) {
      toDoAdapter.submitList(it)
    }


  }

  private fun setUpRecyclerView() {
    toDoAdapter = ToDoAdapter()
    binding.rvToDoList.apply {
      adapter = toDoAdapter
      layoutManager = LinearLayoutManager(context)
    }

    toDoAdapter.onItemClick = { toDoItem ->
      val bundle = Bundle().apply {
        putSerializable("toDoItem", toDoItem)
      }
      findNavController().navigate(R.id.action_todoListFragment2_to_todoDetailFragment2, bundle)
    }

    toDoAdapter.onDeleteClick = {toDoItem ->
      viewModel.deleteItem(toDoItem)
        Snackbar.make(binding.root, "Item Deleted", Snackbar.LENGTH_LONG).apply {
          setAction("Undo") {
            viewModel.insertItem(toDoItem)
          }
          show()
        }
    }

  }

}