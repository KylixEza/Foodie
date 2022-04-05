package com.oreyo.foodie.di

import androidx.room.Room
import com.oreyo.foodie.data.repository.FoodieRepository
import com.oreyo.foodie.data.repository.IFoodieRepository
import com.oreyo.foodie.data.source.local.LocalDataSource
import com.oreyo.foodie.data.source.local.datastore.FoodieDataStore
import com.oreyo.foodie.data.source.local.database.room.FoodieDatabase
import com.oreyo.foodie.data.source.remote.RemoteDataSource
import com.oreyo.foodie.data.source.remote.api.service.ApiService
import com.oreyo.foodie.data.source.remote.firebase.FirebaseService
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule = module {
    factory {
        get<FoodieDatabase>().foodieDao()
    }
    single {
        Room.databaseBuilder(
            androidContext(),
            FoodieDatabase::class.java, "foodie.db"
        ).fallbackToDestructiveMigration()
            .build()
    }
}

val networkModule = module {
    single {
        val hostname = "api-oreyo-foodie.herokuapp.com"
        val certificatePinner = CertificatePinner.Builder()
            .add(hostname, "sha256/oXAkjliKUc96ggdAdVsDuaBuUt5iX1AQqHL69nGUS8g")
            .add(hostname, "sha256/JSMzqOOrtyOT1kmau6zKhgT676hGgczD5VMdRMyJZFA")
            .add(hostname, "sha256/++MBgDH5WGvL9Bcn5Be30cRcL0f5O+NyoXuWtQdX1aI")
            .add(hostname, "sha256/KwccWaCgrnaw6tsrrSO61FgLacNgG2MMLq8GE6+oP5I")
            .build()
        OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .certificatePinner(certificatePinner)
            .build()
    }

    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api-oreyo-foodie.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val firebaseModule = module {
    single {
        FirebaseService()
    }
}

val repositoryModule = module {
    single { LocalDataSource(get(), androidApplication()) }
    single { RemoteDataSource(get(), get()) }
    single<IFoodieRepository> {
        FoodieRepository(get(), get())
    }
}