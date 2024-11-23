package com.example.chatapp.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.chatapp.presentation.ChatViewModel

@Composable
fun ChatScreen(
    modifier: Modifier = Modifier,
    chatViewmodel: ChatViewModel = viewModel()
) {
    val chatMessages = chatViewmodel.chatMessages.collectAsState()
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        ChatMessageList(chatMessages.value, onMessageLongClick = {})
        SendMessage(onSendMessage = { newMessage -> chatViewmodel.sendMessage(newMessage) })
    }
}


@Preview(showBackground = true)
@Composable
fun ChatScreenPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
    ) {
        // ChatScreen()
    }

}

