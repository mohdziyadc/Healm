package com.example.healm.viewmodels


import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.healm.Utils.Constants.BOT_KEY
import com.example.healm.network.models.*
import com.example.healm.repositories.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.net.SocketTimeoutException
import javax.inject.Inject


class ChatViewModel:ViewModel() {

    private val repository: MainRepository = MainRepository()
    val msgList = mutableStateListOf<Message>()  //spent hours to get this data structure mahn!!!!
    val isRequested = mutableStateOf(false)

    private val TAG = "ChatViewModel"


    fun getMessage(msg:String){

        Log.d(TAG, "getMessage: $msgList")

        viewModelScope.launch {

            val response = try{
                repository.getMessage(msg = msg)
            } catch (e: HttpException){
                Log.d("ChatVM", "Http Exception")
                return@launch
            } catch (e: SocketTimeoutException){
                Log.d("ChatVM", "getMessage: ${e.message}")
                return@launch
            }

            if (response.isSuccessful) {

                isRequested.value = true
                Log.d("ChatVM", "Response is successful -- $response")

                response.body()?.let {
                    msgList.add(Message(it.cnt, BOT_KEY))
                    Log.d(TAG, "getMessage: $msgList")
                    Log.d("ChatVM", "Message -- ${Message(it.cnt, BOT_KEY)} --isRequested $isRequested")
                    Log.d("ChatVM", "MessagesList in VM = $msgList")
                }
            }
        }
    }

}