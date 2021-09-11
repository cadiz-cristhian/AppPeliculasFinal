package com.example.apppeliculasfinal.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.apppeliculasfinal.data.Pelicula
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.net.InetSocketAddress

@Database(entities = [PeliculaEntidad::class], version = 1, exportSchema = false)
abstract class PeliculaDatabase : RoomDatabase() {

    abstract fun peliculaDao() : PeliculaDao?

    companion object{

        private var INSTANCE: PeliculaDatabase? = null

        fun getDataBase(context: Context): PeliculaDatabase?{

            if(INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder<PeliculaDatabase>(
                        context.applicationContext,PeliculaDatabase::class.java,"PeliculaDB"
                    ).allowMainThreadQueries()
                        .build()
            }
            return INSTANCE
        }
    }
}