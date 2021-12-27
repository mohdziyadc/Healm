package com.example.healm.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.healm.Utils.Constants.BOTTOM_BAR_ROUTE
import com.example.healm.Utils.Constants.ROOT_ROUTE
import com.example.healm.viewmodels.ChatViewModel

@Composable
fun MainNavGraph(navController: NavHostController, viewModel: ChatViewModel) {

    NavHost(
        navController = navController,
        startDestination = BOTTOM_BAR_ROUTE,
        route = ROOT_ROUTE
    ) {
        BottomNavGraph(viewModel, navController = navController)

    }

}