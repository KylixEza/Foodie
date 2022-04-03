package com.oreyo.foodie.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.oreyo.foodie.data.source.local.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class FoodieDatabase: RoomDatabase() {
    abstract fun foodieDao(): FoodieDao
}