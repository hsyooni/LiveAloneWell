package com.sy.livealonewell

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.sy.livealonewell.repository.MyDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

   //     val dbManager = SQLiteManager(this,"test.db", null, 1)
//        dbManager.insert(Cooking("고추장제육볶음", 20,"고기, 양파, 고추장, 파", "고기를 야채랑 고추장이랑 볶는다"))
 //       dbManager.insert(Cooking("소세지야채볶음", 20,"소시지, 양파, 파프리카, 소금, 후추", "소시지와 야채를 볶는다"))
  //      dbManager.insert(Cooking("계란말이", 20,"계란, 소금", "계란을 풀어서 팬에 두르고 말아간다"))

 //       textView.text = dbManager.getList().toString()

        val dbManager = MyDatabase.getInstance(this)

        dbManager.CookingDao.insertCooking(Cooking("김치볶음밥", 10,"김치, 양파, 당근, 밥","잘게 썬 야채와 김치와 밥을 볶는다."))
        dbManager.CookingDao.insertCooking(Cooking("짜파게티", 5, "짜파게티, 계란", "오늘은 내가 짜파게티 요리사!"))


    }
}
