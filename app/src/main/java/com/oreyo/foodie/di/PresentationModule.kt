package com.oreyo.foodie.di

import com.oreyo.foodie.presentation.auth.login.LoginViewModel
import com.oreyo.foodie.presentation.auth.register.RegisterViewModel
import com.oreyo.foodie.presentation.profile.ProfileViewModel
import com.oreyo.foodie.presentation.splash.SplashViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { LoginViewModel(get()) }
    viewModel { RegisterViewModel(get()) }
    viewModel { SplashViewModel(get()) }
    viewModel { ProfileViewModel(get()) }
}