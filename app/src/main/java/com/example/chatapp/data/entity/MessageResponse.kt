package com.example.chatapp.data.entity

import com.example.chatapp.domain.model.MessageType

data class MessageResponse(val text: String = "", val messageType: MessageType = MessageType.Self, val timeStamp :String = "", val isSuccess: Boolean = false)