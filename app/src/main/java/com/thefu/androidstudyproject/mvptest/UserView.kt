package com.thefu.androidstudyproject.mvptest

interface UserView {
    fun showUser(user: User)
    fun showError(message: String)
}