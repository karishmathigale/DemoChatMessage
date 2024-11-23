package com.example.chatapp.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatapp.data.entity.MessageResponse
import com.example.chatapp.domain.model.Message
import com.example.chatapp.domain.model.MessageType
import com.example.chatapp.domain.usecase.MessageCommunicationUseCase
import com.example.chatapp.utils.DateUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(private val messageCommunicationUseCase: MessageCommunicationUseCase) :
    ViewModel() {

    private var _chatMessages = MutableStateFlow(emptyList<Message>())
    val chatMessages: StateFlow<List<Message>> = _chatMessages

    //start collecting response.
    init {
        viewModelScope.launch {
            messageCommunicationUseCase.getResponseMessage().collect{
                _chatMessages.emit(_chatMessages.value + it)
            }
        }
    }

fun sendMessage(message: String) {
    val messageToSend = Message(message, MessageType.Self, DateUtil.getDate())
    viewModelScope.launch {
        _chatMessages.emit(_chatMessages.value + messageToSend)
        val response = messageCommunicationUseCase.sendMessage(messageToSend)
        //we can use response to update UI
        // (ex. check mark tick to inform user that message has been sent)
    }
}
}