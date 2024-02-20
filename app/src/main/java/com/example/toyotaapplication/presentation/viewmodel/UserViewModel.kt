package com.example.toyotaapplication.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.toyotaapplication.data.repository.IRepositoryUsers
import com.example.toyotaapplication.domain.model.NetworkStateResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val repository: IRepositoryUsers
): ViewModel() {
    private var _response = MutableStateFlow<NetworkStateResponse>(NetworkStateResponse.Loading)
    val response = _response

    fun makeRequest() {
        viewModelScope.launch {
            try {
                val responseData = repository.getUserResponse()
                _response.value = NetworkStateResponse.Success(responseData)
                Log.d("RESPONSESTATE", "${_response.value}")

            } catch (ex: Exception) {
                _response.value = NetworkStateResponse.Failed("Network Error")
            }
        }
    }
}