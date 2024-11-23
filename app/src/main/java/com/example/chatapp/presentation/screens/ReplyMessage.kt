package com.example.chatapp.presentation.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.chatapp.domain.model.Message

@Composable
fun ReplyMessage(message: Message, onMessageLongClick: () -> Unit, modifier: Modifier = Modifier) {
    MessageItem(
        message = message,
        onMessageLongClick = onMessageLongClick,
        clippedShape = {
            RoundedCornerShape(
                topStart = 10.dp, topEnd = 10.dp, bottomEnd = 10.dp
            )
        },
        backgroundColor = Color.LightGray,
        textColor = Color.Black,
        alignment = Alignment.CenterStart,
        modifier
    )
}

