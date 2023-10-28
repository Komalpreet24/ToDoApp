package com.example.todoapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todoapp.models.ToDoItem

@Database(
  entities = [ToDoItem::class],
  version = 1
)
abstract class ToDoItemDatabase: RoomDatabase() {

  abstract fun getToDoItemDao(): ToDoItemDao;

  companion object{

    private var instance: ToDoItemDatabase? = null
    private val LOCK = Any()

    operator fun invoke(context: Context): ToDoItemDatabase{

      return instance ?: synchronized(LOCK){
        instance ?: createDatabase(context).also {
          instance = it
        }
      }

    }

    private fun createDatabase(context: Context): ToDoItemDatabase {
        return Room.databaseBuilder(
          context.applicationContext,
          ToDoItemDatabase::class.java,
          "to_do_db_db")
          .build()
    }

  }

}