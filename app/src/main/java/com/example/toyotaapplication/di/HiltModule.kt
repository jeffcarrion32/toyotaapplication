package com.example.toyotaapplication.di

import com.example.toyotaapplication.data.network.IUserService
import com.example.toyotaapplication.data.network.UserApiClient
import com.example.toyotaapplication.data.repository.IRepositoryUsers
import com.example.toyotaapplication.data.repository.UserRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(ViewModelComponent::class)
object HiltModule {
    @Provides
    fun provideService(): IUserService = UserApiClient().api

    @Provides
    fun provideDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    fun provideRepository(
        service: IUserService,
        dispatcher: CoroutineDispatcher
    ): IRepositoryUsers = UserRepoImpl(service, dispatcher)
}