package com.oreyo.foodie.data.repository

import com.oreyo.foodie.data.source.datastore.FoodieDataStore
import com.oreyo.foodie.domain.repository.IFoodieRepository
import kotlinx.coroutines.flow.Flow

class FoodieRepository(
    private val dataStore: FoodieDataStore
): IFoodieRepository {

    override suspend fun savePrefEmail(email: String) {
        dataStore.savePrefEmail(email)
    }

    override suspend fun savePrefHaveRunAppBefore(isFirstTime: Boolean) {
        dataStore.savePrefHaveRunAppBefore(isFirstTime)
    }

    override fun readPreEmail(): Flow<Boolean> = dataStore.readPrefEmail()

    override fun readPrefHaveRunAppBefore(): Flow<Boolean> = dataStore.readPrefHaveRunAppBefore()


}