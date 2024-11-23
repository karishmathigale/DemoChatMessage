package com.example.chatapp.data.request

import com.example.chatapp.domain.model.MessageType

data class SendMessageRequest(val text: String = "", val messageType: MessageType = MessageType.Self, val timeStamp :String = "")