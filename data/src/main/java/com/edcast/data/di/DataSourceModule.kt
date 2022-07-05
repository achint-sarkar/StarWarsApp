package com.edcast.data.di

import com.edcast.data.api.StarWarsService
import com.edcast.data.repository.datasource.IRemoteDatasource
import com.edcast.data.repository.datasource.RemoteDatasource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
/*
Module to provide all the datasource require to build an application
*/
@Module
class DataSourceModule {

    //provide datasource for remote request
    @Singleton
    @Provides
    fun providesRemoteDataSource(starWarsService: StarWarsService): IRemoteDatasource {
        return RemoteDatasource(starWarsService)
    }


}