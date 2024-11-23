package com.example.chatapp.data.mapper

import com.example.chatapp.data.entity.MessageResponse
import com.example.chatapp.domain.model.Message

object MessageResponseMapper {
    fun mapToDomainMessage(messageResponse: MessageResponse): Message {
        return Message(
            messageResponse.text,
            messageResponse.messageType,
            messageResponse.timeStamp
        )
    }
}