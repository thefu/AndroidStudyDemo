package com.thefu.androidstudyproject.viewmodel

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.thefu.androidstudyproject.R

class VmTestActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    lateinit var plusOneBtn: Button
    lateinit var clearBtn: Button
    lateinit var infoText: TextView
    lateinit var sp: SharedPreferences

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vm_test)

        sp = getPreferences(Context.MODE_PRIVATE)
        val countReserved = sp.getInt("count_reserved", 0)
        viewModel = ViewModelProvider(
            this,
            MainViewModelFactory(countReserved)
        ).get(MainViewModel::class.java)

        plusOneBtn = findViewById<Button>(R.id.plusOneBtn)
        clearBtn = findViewById<Button>(R.id.clearBtn)
        infoText = findViewById(R.id.infoText)
        plusOneBtn.setOnClickListener {
            viewModel.plusOne();
//            refreshCounter()
        }
        clearBtn.setOnClickListener {
            viewModel.clear()
//            refreshCounter()
        }

        //这样写，不用担心ViewModel的内部会不会开启线程执行耗时逻辑。不过需要注意的是，如果你需要在子线程中给LiveData设置数据，一定要调用postValue()方法，而不能使用setValue方法，否则会崩溃
        viewModel.counter.observe(this, Observer { count -> infoText.text = count.toString() })
//        refreshCounter()
    }

    override fun onPause() {
        super.onPause()
        viewModel.counter.value?.let { sp.edit().putInt("count_reserved", it) }
    }

    //这里绝对不可以直接去创建ViewModel的实例，而是一定要通过ViewModelProvider来获取ViewModel的实例
    //这里之所以要这么写，是因为ViewModel有他独立的声明周期，并且其声明周期要长于Activity。如果我们在onCreate()方法中创建ViewModel的实例，那么每次onCreate方法执行的时候，
    // ViewModel都会创建一个新的实例，这样就无法保留其中的数据了

    private fun refreshCounter() {
        infoText.text = viewModel.counter.toString()
    }

}