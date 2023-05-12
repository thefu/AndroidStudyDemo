package com.thefu.androidstudyproject.mvptest

class UserPresenter(private val view: UserView, private val userRepository: UserRepository) {
    fun loadUser(userId: String) {
        try {
            val user = userRepository.getUser(userId)
            view.showUser(user)
        } catch (e: java.lang.Exception) {
            view.showError("Error loading user")
        }
    }

    fun saveUser(user: User) {
        try {
            userRepository.saveUser(user)
            view.showUser(user)
        } catch (e: java.lang.Exception) {
            view.showError("Error saving user")
        }
    }
}