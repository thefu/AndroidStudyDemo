package com.thefu.androidstudyproject.viewmodel

import androidx.lifecycle.ViewModel

class MainViewModel(countReserved: Int) : ViewModel() {
    var counter = countReserved
}