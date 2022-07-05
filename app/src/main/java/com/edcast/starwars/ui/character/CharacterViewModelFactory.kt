package com.edcast.starwars.ui.character

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.edcast.domain.usecase.GetCharactersUseCase

class CharacterViewModelFactory(
    private var getCharactersUseCase: GetCharactersUseCase
   ) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CharacterViewModel::class.java)) {
            return CharacterViewModel(
                getCharactersUseCase
            ) as T
        }
        throw IllegalArgumentException("Unknown View Model")
    }
}