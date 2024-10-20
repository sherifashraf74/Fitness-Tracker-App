package com.example.healthyfitness.data.data_source.local

import androidx.room.Dao

@Dao
interface UserDao {
/* ex
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM user")
    suspend fun getUser(): User*/
}