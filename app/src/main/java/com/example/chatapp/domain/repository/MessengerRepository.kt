package com.example.chatapp.domain.repository

import com.example.chatapp.data.entity.MessageResponse
import com.example.chatapp.data.entity.SendMessageResponse
import com.example.chatapp.data.request.SendMessageRequest
import com.example.chatapp.domain.model.Message
import kotlinx.coroutines.flow.Flow

interface MessengerRepository {
    suspend fun sendMessage(sendMessageRequest: SendMessageRequest) : SendMessageResponse

    suspend fun listenToResponseMessage(): Flow<Message>
}