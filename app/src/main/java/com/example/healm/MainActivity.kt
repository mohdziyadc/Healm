package com.example.healm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
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
                systemColors.setStatusBarColor(
                    color = BgColorWhite,
                    darkIcons = true
                )
                Scaffold(
                    floatingActionButton = {
                        if(currentRoute != MainScreen.YogaItem.route + "/{videoId}/{title}/{large_desc}/{duration}/{level}/{link}"){
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
                        if(currentRoute != MainScreen.YogaItem.route + "/{videoId}/{title}/{large_desc}/{duration}/{level}/{link}"){
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