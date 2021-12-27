package com.example.healm.ui.screens

import com.example.healm.R

sealed class MainScreen(val route:String, val title:String?, val icon:Int?, var icon2:Int? = null){

    object Yoga:MainScreen(route = "yoga", title = "Yoga", icon = R.drawable.ic_outline_self_improvement_24)
    object Meditation:MainScreen(route = "meditation",title = "Meditate" ,icon = R.drawable.ic_outline_spa_24, icon2 = R.drawable.ic_baseline_spa_24)
    object ChatBot:MainScreen(route = "chat_bot", title = "Allie", icon = R.drawable.outline_smart_toy_24 )
    object YogaItem:MainScreen(route = "yoga_item", title = null, icon = null )
}
