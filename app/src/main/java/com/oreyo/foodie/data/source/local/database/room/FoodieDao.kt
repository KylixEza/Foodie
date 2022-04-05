package com.oreyo.foodie.data.source.local.database.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.oreyo.foodie.data.source.local.database.entity.UserEntity

@Dao
interface FoodieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(userEntity: UserEntity)
}