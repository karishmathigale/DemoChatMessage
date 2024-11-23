package com.example.chatapp.presentation.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.example.chatapp.data.entity.MessageResponse
import com.example.chatapp.domain.model.Message
import com.example.chatapp.domain.model.MessageType

@Composable
fun MessageItemBuilder(message: Message, onMessageLongClick: () -> Unit, modifier: Modifier = Modifier) {
    when(message.messageType) {
        MessageType.Self -> SelfMessage(message = message, onMessageLongClick = onMessageLongClick, modifier)
        MessageType.Reply -> ReplyMessage(message = message, onMessageLongClick = onMessageLongClick, modifier)
    }
}


