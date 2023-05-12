package com.thefu.androidstudyproject.mvptest

interface UserRepository {
    fun getUser(userId: String): User
    fun saveUser(user: User)
}