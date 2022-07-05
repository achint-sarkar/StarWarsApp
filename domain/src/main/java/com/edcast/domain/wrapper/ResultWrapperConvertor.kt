package com.edcast.data.wrapper

import retrofit2.Response
//convert the response into result wrapper object

fun <T> Response<T>.responseToResource(): ResultWrapper<T> {
    if (this.isSuccessful) {
        this.body()?.let {
            return ResultWrapper.Success(it)
        }
    }
    return ResultWrapper.Error(this.message())
}
