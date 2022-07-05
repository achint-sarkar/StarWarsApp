package com.edcast.data.api

import com.edcast.domain.data.characters.CharactersResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
//star wars service to get characters
interface StarWarsService {
    //Get Request to get character list page wise
    @GET("people")
    suspend fun getCharacterList(@Query("page") page:Int): Response<CharactersResponse>
}