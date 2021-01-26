package com.example.todolist

import Friday
import Monday
import Saturday
import Sunday
import Thursday
import Tuesday
import Wednesday
import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
@Suppress("DEPRECATION")
internal class MyAdapter(
    var context: Context,
    fm: FragmentManager,
    var totalTabs: Int
    ) :
    FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                Monday()
            }
            1 -> {
                Tuesday()
            }
            2 -> {
                Wednesday()
            }
            3 -> {
                Thursday()
            }
            4 -> {
                Friday()
            }
            5 -> {
                Saturday()
            }
            6 -> {
                Sunday()
            }
            else -> getItem(position)
        }
    }
    override fun getCount(): Int {
        return totalTabs
    }
}
