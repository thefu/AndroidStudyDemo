package com.thefu.androidstudyproject.roomTest

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(var firstName: String, var  lastName: String, var age: Int) {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}

/**
 * 这里在User的类名上使用@Entity注解，将他声明为一个实体类，然后在User类中添加一个id字段，并使用@PrimaryKey注解将它设为主键，再把autoGenerate设置为true，是的主键的值是自动生成的
 */