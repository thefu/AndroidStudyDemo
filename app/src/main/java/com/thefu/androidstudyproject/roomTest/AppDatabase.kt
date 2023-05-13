package com.thefu.androidstudyproject.roomTest

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(version = 1, entities = [User::class])
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        private var instance: AppDatabase? = null

        @Synchronized
        fun getDataBase(context: Context): AppDatabase {
            instance?.let { return it }
            return Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "app_database").build().apply {
                instance = this
            }
        }

    }
}

/**
 * 在AppDatabase类的头部使用了@Database注解，并在注解中声明了数据库的版本号以及包含哪些实体类，多个实体类之间用逗号隔开即可。
 *
 * 另外，AppDatabase类必须继承自RoomDatabase类，并且一定要使用abstract关键字将它声明为抽象类，然后提供相应的抽象方法，用于获取之前编写的Dao的实例，比如这里提供的userDao方法，不过我们只需要
 * 进行方法的声明就可以了，具体的方法实现是在Room底层自动完成的
 *
 * 紧接着，我们companion object结构体中编写了一个单例模式，因为原则上全局应该只存在一份AppDatabase实例，这里使用了instance变量来缓存AppDatabase的实例，然后在getDatabase方法中判断，就是一个单例模式
 *
 * 在构建AppDatabase实例的时候，加入一个allowMainThreadQueries()方法，这样Room就允许在主线程中进行数据库操作了，这个方法建议只在测试环境下使用
 *
 */