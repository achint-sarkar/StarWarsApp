package com.edcast.domain.repository

import com.edcast.domain.characters.CharactersResponse
import com.edcast.data.wrapper.ResultWrapper
/*
    Repository Wrapper for Character Repository
*/
interface ICharacterRepository {
    //get Characters using the repository
    suspend fun getCharacters(page:Int): ResultWrapper<CharactersResponse>
}