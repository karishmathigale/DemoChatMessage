package com.example.chatapp.data.entity

import com.example.chatapp.domain.model.Message

sealed class SendMessageResponse {
    data class Success(val message : Message) : SendMessageResponse()
    data class Failure(val errorMessage: String) : SendMessageResponse()
}