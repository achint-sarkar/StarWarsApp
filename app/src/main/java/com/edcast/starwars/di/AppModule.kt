package com.edcast.starwars.di

import android.content.Context
import com.edcast.starwars.di.subcomponent.character.CharacterListSubcomponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(
    subcomponents = [
        CharacterListSubcomponent::class
    ]
)
class AppModule(private var context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext(): Context {
        return context.applicationContext
    }
}