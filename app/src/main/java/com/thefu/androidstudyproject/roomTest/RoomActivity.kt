package com.thefu.androidstudyproject.roomTest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.thefu.androidstudyproject.R
import kotlin.concurrent.thread

class RoomActivity : AppCompatActivity() {

    lateinit var getUserBtn: Button
    lateinit var addDataBtn: Button
    lateinit var updateDataBtn: Button
    lateinit var deleteDataBtn: Button
    lateinit var queryDataBtn: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        val userDao = AppDatabase.getDataBase(this).userDao()
        val user1 = User("tom", "brady", 20)
        val user2 = User("tom", "hanks", 30)

        getUserBtn = findViewById(R.id.getUserBtn)
        addDataBtn = findViewById(R.id.addDataBtn)
        updateDataBtn = findViewById(R.id.updateDataBtn)
        deleteDataBtn = findViewById(R.id.deleteDataBtn)
        queryDataBtn = findViewById(R.id.queryDataBtn)

        addDataBtn.setOnClickListener {
            thread {
                user1.id = userDao.insertUser(user1)
                user2.id = userDao.insertUser(user2)
            }
        }

        updateDataBtn.setOnClickListener {
            thread {
                user1.age = 40
                userDao.updateUser(user1)
            }
        }

        deleteDataBtn.setOnClickListener {
            thread {
                userDao.deleteUserByLastName("hanks")
            }
        }

        queryDataBtn.setOnClickListener {
            thread {
                for (user in userDao.loadAllUsers()) {
                    Log.d("RoomActivity", user.toString())
                }
            }
        }


    }
}