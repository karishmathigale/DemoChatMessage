package com.example.chatapp.data

import com.example.chatapp.data.entity.MessageResponse
import com.example.chatapp.data.entity.SendMessageResponse
import com.example.chatapp.data.request.SendMessageRequest
import com.example.chatapp.domain.model.Message
import com.example.chatapp.domain.repository.MessengerRepository
import kotlinx.coroutines.flow.Flow

class NetworkMessengerRepository : MessengerRepository{
    override suspend fun sendMessage(sendMessageRequest: SendMessageRequest): SendMessageResponse {
        TODO("add implementation of sending real message via network")
        ///by injecting io dispatcher we can move work to io by xusing withContext(dispatcher.io)
        //we should change dispatcher here in repository
    }

    override suspend fun listenToResponseMessage(): Flow<Message> {
        TODO("Not yet implemented")
    }
}