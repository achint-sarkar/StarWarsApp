package com.edcast.starwars.di

import com.edcast.starwars.di.subcomponent.character.CharacterListSubcomponent

interface Injector {
    fun getCharacterListSubcomponent(): CharacterListSubcomponent
}