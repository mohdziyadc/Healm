package com.example.healm.network.retrofit

import com.example.healm.Utils.Constants.API_KEY
import com.example.healm.Utils.Constants.BRAIN_ID
import com.example.healm.network.models.Message
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ChatAPI {

    @GET("/get")
    suspend fun getMessage(
        @Query("bid")
        bid:String = BRAIN_ID,
        @Query("key")
        apiKey:String = API_KEY,
        @Query("uid")
        uid:String = "[uid]",
        @Query("msg")
        msg:String

    ):Response<Message>

}