package com.example.toyotaapplication.data.repository

import com.example.toyotaapplication.data.network.IUserService
import com.example.toyotaapplication.domain.model.UserResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class UserRepoImpl(
    private val service: IUserService,
    private val dispatcher: CoroutineDispatcher
): IRepositoryUsers {

    override suspend fun getUserResponse(): UserResponse {
        return withContext(dispatcher) {
            val response = service.getUser()

            response
        }
    }
}

interface IRepositoryUsers {
    suspend fun getUserResponse() : UserResponse
}