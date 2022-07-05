package com.edcast.data.repository.datasource

import androidx.paging.PagingData
import com.edcast.domain.data.characters.Character
import com.edcast.domain.data.characters.CharactersResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
//wrapping up the remote data source
interface IRemoteDatasource {
     fun getCharacterList(): Flow<PagingData<Character>>
}