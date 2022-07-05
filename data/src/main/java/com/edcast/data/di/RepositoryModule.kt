package com.edcast.data.di

import com.edcast.data.repository.CharacterRepository
import com.edcast.data.repository.datasource.IRemoteDatasource
import com.edcast.domain.repository.ICharacterRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
/*
 provide all the repositories present in the application
*/
@Module
class RepositoryModule {

    //provide character repository
    @Singleton
    @Provides
    fun providesCharacterRepository(remoteDatasource: IRemoteDatasource): ICharacterRepository {
        return CharacterRepository(remoteDatasource)
    }



}