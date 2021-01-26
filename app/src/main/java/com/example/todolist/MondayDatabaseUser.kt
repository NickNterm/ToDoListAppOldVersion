package com.example.todolist

class MondayDatabaseUser {
    var id : Int = 0
    var title : String = ""
    var color : String = ""
    var start : String = ""
    var end : String = ""

    constructor(title:String, color: String, start: String, end: String){
        this.title = title
        this.color = color
        this.start = start
        this.end = end
    }

}