package com.edcast.starwars.di.subcomponent.character

import com.edcast.starwars.ui.character.CharacterFragment
import dagger.Subcomponent

@CharacterListScope
@Subcomponent(modules = [CharacterViewModelFactoryModule::class])
interface CharacterListSubcomponent {

    fun inject(characterFragment: CharacterFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): CharacterListSubcomponent
    }
}