package com.edcast.data.repository.datasource

import com.edcast.data.api.StarWarsService
import com.edcast.data.data.characters.CharactersResponse
import retrofit2.Response
//implementation for remote data source
class RemoteDatasource(private var starWarsService: StarWarsService):IRemoteDatasource {
    override suspend fun getCharacterList(page: Int): Response<CharactersResponse> = starWarsService.getCharacterList(page)
}