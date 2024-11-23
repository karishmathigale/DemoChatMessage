package com.example.chatapp.data

import com.example.chatapp.data.entity.MessageResponse
import com.example.chatapp.data.entity.SendMessageResponse
import com.example.chatapp.data.mapper.MessageResponseMapper
import com.example.chatapp.data.request.SendMessageRequest
import com.example.chatapp.di.IoDispatcher
import com.example.chatapp.domain.model.Message
import com.example.chatapp.domain.model.MessageType
import com.example.chatapp.utils.DateUtil.Companion.getDate
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MessengerDataSource @Inject constructor(@IoDispatcher dispatcher : CoroutineDispatcher){

    val newMessage = Channel<MessageResponse>()
    private val coroutineScope = CoroutineScope(dispatcher)

     suspend fun sendMessage(sendMessageRequest: SendMessageRequest): MessageResponse {
        //by injecting io dispatcher we can move work to io by using withContext(dispatcher.io)
        //we should change dispatcher here in repository
        val messageResponse = demoSendMessage(sendMessageRequest)// getting fake response to implement mapper.
        if (messageResponse.isSuccess) {
            emitResponse()
        }
        return messageResponse // we can move dispatcher to io if long running operation
    }

    private suspend fun emitResponse() {
        coroutineScope.launch { // check this how this scope will be cancel when viewmodel gets cleared?
            delay(5000)
            // emit the new message
            newMessage.send(demoGetMessageResponse())
        }
    }

    //Below method is just to create reply of send message.
    private fun demoSendMessage(messageRequest: SendMessageRequest) : MessageResponse {
        return MessageResponse(messageRequest.text,MessageType.Self,messageRequest.timeStamp,true)
    }

    /*
   creating random message reply after 5 second
    */
    private fun demoGetMessageResponse(): MessageResponse {
        return MessageResponse(messageList.random(), MessageType.Reply, getDate())
    }

    private var messageList = arrayListOf(
        "Hi",
        "Hello",
        "How are you doing?",
        "I am doing good",
        "I am going out are you interested to come with me"
    )


    //TODO : we need to do some mechanism to cancel the scope
    fun clear(){
        coroutineScope.cancel()
    }
}