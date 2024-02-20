package com.example.toyotaapplication.data.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class UserApiClient {

    val api: IUserService =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(IUserService::class.java)
}