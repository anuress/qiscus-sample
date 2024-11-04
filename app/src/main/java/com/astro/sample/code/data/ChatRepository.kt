package com.astro.sample.code.data

import com.astro.sample.code.data.network.model.request.InitiateChatRequest
import com.astro.sample.code.data.network.model.response.InitiateChatResponse
import com.astro.sample.code.data.network.service.ChatService

interface ChatRepository {
    suspend fun initiateChat(params: InitiateChatRequest): Result<InitiateChatResponse>
}

class ChatRepositoryImpl(
    private val chatService: ChatService
): ChatRepository {
    override suspend fun initiateChat(params: InitiateChatRequest): Result<InitiateChatResponse> {
       return runCatching {
           chatService.initiateChat(params)
       }
    }
}