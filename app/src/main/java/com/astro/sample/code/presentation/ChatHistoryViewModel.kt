package com.astro.sample.code.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.astro.sample.code.data.ChatRepository
import com.astro.sample.code.data.network.model.request.InitiateChatExtra
import com.astro.sample.code.data.network.model.request.InitiateChatRequest
import com.astro.sample.code.data.network.model.request.UserProperties
import com.astro.sample.code.data.network.model.response.InitiateChatResponse
import com.qiscus.sdk.chat.core.data.remote.QiscusApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ChatHistoryViewModel(
    private val chatRepository: ChatRepository
): ViewModel() {

    private val _data = MutableStateFlow("")
    val data: StateFlow<String> = _data

    fun initiateData(
        appId: String,
        userId: String,
        channelId: Int
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            val jwtNonce = QiscusApi.getInstance().jwtNonce.toBlocking().last()
            val email = "sample@gmail.com"
            val params = InitiateChatRequest(
                appId = appId,
                userId = userId,
                name = "sample-user",
                channelId = channelId,
                nonce = jwtNonce.nonce,
                userProperties = UserProperties(
                    email = "",
                ),
                extras = InitiateChatExtra(
                    isResolved = false,
                    channelId = channelId
                ),
                resetExtras = false,
                email = email,
                phoneNumber = ""
            )

            chatRepository.initiateChat(params).onSuccess { result ->
                _data.update { result.toString() }
            }.onFailure { error ->
                _data.update { "Error: ${error.message.toString()}" }
            }
        }
    }
}