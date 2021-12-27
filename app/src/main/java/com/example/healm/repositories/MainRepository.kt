package com.example.healm.repositories

import com.example.healm.network.models.Message
import com.example.healm.network.retrofit.RetrofitInstance
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.flow


class MainRepository {

     suspend fun getMessage(msg:String) = RetrofitInstance.api.getMessage(msg = msg)

}