package com.edcast.data.repository

import androidx.paging.PagingData
import com.edcast.data.repository.datasource.IRemoteDatasource
import com.edcast.domain.data.characters.Character
import com.edcast.domain.repository.ICharacterRepository
import kotlinx.coroutines.flow.Flow

class CharacterRepository(private var remoteDatasource: IRemoteDatasource) : ICharacterRepository {

    //fetch character from remote datasource and wrapping them inside a wrapper class
    override fun getCharacters(): Flow<PagingData<Character>> {

        return remoteDatasource.getCharacterList()
    }
}