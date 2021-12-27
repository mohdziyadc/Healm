package com.example.healm.navigation

import android.util.Log
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.*
import androidx.navigation.compose.composable
import com.example.healm.Utils.Constants.BOTTOM_BAR_ROUTE
import com.example.healm.ui.screens.*
import com.example.healm.ui.screens.yoga.YogaItemScreen
import com.example.healm.viewmodels.ChatViewModel

fun NavGraphBuilder.BottomNavGraph(viewModel: ChatViewModel, navController: NavController) {

    navigation(
        startDestination = MainScreen.Yoga.route,
        route = BOTTOM_BAR_ROUTE
    ){
        composable(route = MainScreen.Yoga.route){
            YogaScreen(navController = navController)
        }

        composable(route = MainScreen.ChatBot.route){

            ChatBotScreen(viewModel)
        }

        composable(route = MainScreen.Meditation.route){
            MeditationScreen()
        }

        composable(
            route= MainScreen.YogaItem.route + "/{videoId}/{title}/{large_desc}/{duration}/{level}/{link}",
            arguments = listOf(
                navArgument("videoId"){
                    type = NavType.StringType
                },
                navArgument("title"){
                    type = NavType.StringType
                },
                navArgument("large_desc"){
                    type = NavType.StringType
                },
                navArgument("duration"){
                    type = NavType.StringType
                },
                navArgument("level"){
                    type = NavType.StringType
                },
                navArgument("link"){
                    type = NavType.StringType
                }
            )
        ){ backStackEntry ->
            val videoId = backStackEntry.arguments?.getString("videoId")!!
            val title = backStackEntry.arguments?.getString("title")!!
            val desc = backStackEntry.arguments?.getString("large_desc")!!
            val duration = backStackEntry.arguments?.getString("duration")!!
            val level = backStackEntry.arguments?.getString("level")!!
            val link = backStackEntry.arguments?.getString("link")!!
            YogaItemScreen(
                navController,
                videoId,
                title,
                desc,
                duration,
                level,
                link
            )
            Log.d("YogaItemScreen", "BottomNavGraph: YogaItemScreen Called")
        }

    }
}