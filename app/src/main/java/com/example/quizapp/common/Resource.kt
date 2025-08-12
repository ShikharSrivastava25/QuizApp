package com.example.quizapp.common

import androidx.compose.ui.res.ResourceResolutionException


// sealed class because we know only 3 objects will be formed
//1. load data 2. error in loading data 3. data received
sealed class Resource<T> (
    message : String ? = null,
    data : T ? = null
) {

    class Loading<T> : Resource<T>()
    class Success<T>(val data : T?) : Resource<T>(data = data)
    class Error<T>(val message : String?) : Resource<T>(message = message)


}