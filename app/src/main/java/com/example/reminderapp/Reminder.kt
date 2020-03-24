package com.example.reminderapp

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "reminderTable")
data class Reminder(
    @ColumnInfo(name = "reminderText")
    var reminderText: String,
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id")
    var id:Int? = null

): Parcelable