package com.example.toyotaapplication.domain.model

sealed class NetworkStateResponse {
    data class Success(val response: UserResponse?): NetworkStateResponse()

    data object Loading: NetworkStateResponse()

    data class Failed(val error: String): NetworkStateResponse()

    companion object {
        fun success(response: UserResponse): NetworkStateResponse = Success(response)
        fun loading(): NetworkStateResponse = Loading
        fun failed(response: UserResponse): NetworkStateResponse = failed(response)
    }
}

//sealed class Result {
//    data class Success(val data: String) : Result()
//    data class Error(val message: String) : Result()
//
//    companion object {
//        fun success(data: String): Result = Success(data)
//        fun error(message: String): Result = Error(message)
//    }
//}