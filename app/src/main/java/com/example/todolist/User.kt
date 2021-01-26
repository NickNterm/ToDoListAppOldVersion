package com.example.todolist

class User {
    var id: Int = 0
    var table: String = ""
    var title: String = ""
    var color: String = ""
    var note: String = ""
    var start: String = ""
    var end: String = ""

    constructor(table: String, title: String, color: String, start: String, end: String, note: String) {
        this.table = table
        this.title = title
        this.color = color
        this.note = note
        this.start = start
        this.end = end
    }
    constructor() {

    }
}