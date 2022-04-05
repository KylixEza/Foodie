package com.oreyo.foodie.data.source.local.database.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.oreyo.foodie.data.source.local.database.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class FoodieDatabase: RoomDatabase() {
    abstract fun foodieDao(): FoodieDao
}