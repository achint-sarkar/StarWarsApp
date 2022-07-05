package com.edcast.domain.repository

import androidx.paging.PagingData
import com.edcast.domain.data.characters.CharactersResponse
import com.edcast.data.wrapper.ResultWrapper
import com.edcast.domain.data.characters.Character
import kotlinx.coroutines.flow.Flow

/*
    Repository Wrapper for Character Repository
*/
interface ICharacterRepository {
    //get Characters using the repository
     fun getCharacters(): Flow<PagingData<Character>>
}