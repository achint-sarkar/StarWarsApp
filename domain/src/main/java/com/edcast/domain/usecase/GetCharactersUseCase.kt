package com.edcast.domain.usecase

import androidx.paging.PagingData
import com.edcast.domain.data.characters.CharactersResponse
import com.edcast.data.wrapper.ResultWrapper
import com.edcast.domain.data.characters.Character
import com.edcast.domain.repository.ICharacterRepository
import kotlinx.coroutines.flow.Flow

/*
    Get Character Use Case using the character Repository
*/
class GetCharactersUseCase(private var characterRepository: ICharacterRepository) {
    // fetch the data from character repository
     fun execute(): Flow<PagingData<Character>> = characterRepository.getCharacters()
}