package com.astro.sample.code.data.network.model.request


data class InitiateChatRequest(
    val appId: String? = null,
    val userId: String? = null,
    val name: String? = null,
    val userProperties: UserProperties? = null,
    val channelId: Int? = null,
    val nonce: String? = null,
    val avatar: String? = null,
    val extras: InitiateChatExtra? = null,
    val resetExtras: Boolean? = null,
    val phoneNumber: String? = null,
    val email: String? = null,
)

data class UserProperties(
    val email: String? = null,
)

data class InitiateChatExtra(
    val email: String? = null,
    val isResolved: Boolean? = null,
    val channelId: Int? = null,
)
