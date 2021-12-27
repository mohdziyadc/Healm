package com.example.healm.ui.screens.yoga

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.healm.ui.theme.BgColorWhite
import com.example.healm.ui.theme.BlackLight
import com.example.healm.ui.theme.PurpleLight
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerFullScreenListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.YouTubePlayerTracker
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView


@Composable
fun YogaItemScreen(
    navController: NavController,
    videoId: String,
    title:String,
    desc:String,
    duration: String,
    level:String,
    link:String
) {
    val orientation = LocalConfiguration.current.orientation
    val context = LocalContext.current

    Scaffold(
        bottomBar = {
            if(orientation != Configuration.ORIENTATION_LANDSCAPE){
                Column{
                    Divider(
                        color = Color.Gray.copy(0.2f),
                        thickness = 1.dp,
                        startIndent = 8.dp
                    )
                    BottomBarSection(duration = duration, level = level, link = link, context = context)
                }
            }


        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(BgColorWhite)
        ){
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                if(orientation != Configuration.ORIENTATION_LANDSCAPE){
                    TopBar(navController = navController)
                }
                YTPlayer(videoId = videoId)
                YogaDetails(desc = desc, title = title)

            }

        }
    }

}

@Composable
fun YogaDetails(
    title:String,
    desc:String
) {
    val scrollState = rememberScrollState()
    val yogaBox = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .shadow(elevation = 2.dp, shape = yogaBox)
            .clip(yogaBox)
            .padding(16.dp)

    ){
        Column(
            modifier = Modifier.verticalScroll(state = scrollState)
        ){
            Text(
                text = title,
                style = MaterialTheme.typography.h1,
                maxLines = 2
            )
            Text(
                text = desc,
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .padding(top = 16.dp),
                letterSpacing = 1.sp,
                lineHeight = 22.sp,
                color = BlackLight.copy(0.7f)
            )
        }

    }

}

@Composable
fun YTPlayer( videoId:String) {

    val lifeCycleOwner = LocalLifecycleOwner.current

        AndroidView(factory = {
            YouTubePlayerView(it).apply {
                lifeCycleOwner.lifecycle.addObserver(this) //this is needed to stop playing the yt video before the starting the video

                val ytPlayer = object : AbstractYouTubePlayerListener() {
                    override fun onReady(youTubePlayer: YouTubePlayer) {
                        youTubePlayer.cueVideo(videoId, 0f)
                    }

                }
                addYouTubePlayerListener(ytPlayer)




            }

        })





}

@Composable
fun BottomBarSection(
    duration: String,
    level: String,
    link: String,
    context: Context
) {

    Row(modifier = Modifier
        .fillMaxWidth()
        .background(BgColorWhite)
        .padding(top = 1.dp, start = 16.dp, end = 16.dp, bottom = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Column{
            Text(
                text = duration, style = MaterialTheme.typography.h2
            )
            Text(
                text = level, style = MaterialTheme.typography.body1
            )
        }

        Box(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(PurpleLight)
                .clickable {
                    val url = Uri.parse(link)
                    val intent = Intent(Intent.ACTION_VIEW, url)
                    context.startActivity(intent)
                }
                .padding(vertical = 8.dp, horizontal = 10.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.wrapContentWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "Read More",
                    style = MaterialTheme.typography.h2,
                    color = BgColorWhite,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(end = 8.dp)
                )
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = null,
                    tint = BgColorWhite,
                    modifier = Modifier.size(25.dp)
                )
            }

        }


    }
}

@Composable
fun TopBar(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(onClick = { navController.popBackStack() }
            ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                tint = BlackLight,
                modifier = Modifier.size(40.dp)




            )
        }
    }
}