package com.example.chatapp.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.chatapp.data.entity.MessageResponse
import com.example.chatapp.domain.model.Message

@Composable
fun ChatMessageList(
    list: List<Message>, onMessageLongClick: (Message) -> Unit, modifier: Modifier = Modifier
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp), contentPadding = PaddingValues(8.dp)
    ) {
        items(items = list) { message -> // not need to updated key as we wont have recomposition as per position for now.
            MessageItemBuilder(
                message, onMessageLongClick = { onMessageLongClick(message) }, modifier
            )
        }
    }
}