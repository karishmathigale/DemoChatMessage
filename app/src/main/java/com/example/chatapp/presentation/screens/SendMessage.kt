package com.example.chatapp.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SendMessage(onSendMessage: (String) -> Unit, modifier: Modifier = Modifier) {
    var typedMessage by remember {
        mutableStateOf("")
    }
    //TODO : padding bottom is not correct way.. that needs to be addressed
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        TextField(value = typedMessage,
            maxLines = 4,
            onValueChange = { value -> typedMessage = value },
            modifier = Modifier
                .padding(8.dp)
                .weight(1f)
                .clip(RoundedCornerShape(10.dp)),
            placeholder = {
                Text(text = "Type here")
            })
        IconButton(onClick = {
            onSendMessage(typedMessage.trim())
            typedMessage = ""
        }) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.Send, contentDescription = "Send Message"
            )
        }
    }
}