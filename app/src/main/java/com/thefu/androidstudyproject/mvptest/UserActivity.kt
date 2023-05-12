package com.thefu.androidstudyproject.mvptest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.thefu.androidstudyproject.R

class UserActivity : AppCompatActivity(), UserView {
    private lateinit var presenter: UserPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        presenter = UserPresenter(this, UserRepositoryImpl())
    }

    override fun onResume() {
        super.onResume()
        //在activity声明周期中合适的时机调用Presenter的方法
        val userId = ""//该位置userid应该从何时的位置拿到，比如在onCreate方法中获取
        presenter.loadUser(userId)
    }

    override fun showUser(user: User) {
        //更新UI显示用户信息
    }

    override fun showError(message: String) {
        //显示错误信息
    }
}