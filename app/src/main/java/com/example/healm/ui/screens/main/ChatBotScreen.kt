package com.example.healm.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.healm.Utils.Constants.BOT_KEY
import com.example.healm.Utils.Constants.USER_KEY
import com.example.healm.network.models.Message
import com.example.healm.ui.theme.BgColorWhite
import com.example.healm.ui.theme.BlackLight
import com.example.healm.ui.theme.LightGreen
import com.example.healm.viewmodels.ChatViewModel
import kotlinx.coroutines.launch


@Composable
fun ChatBotScreen(viewModel:ChatViewModel) {


    val userMsg = remember { mutableStateOf("") }
    val isRequested = viewModel.isRequested.value
    val msgList = viewModel.msgList

    val listState = rememberLazyListState()
    val scope = rememberCoroutineScope()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BgColorWhite)
    ) {
        Scaffold(
            topBar = {
                TopToolbar()
            },
            bottomBar = {
                BottomBar(msg = userMsg, viewModel = viewModel)
            }
        ) { innerPadding ->
            Log.d("ChatScreen", "MessagesList = $msgList")
            if(isRequested){
                Box(modifier = Modifier.padding(innerPadding).padding(8.dp)) {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        state = listState,
                        contentPadding = PaddingValues(4.dp)
                    ) {
                        items(msgList) { msg ->

                            when (msg.sender) {
                                BOT_KEY -> BotMessageBubble(response = msg.cnt)
                                USER_KEY -> UserMessageBubble(msg = msg.cnt)
                            }
                        }

                        if (msgList.isNotEmpty()) {
                            scope.launch {
                                listState.animateScrollToItem(msgList.size - 1)
                            }

                        }

                    }
                }
            }else{

                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        text = "Say hello to Chloe!!",
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier.padding(24.dp)

                    )
                }
            }



        }
    }

}
private val BotTextBubbleShape = RoundedCornerShape(4.dp, 20.dp, 20.dp, 20.dp)
private val UserTextBubbleShape = RoundedCornerShape(20.dp, 20.dp, 4.dp, 20.dp)

@Composable
fun BotMessageBubble(response:String) {
    Box(modifier = Modifier.fillMaxWidth()){
        Box(
            modifier = Modifier
                .requiredWidthIn(min = 50.dp, max = 250.dp)
                .clip(BotTextBubbleShape)
                .align(alignment = Alignment.TopStart)
                .background(BgColorWhite)
                .padding(8.dp)
        ){
            Text(text = response, color = BlackLight)
        }
    }

}

@Composable
fun UserMessageBubble(msg:String) {
    Box(modifier = Modifier.fillMaxWidth()){
        Box(
            modifier = Modifier
                .requiredWidthIn(min = 50.dp, max = 250.dp)
                .clip(UserTextBubbleShape)
                .align(alignment = Alignment.TopEnd)
                .background(LightGreen)
                .padding(8.dp)
        ){
            Text(text = msg, color = Color.White)
        }
    }
}

@Composable
fun BottomBar(msg: MutableState<String>, viewModel: ChatViewModel) {

    Row(
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(horizontal = 8.dp, vertical = 22.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(value = msg.value,
            onValueChange = {
                msg.value = it
            },
            modifier = Modifier
                .fillMaxWidth(0.82f)
                .border(2.dp, color = LightGreen, shape = RoundedCornerShape(20.dp))
                .background(BgColorWhite),
            shape = RoundedCornerShape(20.dp),
            placeholder = {
                Text(text = "Enter your message here")
            }


        )

        FloatingActionButton(
            onClick = {
                sendRequest(viewModel, msg = msg.value)
                msg.value = ""
            },
            modifier = Modifier
                .padding(8.dp),
            shape = CircleShape,
            backgroundColor = LightGreen
        ) {
            Icon(
                imageVector = Icons.Default.Send,
                contentDescription = null,
                tint = Color.White,

                )
        }


    }
}

fun sendRequest(viewModel: ChatViewModel, msg: String) {

    viewModel.getMessage(msg)
    viewModel.msgList.add(Message(cnt = msg, sender = USER_KEY))
    Log.d("ChatScreen", "User msg --- ${Message(cnt = msg, sender = USER_KEY)}")
}

@Composable
fun TopToolbar() {
    TopAppBar(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        backgroundColor = BgColorWhite
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberImagePainter(
                    data = "https://i.pinimg.com/originals/55/44/2f/55442f2018fd5e2781c732f90f1f7756.jpg",
                    builder = {
                        transformations(CircleCropTransformation())
                        crossfade(true)
                    }
                ),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .border(width = 1.dp, color = LightGreen, shape = CircleShape)
            )
            Column(
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Text(text = "Chloe", color = BlackLight, fontSize = 18.sp)
                Text(text = "Your happiness buddy", color = BlackLight, fontSize = 13.sp)
            }
        }


    }
}