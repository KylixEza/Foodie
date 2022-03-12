package com.oreyo.foodie.domain.usecase.auth

import com.oreyo.foodie.domain.repository.IFoodieRepository
import kotlinx.coroutines.flow.Flow

class AuthInteractor(
    private val repository: IFoodieRepository
): AuthUseCase {

    override suspend fun savePrefEmail(email: String) = repository.savePrefEmail(email)

    override suspend fun savePrefHaveRunAppBefore(isFirstTime: Boolean) =
        repository.savePrefHaveRunAppBefore(isFirstTime)

    override fun readPreEmail(): Flow<Boolean> = repository.readPreEmail()

    override fun readPrefHaveRunAppBefore(): Flow<Boolean> = repository.readPrefHaveRunAppBefore()

}