package com.thefu.androidstudyproject.mvptest

class UserRepositoryImpl : UserRepository {
    override fun getUser(userId: String): User {
        //从数据源获取用户数据的实现逻辑
        return User(userId);
    }

    override fun saveUser(user: User) {
        //将用户数据保存到数据源的实现逻辑
    }

}