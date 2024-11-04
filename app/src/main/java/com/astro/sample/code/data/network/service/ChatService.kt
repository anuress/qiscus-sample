package com.astro.sample.code.data.network.service

import com.astro.sample.code.data.network.model.request.InitiateChatRequest
import com.astro.sample.code.data.network.model.response.InitiateChatResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ChatService {

    companion object {
        private const val INITIATE_CHAT = "https://multichannel.qiscus.com/api/v2/qiscus/initiate_chat"
    }

    @POST(INITIATE_CHAT)
    suspend fun initiateChat(
        @Body params: InitiateChatRequest,
    ): InitiateChatResponse
}