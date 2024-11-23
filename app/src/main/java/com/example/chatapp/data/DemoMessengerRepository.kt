package com.example.chatapp.data

import com.example.chatapp.data.entity.MessageResponse
import com.example.chatapp.data.entity.SendMessageResponse
import com.example.chatapp.data.mapper.MessageResponseMapper
import com.example.chatapp.data.request.SendMessageRequest
import com.example.chatapp.domain.model.Message
import com.example.chatapp.domain.repository.MessengerRepository
import com.example.chatapp.utils.DateUtil.Companion.getDate
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

class DemoMessengerRepository @Inject constructor(val messengerDataSource: MessengerDataSource) :
    MessengerRepository {


    override suspend fun sendMessage(sendMessageRequest: SendMessageRequest): SendMessageResponse {
        //by injecting io dispatcher we can move work to io by using withContext(dispatcher.io)
        //we should change dispatcher here in repository
        //TODO : Map MessageResponse we got from api to Message(domain layer) using MessageResponseMapper class
        val messageResponse =
            messengerDataSource.sendMessage(sendMessageRequest)// getting fake response to implement mapper.
        return SendMessageResponse.Success(MessageResponseMapper.mapToDomainMessage(messageResponse)) // we can move dispatcher to io if long running operation
    }


    override suspend fun listenToResponseMessage(): Flow<Message> {
        return messengerDataSource.newResponseMessage().map { MessageResponseMapper.mapToDomainMessage(it) }

    }
}

