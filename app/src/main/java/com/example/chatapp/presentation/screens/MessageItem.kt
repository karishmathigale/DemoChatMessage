package com.example.chatapp.presentation.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.example.chatapp.domain.model.Message

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MessageItem(
    message: Message,
    onMessageLongClick: () -> Unit,
    clippedShape: @Composable () -> Shape,
    backgroundColor: Color,
    textColor: Color,
    alignment: Alignment,
    modifier: Modifier = Modifier,
) {

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    Box(modifier = modifier.fillMaxWidth()) {
        Box(modifier = Modifier
            .widthIn(max = screenWidth / 1.4f)
            .clip(clippedShape())
            .background(backgroundColor)
            .combinedClickable(onLongClick = onMessageLongClick) { }
            .padding(10.dp)
            .align(alignment)) {
            Column { //TODO : make color property of below two text at parent level(ex.column)
                Text(
                    text = message.text,
                    color = (textColor),
                    modifier = modifier.padding(start = 8.dp)
                )
                //TimeStamp
                Text(
                    text = message.timeStamp,
                    color = (textColor),
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(top = 8.dp)
                )
            }
        }
    }
}


