package com.example.todolist

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.view.View
import androidx.fragment.app.FragmentActivity

val DATABASE_NAME = "ToDoDatabase"
val TABLE_MONDAY = "Monday"
val TABLE_TUESDAY = "Tuesday"
val TABLE_WEDNESDAY = "Wednesday"
val TABLE_THURSDAY = "Thursday"
val TABLE_FRIDAY = "Friday"
val TABLE_SATURDAY = "Saturday"
val TABLE_SUNDAY = "Sunday"
val COL_ID ="id"
val COL_TITLE ="Title"
val COL_COLOR ="Color"
val COL_NOTE ="Note"
val COL_DATE_START ="Start"
val COL_DATE_END ="End"

class DatabaseAccess(var context: Context): SQLiteOpenHelper(context, DATABASE_NAME,null , 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        var createTable = "CREATE TABLE " + TABLE_MONDAY +" (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                COL_TITLE + " VARCHAR(256),"+
                COL_COLOR + " VARCHAR(256),"+
                COL_NOTE + " VARCHAR(256),"+
                COL_DATE_START + " VARCHAR(256),"+
                COL_DATE_END + " VARCHAR(256))"
        db?.execSQL(createTable)
        createTable = "CREATE TABLE " + TABLE_TUESDAY +" (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                COL_TITLE + " VARCHAR(256),"+
                COL_COLOR + " VARCHAR(256),"+
                COL_NOTE + " VARCHAR(256),"+
                COL_DATE_START + " VARCHAR(256),"+
                COL_DATE_END + " VARCHAR(256))"
        db?.execSQL(createTable)
        createTable = "CREATE TABLE " + TABLE_WEDNESDAY +" (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                COL_TITLE + " VARCHAR(256),"+
                COL_COLOR + " VARCHAR(256),"+
                COL_NOTE + " VARCHAR(256),"+
                COL_DATE_START + " VARCHAR(256),"+
                COL_DATE_END + " VARCHAR(256))"
        db?.execSQL(createTable)
        createTable = "CREATE TABLE " + TABLE_THURSDAY +" (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                COL_TITLE + " VARCHAR(256),"+
                COL_COLOR + " VARCHAR(256),"+
                COL_NOTE + " VARCHAR(256),"+
                COL_DATE_START + " VARCHAR(256),"+
                COL_DATE_END + " VARCHAR(256))"
        db?.execSQL(createTable)
        createTable = "CREATE TABLE " + TABLE_FRIDAY +" (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                COL_TITLE + " VARCHAR(256),"+
                COL_COLOR + " VARCHAR(256),"+
                COL_NOTE + " VARCHAR(256),"+
                COL_DATE_START + " VARCHAR(256),"+
                COL_DATE_END + " VARCHAR(256))"
        db?.execSQL(createTable)
        createTable = "CREATE TABLE " + TABLE_SATURDAY +" (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                COL_TITLE + " VARCHAR(256),"+
                COL_COLOR + " VARCHAR(256),"+
                COL_NOTE + " VARCHAR(256),"+
                COL_DATE_START + " VARCHAR(256),"+
                COL_DATE_END + " VARCHAR(256))"
        db?.execSQL(createTable)
        createTable = "CREATE TABLE " + TABLE_SUNDAY +" (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                COL_TITLE + " VARCHAR(256),"+
                COL_COLOR + " VARCHAR(256),"+
                COL_NOTE + " VARCHAR(256),"+
                COL_DATE_START + " VARCHAR(256),"+
                COL_DATE_END + " VARCHAR(256))"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
    fun insertData(user : User){

        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_TITLE , user.title)
        cv.put(COL_COLOR , user.color)
        cv.put(COL_NOTE , user.note)
        cv.put(COL_DATE_START, user.start)
        cv.put(COL_DATE_END , user.end)
        var res = db.insert(user.table, null , cv)
    }
     fun ReadData(TableName: String) : List<ListItem>{
         val db = this.readableDatabase
         var list : List<ListItem> = ArrayList()
         val query = "Select * from $TableName"
         val result = db.rawQuery(query,null)
         if(result.moveToFirst()){
             do {
                 var Item = ListItem(result.getString(result.getColumnIndex(COL_ID)), result.getString(result.getColumnIndex(COL_TITLE)), result.getString(result.getColumnIndex(COL_COLOR)), result.getString(result.getColumnIndex(COL_NOTE)) ,result.getString(result.getColumnIndex(COL_DATE_START)),result.getString(result.getColumnIndex(COL_DATE_END)))
                 list += Item
             }while(result.moveToNext())
         }
         result.close()
         db.close()
         return list
     }
    fun DeleteAllFrom(TableName: String){
        val db = this.readableDatabase
        var query = "delete from "+ TableName
        val result = db.rawQuery(query,null)
        result.close()
        db.close()
    }
    fun DeleteItem(TableName: String,Task: String){ //,Color: String,Note: String,Start: String,End: String
        val db = this.writableDatabase
        var query = "DELETE FROM $TableName WHERE Id= '$Task'"
        db.execSQL(query)
        db.close()
    }
}