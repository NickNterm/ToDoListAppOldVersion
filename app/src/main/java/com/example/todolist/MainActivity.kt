package com.example.todolist

import Monday
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.view.View.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.monday.*
import kotlinx.android.synthetic.main.to_do_list__widget.*
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    var TabName = "Monday"
    var Mode = "Normal"
    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_main)
        super.onCreate(savedInstanceState)
        tabs.tabMode = TabLayout.MODE_SCROLLABLE
        tabs.addTab(tabs.newTab().setText("Monday"))
        tabs.addTab(tabs.newTab().setText("Tuesday"))
        tabs.addTab(tabs.newTab().setText("Wednesday"))
        tabs.addTab(tabs.newTab().setText("Thursday"))
        tabs.addTab(tabs.newTab().setText("Friday"))
        tabs.addTab(tabs.newTab().setText("Saturday"))
        tabs.addTab(tabs.newTab().setText("Sunday"))
        tabs.tabGravity = TabLayout.GRAVITY_FILL
        val adapter = MyAdapter(this, supportFragmentManager, tabs.tabCount)
        view_pager.adapter = adapter
        view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        var tabindex = 0
        var tabName = intent.getStringExtra("Tabs")
        if (tabName == null){
            val sdf = SimpleDateFormat("EEEE")
            val cal = Date()
            tabName = sdf.format(cal)
        }

        when (tabName) {
            "Monday" -> {
                tabindex = 0
            }
            "Tuesday" -> {
                tabindex = 1
            }
            "Wednesday" -> {
                tabindex = 2
            }
            "Thursday" -> {
                tabindex = 3
            }
            "Friday" -> {
                tabindex = 4
            }
            "Saturday" -> {
                tabindex = 5
            }
            "Sunday" -> {
                tabindex = 6
            }
            else -> tabindex =0
        }
        view_pager.currentItem = tabindex;
        if (tabName != null) {
            TabName = tabName
        }
        tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                view_pager.currentItem = tab.position
                TabName = tab.text.toString()
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
        /*val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)*/
        DeleteButton.setOnClickListener{
            Mode = "Delete"
            DeleteButton.visibility= INVISIBLE
            EditButton.visibility= INVISIBLE
            Cross.visibility = VISIBLE
            titleText.text = Mode
        }
        EditButton.setOnClickListener{
            Mode = "Edit"
            var data =  Bundle();//create bundle instance
            data.putString("Mode", Mode);
            Monday().setArguments(data);
            DeleteButton.visibility= INVISIBLE
            EditButton.visibility= INVISIBLE
            Cross.visibility = VISIBLE
            titleText.text = Mode
        }
        Cross.setOnClickListener{
            Mode = "Normal"
            DeleteButton.visibility= VISIBLE
            EditButton.visibility= VISIBLE
            Cross.visibility = GONE
            titleText.text = "To Do List"
        }
        add_task_button.setOnClickListener {
            var ToDoActivity = Intent(this@MainActivity, AddTask::class.java)
            ToDoActivity.putExtra("EDIT_VAR", "1")
            ToDoActivity.putExtra("TABLE_NAME", TabName)
            startActivity(ToDoActivity)
            finish()
        }
        SettingsButton.setOnClickListener{
            var ToDoActivity = Intent(this@MainActivity, SettingsActivity::class.java)
            startActivity(ToDoActivity)
        }/*
        val intent = Intent(this, NotifyService::class.java)
        intent.putExtra("NotificationText", "some text")
        val pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        val alarmManager = this.getSystemService(ALARM_SERVICE) as AlarmManager
        alarmManager[AlarmManager.RTC_WAKEUP, "X seconds in milliseconds".toLong()] = pendingIntent*/
    }
}