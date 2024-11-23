package com.example.chatapp.domain.model

data class Message(val text: String = "", val messageType: MessageType = MessageType.Self, val timeStamp :String = "")

sealed class MessageType{
    data object Self : MessageType()
    data object Reply : MessageType()
}