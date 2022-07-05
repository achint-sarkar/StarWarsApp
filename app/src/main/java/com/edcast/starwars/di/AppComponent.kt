package com.edcast.starwars.di

import com.edcast.data.di.DataSourceModule
import com.edcast.data.di.NetModule
import com.edcast.data.di.RepositoryModule
import com.edcast.domain.di.UseCaseModule
import com.edcast.starwars.di.subcomponent.character.CharacterListSubcomponent
import dagger.Component

import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetModule::class,
        DataSourceModule::class,
        RepositoryModule::class,
        UseCaseModule::class
    ]
)
interface AppComponent {
    fun getCharacterListSubcomponent(): CharacterListSubcomponent.Factory

}