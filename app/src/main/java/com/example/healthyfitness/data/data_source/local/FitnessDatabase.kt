package com.example.healthyfitness.data.data_source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.healthyfitness.presentation.screens.common_components.Exercise
import com.example.healthyfitness.data.food_data.FoodDatabaseItem

@Database(
    entities = [FoodDatabaseItem::class, Exercise::class],
    version = 3,
    exportSchema = false
)
abstract class FitnessDatabase:RoomDatabase() {
    abstract val dao : AllFitnessDao

    companion object{
        @Volatile
        private var daoInstance : AllFitnessDao?=null

        private fun buildDatabase (context:Context): FitnessDatabase =
            Room.databaseBuilder(
                context.applicationContext,
                FitnessDatabase::class.java,
                "foods_database"
            ).fallbackToDestructiveMigration()
                .build()

        fun getDaoInstance(context: Context): AllFitnessDao {
            if(daoInstance ==null){
                daoInstance = buildDatabase(context).dao
            }
            return daoInstance as AllFitnessDao
        }
    }
}