package com.sy.livealonewell

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLiteManager(context:Context, name:String, factory:SQLiteDatabase.CursorFactory?, version:Int) :
        SQLiteOpenHelper(context, name, factory, version) {

    //DB가 새롭게 생성될 때 실행되는 함수, 여기에 테이블 생성등을 처리한다
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE Cooking (" +
                "menu TEXT NOT NULL," +
                "time INTEGER," +
                "supplies TEXT NOT NULL," +
                "recipe TEXT NOT NULL" +
                ");")




    }

    //DB의 버전이 바뀌면 자동으로 실행, 컬럼 혹은 테이블 정보가 바뀌었을 때
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun insert(data: Cooking) {
        val db = writableDatabase
        db.execSQL(
            "INSERT INTO Cooking VALUES(" +
                    "'${data.menu}'," +
                    "${data.time}," +
                    "'${data.supplies}'," +
                    "'${data.recipe}');"
        )
        db.close()
    }

    fun getList(): List<Cooking>{
        val db = readableDatabase
        val cursor: Cursor = db.rawQuery("SELECT * FROM Cooking", null)
        val result: MutableList<Cooking> = mutableListOf()
        while(cursor.moveToNext()){
            result.add(
                Cooking(
                    cursor.getString(0),
                    cursor.getInt(1),
                    cursor.getString(2),
                    cursor.getString(3)
                )
            )
        }

        cursor.close()
        return result
    }
}