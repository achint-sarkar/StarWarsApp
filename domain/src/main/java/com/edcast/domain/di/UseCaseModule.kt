package com.edcast.domain.di

import com.edcast.domain.repository.ICharacterRepository
import com.edcast.domain.usecase.GetCharactersUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
/*
   Provide All Use Cases present in domain layers
*/
@Module
class UseCaseModule {

    //provide use case to get list of users
    @Provides
    fun providesGetCharacterUseCase(characterRepository: ICharacterRepository):GetCharactersUseCase{
        return GetCharactersUseCase(characterRepository)
    }
}