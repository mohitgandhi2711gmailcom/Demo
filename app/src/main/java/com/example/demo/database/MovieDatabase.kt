package com.example.demo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.demo.helper.DataConverter
import com.example.demo.model.MovieModel
import com.example.demo.model.MovieResult

@Database(entities = [MovieModel::class, MovieResult::class], version = 1)
@TypeConverters(DataConverter::class)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {

        /**
         * Singleton prevents multiple instances of database opening at the same time.
         * */
        @Volatile
        private var INSTANCE: MovieDatabase? = null

        fun getDatabase(context: Context): MovieDatabase {
            /**
             * If the INSTANCE is not null, Then return it, If it is, Then create the database
             * */
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MovieDatabase::class.java,
                    "mvvm.db"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}