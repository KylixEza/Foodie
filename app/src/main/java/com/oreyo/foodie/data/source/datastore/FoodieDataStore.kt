package com.oreyo.foodie.data.source.datastore

import android.annotation.SuppressLint
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FoodieDataStore(private val context: Context) {

    companion object {
        @SuppressLint("StaticFieldLeak")
        @Volatile
        private var mInstance: FoodieDataStore? = null

        fun getInstance(context: Context): FoodieDataStore =
            mInstance?: synchronized(this) {
                val newInstance = mInstance?: FoodieDataStore(context).also { mInstance = it }
                newInstance
            }
    }

    private val Context.userPreferenceDataStore: DataStore<Preferences> by preferencesDataStore(
        name = DataStoreUtil.DATA_STORE_NAME
    )

    suspend fun savePrefEmail(email: String) {
        context.userPreferenceDataStore.edit {
            it[DataStoreUtil.EMAIL_PREF_KEY] = email
        }
    }

    suspend fun savePrefHaveRunAppBefore(isFirstTime: Boolean) {
        context.userPreferenceDataStore.edit {
            it[DataStoreUtil.HAVE_RUN_APP_BEFORE] = isFirstTime
        }
    }

    fun readPrefEmail(): Flow<Boolean> = context.userPreferenceDataStore.data
        .map {
            it[DataStoreUtil.EMAIL_PREF_KEY] != "null"
        }

    fun readPrefHaveRunAppBefore(): Flow<Boolean> = context.userPreferenceDataStore.data
        .map {
            it[DataStoreUtil.HAVE_RUN_APP_BEFORE] != null
        }
}