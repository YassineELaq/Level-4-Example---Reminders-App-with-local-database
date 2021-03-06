package com.example.reminderapp.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.reminderapp.Reminder
import com.example.reminderapp.repositories.ReminderRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {


    private val reminderRepository = ReminderRepository(application.applicationContext)
    val reminders: LiveData<List<Reminder>> = reminderRepository.getAllReminders()
    private val ioScope = CoroutineScope(Dispatchers.IO)


    fun insertReminder(reminder: Reminder) {

        ioScope.launch {
            reminderRepository.insertReminder(reminder)
        }

    }

    fun deleteReminder(reminder: Reminder) {
        ioScope.launch {
            reminderRepository.deleteReminder(reminder)
        }
    }
}