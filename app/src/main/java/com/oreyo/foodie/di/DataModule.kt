package com.oreyo.foodie.di

import androidx.room.Room
import com.oreyo.foodie.data.repository.FoodieRepository
import com.oreyo.foodie.data.repository.IFoodieRepository
import com.oreyo.foodie.data.source.datastore.FoodieDataStore
import com.oreyo.foodie.data.source.local.room.FoodieDatabase
import com.oreyo.foodie.data.source.remote.service.ApiService
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

val dataStoreModule = module {
    single {
        FoodieDataStore(get())
    }
}

val databaseModule = module {
    factory {
        get<FoodieDatabase>().foodieDao()
    }
    single {
        val passphrase: ByteArray = SQLiteDatabase.getBytes("githubUser".toCharArray())
        val factory = SupportFactory(passphrase)
        Room.databaseBuilder(
            androidContext(),
            FoodieDatabase::class.java, "foodie.db"
        ).fallbackToDestructiveMigration()
            .openHelperFactory(factory)
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
            .baseUrl("api-oreyo-foodie.herokuapp.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single<IFoodieRepository> {
        FoodieRepository(get())
    }
}