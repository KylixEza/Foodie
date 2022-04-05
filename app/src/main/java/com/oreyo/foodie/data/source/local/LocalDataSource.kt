package com.oreyo.foodie.data.source.local

import android.app.Application
import com.oreyo.foodie.data.source.local.database.entity.UserEntity
import com.oreyo.foodie.data.source.local.database.room.FoodieDao
import com.oreyo.foodie.data.source.local.datastore.FoodieDataStore
import kotlinx.coroutines.flow.Flow

class LocalDataSource(
    private val dao: FoodieDao,
    private val application: Application
) {

    private val dataStore: FoodieDataStore = FoodieDataStore.getInstance(application)

    suspend fun savePrefEmail(email: String) {
        dataStore.savePrefEmail(email)
    }

    suspend fun savePrefHaveRunAppBefore(isFirstTime: Boolean) {
        dataStore.savePrefHaveRunAppBefore(isFirstTime)
    }

    fun readPreEmail(): Flow<Boolean> = dataStore.readPrefEmail()

    fun readPrefHaveRunAppBefore(): Flow<Boolean> = dataStore.readPrefHaveRunAppBefore()

    suspend fun insertUser(user: UserEntity) = dao.insertUser(user)
}