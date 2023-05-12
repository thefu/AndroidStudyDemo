package com.thefu.androidstudyproject.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModelFactory(private val countReserved: Int) : ViewModelProvider.Factory {
    //这里可以直接创建MainViewModel，因为create()方法的执行时机和Activity的声明周期无关，所以不会产生之前提到的问题。
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(countReserved) as T
    }
}