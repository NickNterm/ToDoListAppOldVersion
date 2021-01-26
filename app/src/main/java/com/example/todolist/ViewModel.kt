package com.example.todolist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class ViewModel: ViewModel() {
    private var MainString = MutableLiveData<String>()


    fun selectItem(item: String) {
        MainString.value = item
    }

}
