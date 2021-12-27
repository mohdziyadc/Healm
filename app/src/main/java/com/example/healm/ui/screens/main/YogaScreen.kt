package com.example.healm.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.healm.R
import com.example.healm.models.Yoga
import com.example.healm.models.yogaList
import com.example.healm.ui.theme.*
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun YogaScreen(navController: NavController) {


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BgColorWhite)
            .padding(16.dp)
    ) {
        Column {
            HeaderSection()
            FeaturedSection()
            TabsSection()
            YogasList(navController = navController)


        }


    }

}

@Composable
fun YogasList(
    listYoga: List<Yoga> = yogaList,
    navController: NavController
) {

    LazyColumn(
        contentPadding = PaddingValues(vertical = 4.dp)
    ) {

        items(listYoga) { yoga ->

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .shadow(elevation = 1.dp, shape = RoundedCornerShape(10.dp))
                    .clip(RoundedCornerShape(10.dp))
                    .clickable {
                            val encodeUrl = URLEncoder.encode(yoga.link, StandardCharsets.UTF_8.toString())
                            navController.navigate(
                                MainScreen.YogaItem.route +
                                        "/${yoga.videoId}/${yoga.title}/${yoga.large_description}/${yoga.duration}/${yoga.level}/${encodeUrl}"
                            ){
                                popUpTo(MainScreen.Yoga.route)
                                launchSingleTop = true
                            }


                    }
                    .background(BgColorWhite)
                    .padding(8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start

                ) {
                    Box(
                        modifier = Modifier
                            .width(95.dp)
                            .height(80.dp)
                            .padding(end = 16.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(yoga.color)
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(painter = rememberImagePainter(
                            data = yoga.img_url,
                            builder = {
                                crossfade(true)
                            }
                        ),
                            contentDescription = null,
                            contentScale = ContentScale.Fit
                        )

                    }

                    Column {
                        Text(
                            text = yoga.sanskrit_name,
                            style = MaterialTheme.typography.h2,
                            color = BlackLight
                        )
                        Text(
                            text = yoga.small_description,
                            style = MaterialTheme.typography.body1,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis

                        )

                    }

                }

            }

        }

    }


}


@Composable
fun TabsSection() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 72.dp)
    ) {

        Box(
            modifier = Modifier
                .padding(8.dp)
                .shadow(elevation = 2.dp, shape = RoundedCornerShape(18.dp))
                .clip(RoundedCornerShape(18.dp))
                .background(BgColorWhite)
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Yogas",
                style = MaterialTheme.typography.h2,
                fontWeight = FontWeight.ExtraBold,
                color = PurpleLight,
                letterSpacing = 1.sp,
                fontSize = 15.sp

            )
        }


    }
}

@Composable
fun FeaturedSection() {

    Box {
        Box(
            modifier = Modifier
                .fillMaxHeight(0.4f)
                .clip(RoundedCornerShape(16.dp))

        ) {
            Image(
                painter = painterResource(id = R.drawable.yoga_pose),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)
                .align(Alignment.BottomCenter)
                .offset(y = 64.dp)
                .shadow(elevation = 2.dp, shape = RoundedCornerShape(16.dp))
                .clickable { }
                .clip(RoundedCornerShape(16.dp))
                .background(BgColorWhite)
                .padding(vertical = 16.dp, horizontal = 20.dp)
        ) {
            Column {
                Text(
                    text = "FEATURED",
                    style = MaterialTheme.typography.h2,
                    color = PurpleLight,
                    fontSize = 14.sp
                )


                Text(
                    text = "Hatha Yoga: Beginner",
                    style = MaterialTheme.typography.h2,
                    color = BlackLight
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "A well-suited class for beginners.",
                    style = MaterialTheme.typography.body1
                )

            }

        }


    }
}

@Composable
fun HeaderSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "For You", style = MaterialTheme.typography.h1)

        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )

        }

    }
}


