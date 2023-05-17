package com.thefu.androidstudyproject.roomTest

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(version = 3, entities = [User::class, Book::class])
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun bookDao(): BookDao

    companion object {

        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("create table Book(id integer primary key autoincrement not null, name text not null, pages integer not null)")
            }
        }

        val MIGRATION_2_3 = object : Migration(2, 3) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("alter table Book add column author text not null default 'unknown")
            }
        }

        private var instance: AppDatabase? = null

        @Synchronized
        fun getDataBase(context: Context): AppDatabase {
            instance?.let { return it }
            return Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "app_database").addMigrations(MIGRATION_1_2, MIGRATION_2_3).build().apply {
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

/**
 * 数据库升级：
 * 如果还在开发测试阶段，不想编写那么繁琐的数据库升级逻辑，Room提供了一个简单粗暴的办法，在构建AppDatabase实例的时候，加入一个fallbackToDestructiveMigration()方法。这样只要数据库进行了升级，
 * Room就会将当前的数据库销毁，然后再重新创建，随之而来的副作用就是之前数据库中的所有数据就全部丢失了。
 *
 * 每次数据库升级并不一定都要新增一张表，也有可能是向现有的表中添加新的列，这种抢矿只需要使用alter语句修改表结构就可以了
 *
 */