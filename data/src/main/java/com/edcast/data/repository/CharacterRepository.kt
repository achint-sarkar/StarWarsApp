package com.edcast.data.repository

import com.edcast.data.data.characters.CharactersResponse
import com.edcast.data.repository.datasource.IRemoteDatasource
import com.edcast.data.wrapper.ResultWrapper
import com.edcast.data.wrapper.responseToResource
import com.edcast.domain.repository.ICharacterRepository

class CharacterRepository(private var remoteDatasource: IRemoteDatasource) : ICharacterRepository {

    //fetch character from remote datasource and wrapping them inside a wrapper class
    override suspend fun getCharacters(page: Int): ResultWrapper<CharactersResponse> {

        return remoteDatasource.getCharacterList(page).responseToResource()
    }
}