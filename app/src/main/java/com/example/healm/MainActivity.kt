package com.example.healm

import android.os.Bundle
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.Animatable
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.healm.navigation.MainNavGraph
import com.example.healm.ui.screens.MainScreen
import com.example.healm.ui.theme.*
import com.example.healm.viewmodels.ChatViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HealmTheme {

                val systemColors = rememberSystemUiController()
                val navController = rememberNavController()
                val viewModel:ChatViewModel by viewModels()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute =  navBackStackEntry?.destination?.route
                val yogaItemRoute = MainScreen.YogaItem.route + "/{videoId}/{title}/{large_desc}/{duration}/{level}/{link}"
                val splashScreenRoute = MainScreen.SplashScreen.route

                val showBottomBar = currentRoute != yogaItemRoute  && currentRoute != splashScreenRoute
                systemColors.setStatusBarColor(
                    color = BgColorWhite,
                    darkIcons = true
                )
                Scaffold(
                    floatingActionButton = {
                        if(showBottomBar){
                            FloatingActionButton(
                                onClick = { navController.navigate(MainScreen.ChatBot.route){
                                    popUpTo(MainScreen.Yoga.route)
                                    launchSingleTop = true
                                } },
                                shape = RoundedCornerShape(50),
                                backgroundColor = LightGreen

                            ) {
                                Icon(
                                    painter = painterResource(id = MainScreen.ChatBot.icon!!),
                                    contentDescription = null,
                                    modifier = Modifier.size(32.dp)
                                )

                            }
                        }
                        }
                        ,
                    isFloatingActionButtonDocked = true,
                    floatingActionButtonPosition = FabPosition.Center,
                    bottomBar = {
                        if(showBottomBar){
                            BottomBar(navController = navController)
                        }

                    }
                ) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)){
                        MainNavGraph(navController = navController, viewModel = viewModel )
                    }

                }

            }
        }
    }
}

@Composable
fun SplashScreen(navController: NavController){

    val scale = remember {
        Animatable(0f)
    }

    LaunchedEffect(key1 = true){
        scale.animateTo(
            targetValue = 0.7f,
            animationSpec = tween(
                durationMillis = 500,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )

        delay(3000L)
        navController.navigate(route = MainScreen.Yoga.route)

    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                if (isSystemInDarkTheme()) BlackLight else BgColorWhite
            ),
        contentAlignment = Alignment.Center
    ){
        Column{
            Image(
                painter = painterResource(id = R.drawable.ic_logo_vector),
                contentDescription = null,
                modifier = Modifier.scale(scale.value)
            )

        }




    }
}


@Composable
fun BottomBar(
    navController: NavController,
    items: List<MainScreen> = listOf(
        MainScreen.Yoga,
        MainScreen.Meditation
    )
) {

    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomAppBar(
        backgroundColor = BgColorWhite,
        cutoutShape = RoundedCornerShape(50)
    ) {
        items.forEach { screen ->
            val isSelected = screen.route == backStackEntry.value?.destination?.route

            BottomNavigationItem(selected = isSelected,
                selectedContentColor = PurpleLight,
                unselectedContentColor = LightGrey,
                icon = {
                    if(screen.icon == R.drawable.ic_outline_spa_24 && isSelected){

                        Icon(painter = painterResource(id = screen.icon2!!),
                            contentDescription = null,
                            modifier = Modifier.size(28.dp)
                        )
                    }
                    Icon(painter = painterResource(id = screen.icon!!),
                        contentDescription = null,
                        modifier = Modifier.size(28.dp)
                    )
                },
                label = {
                    if(isSelected){
                        screen.title?.let { Text(text = it, color = PurpleLight) }
                    } else{
                        screen.title?.let { Text(text = it, color = LightGrey) }
                    }

                },
                onClick = { navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true

                    }
                })
        }


    }

}


//@Composable
//fun DefaultPreview() {
//    HealmTheme {
//        val navController = rememberNavController()
//        Scaffold(
//            floatingActionButton = {
//                FloatingActionButton(
//                    onClick = { navController.navigate(MainScreen.ChatBot.route) },
//                    shape = RoundedCornerShape(50),
//                    backgroundColor = LightGreen
//
//                ) {
//                    Icon(
//                        painter = painterResource(id = MainScreen.ChatBot.icon),
//                        contentDescription = null
//                    )
//
//                }
//            },
//            isFloatingActionButtonDocked = true,
//            floatingActionButtonPosition = FabPosition.Center,
//            bottomBar = {
//                BottomBar(navController = navController)
//            }
//        ) {
//
//            MainNavGraph(navController = navController)
//        }
//    }
//}