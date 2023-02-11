package com.example.demo.database

import android.content.Context
import androidx.room.*
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.demo.helper.DataConverter
import com.example.demo.model.MovieModel
import com.example.demo.model.MovieResult

@Database(
    entities = [MovieModel::class, MovieResult::class], version = 1,
    /*autoMigrations = [AutoMigration(from = 1, to = 2)],*/
    exportSchema = true
)
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
                )
                    /*.addMigrations(MIGRATION_1_2)*/
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }

        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                // Begin SQL transcation
                database.execSQL("BEGIN TRANSACTION;")


                // Alter, create, drop, whatever
                database.execSQL("ALTER TABLE movie_results ADD COLUMN voteCountNew String;")

                // Drop the existing index
                database.execSQL("DROP INDEX IF EXISTS 'old_index_name';")

                // Create new index
                database.execSQL(
                    """
                CREATE INDEX 'new_index_name'
                    ON 'movie_results' ('primary_key_column_one', 'primary_key_column_two');
            """.trimIndent()
                )

                // Commit transaction
                database.execSQL("COMMIT;")
            }
        }
    }
}