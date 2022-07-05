package com.edcast.starwars.di.subcomponent.character

import com.edcast.domain.usecase.GetCharactersUseCase
import com.edcast.starwars.ui.character.CharacterViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class CharacterViewModelFactoryModule {
    @Provides
    @CharacterListScope
    fun provideDashboardViewModelFactory(getCharactersUseCase: GetCharactersUseCase): CharacterViewModelFactory {
        return CharacterViewModelFactory(getCharactersUseCase)
    }
}