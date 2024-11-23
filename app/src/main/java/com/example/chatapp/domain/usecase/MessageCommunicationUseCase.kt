package com.example.chatapp.domain.usecase

import com.example.chatapp.data.entity.MessageResponse
import com.example.chatapp.data.entity.SendMessageResponse
import com.example.chatapp.data.request.SendMessageRequest
import com.example.chatapp.domain.model.Message
import com.example.chatapp.domain.repository.MessengerRepository
import com.example.chatapp.utils.DateUtil.Companion.getDate
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MessageCommunicationUseCase @Inject constructor(private val messengerRepository: MessengerRepository) {

    suspend fun sendMessage(message: Message): Message {
        val sendMessageRequest =
            SendMessageRequest(message.text, message.messageType, message.timeStamp)
        val sendMessageResponse = messengerRepository.sendMessage(sendMessageRequest)
        return (sendMessageResponse as SendMessageResponse.Success).message // always returning success and not considering failure case for now
    }

    suspend fun getResponseMessage(): Flow<Message> {
       return messengerRepository.listenToResponseMessage()
    }
}