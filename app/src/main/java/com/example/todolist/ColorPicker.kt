package com.example.todolist

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_color_picker.*

class ColorPicker : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_picker)
        val Tab = intent.getStringExtra("TABLE_NAME_SET")
        val Title = intent.getStringExtra("TITLE_SET")
        val Note = intent.getStringExtra("NOTE_SET")
        val StartTime = intent.getStringExtra("START_TIME")
        val EndTime = intent.getStringExtra("END_TIME")
        val Button = intent.getStringExtra("BUTTON_STATE")
        val EditState = intent.getStringExtra("EDIT_VAR")
        var ToDoActivity =  Intent(this@ColorPicker, AddTask::class.java)
        ToDoActivity.putExtra("TITLE_GET" , Title)
        ToDoActivity.putExtra("NOTE_GET" , Note)
        ToDoActivity.putExtra("TABLE_NAME",Tab)
        ToDoActivity.putExtra("START_TIME", StartTime)
        ToDoActivity.putExtra("END_TIME",EndTime)
        ToDoActivity.putExtra("SET_BUTTON_STATE",Button)
        ToDoActivity.putExtra("EDIT_VAR",EditState)
        RedBright.setOnClickListener() {
            ToDoActivity.putExtra("COLOR" , "RedBright")
            startActivity(ToDoActivity)
            finish()
        }
        Red.setOnClickListener() {
            ToDoActivity.putExtra("COLOR" , "Red")
            startActivity(ToDoActivity)
            finish()
        }
        RedDark.setOnClickListener() {
            ToDoActivity.putExtra("COLOR" , "RedDark")
            startActivity(ToDoActivity)
            finish()
        }
        OrangeBright.setOnClickListener() {
            ToDoActivity.putExtra("COLOR" , "OrangeBright")
            startActivity(ToDoActivity)
            finish()
        }
        Orange.setOnClickListener() {
            ToDoActivity.putExtra("COLOR" , "Orange")
            startActivity(ToDoActivity)
            finish()
        }
        OrangeDark.setOnClickListener() {
            ToDoActivity.putExtra("COLOR" , "OrangeDark")
            startActivity(ToDoActivity)
            finish()
        }
        YellowBright.setOnClickListener() {
            ToDoActivity.putExtra("COLOR" , "YellowBright")
            startActivity(ToDoActivity)
            finish()
        }
        Yellow.setOnClickListener() {
            ToDoActivity.putExtra("COLOR" , "Yellow")
            startActivity(ToDoActivity)
            finish()
        }
        YellowDark.setOnClickListener() {
            ToDoActivity.putExtra("COLOR" , "YellowDark")
            startActivity(ToDoActivity)
            finish()
        }
        GreenBright.setOnClickListener() {
            ToDoActivity.putExtra("COLOR" , "GreenBright")
            startActivity(ToDoActivity)
            finish()
        }
        Green.setOnClickListener() {
            ToDoActivity.putExtra("COLOR" , "Green")
            startActivity(ToDoActivity)
            finish()
        }
        GreenDark.setOnClickListener() {
            ToDoActivity.putExtra("COLOR" , "GreenDark")
            startActivity(ToDoActivity)
            finish()
        }
    }
}