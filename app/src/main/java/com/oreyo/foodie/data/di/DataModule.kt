package com.oreyo.foodie.data.di

import com.oreyo.foodie.data.source.datastore.FoodieDataStore
import org.koin.dsl.module

val dataStoreModule = module {
    single {
        FoodieDataStore(get())
    }
}