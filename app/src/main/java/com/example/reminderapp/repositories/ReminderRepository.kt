package com.example.reminderapp.repositories

import android.content.Context
import com.example.reminderapp.Reminder
import com.example.reminderapp.ReminderRoomDatabase
import com.example.reminderapp.dao.ReminderDao

class ReminderRepository (context: Context){
    private var reminderDao: ReminderDao?

    init {
        val reminderRoomDatabase = ReminderRoomDatabase.getReminderRoomDatabse(context)
        reminderDao = reminderRoomDatabase?.reminderDao()
    }

    suspend fun getAllReminders(): List<Reminder> {
        return reminderDao?.getAllReminders() ?: emptyList()
    }

    suspend fun insertReminder(reminder: Reminder) {
        reminderDao?.insertReminder(reminder)
    }

    suspend fun deleteReminder(reminder: Reminder) {
        reminderDao?.deleteReminder(reminder)
    }

    suspend fun updateReminder(reminder: Reminder) {
        reminderDao?.updateReminder(reminder)
    }


}