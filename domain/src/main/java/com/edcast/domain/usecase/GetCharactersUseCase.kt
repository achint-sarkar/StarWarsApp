package com.edcast.domain.usecase

import com.edcast.domain.characters.CharactersResponse
import com.edcast.data.wrapper.ResultWrapper
import com.edcast.domain.repository.ICharacterRepository

/*
    Get Character Use Case using the character Repository
*/
class GetCharactersUseCase(private var characterRepository: ICharacterRepository) {
    // fetch the data from character repository
    suspend fun execute(page:Int): ResultWrapper<CharactersResponse> = characterRepository.getCharacters(page)
}