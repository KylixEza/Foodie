package com.oreyo.foodie.domain.di

import com.oreyo.foodie.data.repository.FoodieRepository
import com.oreyo.foodie.domain.repository.IFoodieRepository
import com.oreyo.foodie.domain.usecase.auth.AuthInteractor
import com.oreyo.foodie.domain.usecase.auth.AuthUseCase
import org.koin.dsl.module

val repositoryModule = module {
    single<IFoodieRepository> {
        FoodieRepository(get())
    }
}

val useCaseModule = module {
    single<AuthUseCase> {
        AuthInteractor(get())
    }
}