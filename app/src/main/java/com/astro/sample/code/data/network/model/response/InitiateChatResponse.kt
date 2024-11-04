package com.astro.sample.code.data.network.model.response

import com.google.gson.annotations.SerializedName

data class InitiateChatResponse(
    @SerializedName("data")
    val data: InitiateChatDataModel = InitiateChatDataModel(),
    @SerializedName("status")
    val status: Int = 0
)

data class InitiateChatDataModel(
    @SerializedName("customer_room")
    val customerRoom: ChatRoomModel = ChatRoomModel(),
    @SerializedName("identity_token")
    val identityToken: String = "",
    @SerializedName("is_sessional")
    val isSessional: Boolean = false,
    @SerializedName("sdk_user")
    val sdkUser: String = ""
)

data class ChatRoomModel(
    @SerializedName("channel_id")
    val channelId: Int = 0,
    @SerializedName("extras")
    val extras: ChatRoomExtra = ChatRoomExtra(),
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("is_handled_by_bot")
    val isHandledByBot: Boolean = false,
    @SerializedName("is_resolved")
    val isResolved: Boolean = false,
    @SerializedName("is_waiting")
    val isWaiting: Boolean = false,
    @SerializedName("last_comment_sender")
    val lastCommentSender: String = "",
    @SerializedName("last_comment_sender_type")
    val lastCommentSenderType: String = "",
    @SerializedName("last_comment_text")
    val lastCommentText: String = "",
    @SerializedName("last_comment_timestamp")
    val lastCommentTimestamp: String = "",
    @SerializedName("last_customer_timestamp")
    val lastCustomerTimestamp: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("room_badge")
    val roomBadge: String = "",
    @SerializedName("room_id")
    val roomId: Long = 0,
    @SerializedName("source")
    val source: String = "",
    @SerializedName("user_avatar_url")
    val userAvatarUrl: String = "",
    @SerializedName("user_id")
    val userId: String = "",
)

data class ChatRoomExtra(
    @SerializedName("additional_extras")
    val additionalExtras: Map<String, Any> = mapOf(),
    @SerializedName("notes")
    val notes: String = "",
    @SerializedName("user_properties")
    val timezoneOffset: Int = 0,
    @SerializedName("user_id")
    val userProperties: List<Map<String, Any>> = listOf(),
)