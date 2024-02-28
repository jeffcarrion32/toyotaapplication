package com.example.toyotaapplication.domain.model

sealed class NetworkStateResponse {
    data class Success(val response: UserResponse?): NetworkStateResponse()

    data object Loading: NetworkStateResponse()

    data class Failed(val error: String): NetworkStateResponse()
}
