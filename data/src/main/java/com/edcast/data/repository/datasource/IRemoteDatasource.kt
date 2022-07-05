package com.edcast.data.repository.datasource

import com.edcast.data.data.characters.CharactersResponse
import retrofit2.Response
//wrapping up the remote data source
interface IRemoteDatasource {
    suspend fun getCharacterList(page:Int): Response<CharactersResponse>
}