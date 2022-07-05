package com.edcast.data.wrapper

//wrapping up the result into result wrapper to manage result states
sealed class ResultWrapper<T>(
    val data: T? = null,
    val message: String? = null,
    val isLoading: Boolean = false
) {
    class Success<T>(data: T) : ResultWrapper<T>(data)
    class Loading<T>(isLoading:Boolean=false,data: T? = null) : ResultWrapper<T>(data,null,isLoading)
    class Error<T>(message: String?, data: T? = null) : ResultWrapper<T>(data, message)
}

