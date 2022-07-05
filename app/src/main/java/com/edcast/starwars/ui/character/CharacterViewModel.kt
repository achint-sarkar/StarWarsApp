package com.edcast.starwars.ui.character

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.edcast.domain.data.characters.Character
import com.edcast.domain.usecase.GetCharactersUseCase
import kotlinx.coroutines.flow.Flow

class CharacterViewModel(
    private var getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {


    @SuppressLint("CheckResult")
    fun fetchCharacterList(): Flow<PagingData<Character>> {
        return getCharactersUseCase.execute().cachedIn(viewModelScope)
    }
}