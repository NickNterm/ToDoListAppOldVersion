package com.example.todolist

import android.app.TimePickerDialog
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_add_task.*
import java.util.*
import java.text.SimpleDateFormat

class AddTask : AppCompatActivity() {
    var Starttime = ""
    var Endtime = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_add_task)
        super.onCreate(savedInstanceState)
        val Title = intent.getStringExtra("TITLE_GET")
        val Note = intent.getStringExtra("NOTE_GET")
        val cal = Calendar.getInstance()
        var ButtonWasPressed = 0

        if (Title != null) {
            title_of_task.setText(Title.toString())
        }
        if (Note != null) {
            note_of_task.setText(Note.toString())
        }
        val ColorPicked = intent.getStringExtra("COLOR")
        var TableName = intent.getStringExtra("TABLE_NAME")

        Starttime = intent.getStringExtra("START_TIME").toString()
        Endtime = intent.getStringExtra("END_TIME").toString()
        var id = intent.getStringExtra("ID")?.toInt() ?: -1
        var EditVar = intent.getStringExtra("EDIT_VAR")
        if (EditVar != null) {
            if (EditVar.toInt() == 1){
                CardViewDeleteButton.visibility = GONE
            }
        }
        ButtonWasPressed = intent.getStringExtra("SET_BUTTON_STATE")?.toInt() ?: 0
        if (Starttime == "null" || Starttime == "") {
            StartDate.text = SimpleDateFormat("HH:mm").format(cal.time)
        } else {
            StartDate.text = Starttime
        }
        if (Endtime == "null" || Endtime == "") {
            EndDate.text = SimpleDateFormat("HH:mm").format(cal.time)
        } else {
            EndDate.text = Endtime
        }
        var SaveColor = "Default"
        when (ColorPicked) {
            "RedBright" -> {
                SaveColor = "#f11212"
                select_color_button.setBackgroundColor(Color.parseColor("#f11212"))
            }
            "#f11212" -> {
                SaveColor = "#f11212"
                select_color_button.setBackgroundColor(Color.parseColor("#f11212"))
            }
            "Red" -> {
                SaveColor = "#c81313"
                select_color_button.setBackgroundColor(Color.parseColor("#c81313"))
            }
            "#c81313" -> {
                SaveColor = "#c81313"
                select_color_button.setBackgroundColor(Color.parseColor("#c81313"))
            }
            "RedDark" -> {
                SaveColor = "#9b0f0f"
                select_color_button.setBackgroundColor(Color.parseColor("#9b0f0f"))
            }
            "#9b0f0f" -> {
                SaveColor = "#9b0f0f"
                select_color_button.setBackgroundColor(Color.parseColor("#9b0f0f"))
            }
            "OrangeBright" -> {
                SaveColor = "#f18212"
                select_color_button.setBackgroundColor(Color.parseColor("#f18212"))
            }
            "#f18212" -> {
                SaveColor = "#f18212"
                select_color_button.setBackgroundColor(Color.parseColor("#f18212"))
            }
            "Orange" -> {
                SaveColor = "#c86e13"
                select_color_button.setBackgroundColor(Color.parseColor("#c86e13"))
            }
            "#c86e13" -> {
                SaveColor = "#c86e13"
                select_color_button.setBackgroundColor(Color.parseColor("#c86e13"))
            }
            "OrangeDark" -> {
                SaveColor = "#9b550f"
                select_color_button.setBackgroundColor(Color.parseColor("#9b550f"))
            }
            "#9b550f" -> {
                SaveColor = "#9b550f"
                select_color_button.setBackgroundColor(Color.parseColor("#9b550f"))
            }
            "YellowBright" -> {
                SaveColor = "#f1f112"
                select_color_button.setTextColor(Color.parseColor("#363131"))
                select_color_button.setBackgroundColor(Color.parseColor("#f1f112"))
            }
            "#f1f112" -> {
                SaveColor = "#f1f112"
                select_color_button.setTextColor(Color.parseColor("#363131"))
                select_color_button.setBackgroundColor(Color.parseColor("#f1f112"))
            }
            "Yellow" -> {
                SaveColor = "#c8c813"
                select_color_button.setTextColor(Color.parseColor("#363131"))
                select_color_button.setBackgroundColor(Color.parseColor("#c8c813"))
            }
            "#c8c813" -> {
                SaveColor = "#c8c813"
                select_color_button.setTextColor(Color.parseColor("#363131"))
                select_color_button.setBackgroundColor(Color.parseColor("#c8c813"))
            }
            "YellowDark" -> {
                SaveColor = "#9b9b0f"
                select_color_button.setBackgroundColor(Color.parseColor("#9b9b0f"))
            }
            "#9b9b0f" -> {
                SaveColor = "#9b9b0f"
                select_color_button.setBackgroundColor(Color.parseColor("#9b9b0f"))
            }
            "GreenBright" -> {
                SaveColor = "#82f112"
                select_color_button.setTextColor(Color.parseColor("#363131"))
                select_color_button.setBackgroundColor(Color.parseColor("#82f112"))
            }
            "GreenBright" -> {
                SaveColor = "#82f112"
                select_color_button.setTextColor(Color.parseColor("#363131"))
                select_color_button.setBackgroundColor(Color.parseColor("#82f112"))
            }
            "#82f112" -> {
                SaveColor = "#82f112"
                select_color_button.setTextColor(Color.parseColor("#363131"))
                select_color_button.setBackgroundColor(Color.parseColor("#82f112"))
            }
            "Green" -> {
                SaveColor = "#6ec813"
                select_color_button.setTextColor(Color.parseColor("#363131"))
                select_color_button.setBackgroundColor(Color.parseColor("#6ec813"))
            }
            "#6ec813" -> {
                SaveColor = "#6ec813"
                select_color_button.setTextColor(Color.parseColor("#363131"))
                select_color_button.setBackgroundColor(Color.parseColor("#6ec813"))
            }
            "GreenDark" -> {
                SaveColor = "#559b0f"
                select_color_button.setBackgroundColor(Color.parseColor("#559b0f"))
            }
            "559b0f" -> {
                SaveColor = "#559b0f"
                select_color_button.setBackgroundColor(Color.parseColor("#559b0f"))
            }

        }
        select_color_button.setOnClickListener {
            var ToDoActivity = Intent(this@AddTask, ColorPicker::class.java)
            ToDoActivity.putExtra("TABLE_NAME_SET", TableName)
            ToDoActivity.putExtra("TITLE_SET", title_of_task.getText().toString())
            ToDoActivity.putExtra("NOTE_SET", note_of_task.getText().toString())
            ToDoActivity.putExtra("START_TIME", Starttime)
            ToDoActivity.putExtra("END_TIME", Endtime)
            ToDoActivity.putExtra("BUTTON_STATE", ButtonWasPressed.toString())
            ToDoActivity.putExtra("EDIT_VAR", EditVar)

            startActivity(ToDoActivity)
        }
        save_button.setOnClickListener() {
            if (title_of_task.getText().toString().length == 0) {
                val snackBar = Snackbar.make(
                    it, "Fill Title Field",
                    Snackbar.LENGTH_SHORT
                ).setAction("Action", null)
                snackBar.setBackgroundTint(Color.rgb(46, 46, 46))
                snackBar.setTextColor(Color.WHITE)
                snackBar.show()

            } else if (SaveColor == "Default") {
                val snackBar = Snackbar.make(
                    it, "Select a color",
                    Snackbar.LENGTH_SHORT
                ).setAction("Action", null)
                snackBar.setBackgroundTint(Color.rgb(46, 46, 46))
                snackBar.setTextColor(Color.WHITE)
                snackBar.show()
            } else if (ButtonWasPressed == 0) {
                val snackBar = Snackbar.make(
                    it, "Select Time",
                    Snackbar.LENGTH_SHORT
                ).setAction("Action", null)
                snackBar.setBackgroundTint(Color.rgb(46, 46, 46))
                snackBar.setTextColor(Color.WHITE)
                snackBar.show()
            } else {
                var db = DatabaseAccess(this)
                if (TableName != null) {
                    db.DeleteItem(TableName, id.toString())
                }
                var user = TableName?.let { it1 ->
                    User(
                        it1,
                        title_of_task.text.toString(),
                        SaveColor,
                        Starttime,
                        Endtime,
                        note_of_task.text.toString()
                    )
                }

                if (user != null) {
                    db.insertData(user)
                }
                var ToDoActivity = Intent(this@AddTask, MainActivity::class.java)
                ToDoActivity.putExtra("Tabs", TableName)
                startActivity(ToDoActivity)
                finish()
            }
        }
        StartDateText.setOnClickListener {
            ButtonWasPressed = 1
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timepicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                Starttime = SimpleDateFormat("HH:mm").format(cal.time)
                StartDate.text = Starttime
                Endtime = (SimpleDateFormat("HH").format(cal.time).toInt() + 1).toString() + ":" + SimpleDateFormat("mm").format(cal.time)
                EndDate.text = Endtime
            }
            TimePickerDialog(
                this,
                timeSetListener,
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE),
                true
            ).show()
        }
        StartDate.setOnClickListener() {
            ButtonWasPressed = 1
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timepicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                Starttime = SimpleDateFormat("HH:mm").format(cal.time)
                StartDate.text = Starttime
                Endtime = (SimpleDateFormat("HH").format(cal.time).toInt() + 1).toString() + ":" + SimpleDateFormat("mm").format(cal.time)
                EndDate.text = Endtime
            }
            TimePickerDialog(
                this,
                timeSetListener,
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE),
                true
            ).show()
        }
        back_button.setOnClickListener{
            var ToDoActivity = Intent(this@AddTask, MainActivity::class.java)
            ToDoActivity.putExtra("Tabs", TableName)
            startActivity(ToDoActivity)
            finish()
        }
        EndDateText.setOnClickListener {
            ButtonWasPressed = 1
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timepicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                Endtime = SimpleDateFormat("HH:mm").format(cal.time)
                EndDate.text = Endtime
            }
            TimePickerDialog(
                this,
                timeSetListener,
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE),
                true
            ).show()
        }
        EndDate.setOnClickListener() {
            ButtonWasPressed = 1
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timepicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                Endtime = SimpleDateFormat("HH:mm").format(cal.time)
                EndDate.text = Endtime
            }
            TimePickerDialog(
                this,
                timeSetListener,
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE),
                true
            ).show()
        }
        DeleteButton.setOnClickListener{
            var db = DatabaseAccess(this)
            if (TableName != null) {
                db.DeleteItem(TableName, id.toString())
            }
            var ToDoActivity = Intent(this@AddTask, MainActivity::class.java)
            ToDoActivity.putExtra("Tabs", TableName)
            startActivity(ToDoActivity)
            finish()
        }
    }


}


