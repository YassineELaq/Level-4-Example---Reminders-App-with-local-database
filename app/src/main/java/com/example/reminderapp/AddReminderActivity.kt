package com.example.reminderapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_add_reminder.*
import kotlinx.android.synthetic.main.content_add_reminder.*
const val EXTRA_REMINDER = "EXTRA_REMINDER"

class AddReminderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_reminder)
        setSupportActionBar(toolbar)
        getSupportActionBar()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        fab.setOnClickListener {
            onSaveClick()
             }
        toolbar.setOnClickListener { startAddActivity() }
    }


    private fun startAddActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun onSaveClick(){
        val reminderTextSave = etAddReminder.text.toString()
        if(reminderTextSave.isNotBlank())
        {
            val reminder = Reminder(reminderTextSave)
            val resultIntent = Intent()
            resultIntent.putExtra(EXTRA_REMINDER, reminder)
            setResult(Activity.RESULT_OK,resultIntent)
            finish()
        } else{
            Toast.makeText(this, R.string.notEmpty, Toast.LENGTH_SHORT).show()
        }
    }



}
