package com.edcast.data.repository.datasource

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.edcast.data.api.StarWarsService
import com.edcast.domain.data.characters.Character
import com.edcast.domain.data.characters.CharactersResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import retrofit2.Response
//implementation for remote data source
class RemoteDatasource(private var starWarsService: StarWarsService):IRemoteDatasource {
    override  fun getCharacterList(): Flow<PagingData<Character>> {
       return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                MoviesPagingSource(service = starWarsService)
            }
        ).flow
    }
}