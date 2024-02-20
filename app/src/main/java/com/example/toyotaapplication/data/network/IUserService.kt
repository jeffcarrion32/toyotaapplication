package com.example.toyotaapplication.data.network

import com.example.toyotaapplication.domain.model.UserResponse
import retrofit2.http.GET

interface IUserService {
    @GET(END_POINT)
    suspend fun getUser(): UserResponse
}