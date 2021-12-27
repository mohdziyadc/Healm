package com.example.healm.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.healm.models.Meditation
import com.example.healm.models.MeditationList
import com.example.healm.ui.theme.BgColorWhite
import com.example.healm.ui.theme.PurpleLight
import com.example.healm.ui.theme.PurpleLight50
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun MeditationScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BgColorWhite)
            .padding(16.dp)
    ) {
        Column {
            BgImageSection()
            TitleSection()
            MeditationsSection()
        }
    }

}

@Composable
fun MeditationsSection(
    meditationList: List<Meditation> = MeditationList
) {

    val listState = rememberLazyListState()

    LazyColumn(
        state = listState,
        contentPadding = PaddingValues(vertical = 4.dp)
    ){
        items(meditationList.size){ index ->


            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .shadow(elevation = 1.dp, shape = RoundedCornerShape(10.dp))
                .clip(RoundedCornerShape(10.dp))
                .clickable {  }
                .background(BgColorWhite)
                .padding(8.dp)

            ){
                Row {

                    Column(
                        modifier = Modifier.fillMaxWidth(0.8f)
                    ) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(10.dp))
                                .background(PurpleLight50)
                                .padding(vertical = 6.dp, horizontal = 4.dp)
                        ) {
                            Text(
                                text = "${meditationList[index].time} MINS",
                                style = MaterialTheme.typography.h2,
                                fontSize = 10.sp,
                                color = PurpleLight

                            )

                        }

                        Text(text = meditationList[index].name, style = MaterialTheme.typography.h2)

                        Text(
                            text = meditationList[index].desc,
                            style = MaterialTheme.typography.body1,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )

                    }

                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .width(90.dp)
                            .height(100.dp)

                    ){
                        Image(
                            painter = painterResource(id = meditationList[index].img),
                            contentDescription = null,
                            contentScale = if(meditationList[index].id ==1){
                                ContentScale.Crop
                            }else {
                                ContentScale.Fit
                            }
                        )

                    }


                }


            }


        }

    }



}

@Composable
fun TitleSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        Text(text = "Meditations", style = MaterialTheme.typography.h1)
    }
}

@Composable
fun BgImageSection() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.25f)
            .clip(RoundedCornerShape(10.dp))
    ) {
        Image(painter = rememberImagePainter(
            data = "https://cdn.pixabay.com/photo/2020/10/14/16/14/space-5654794_960_720.png",
            builder = {
                crossfade(true)
            }
        ),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth()
        )
    }

}
