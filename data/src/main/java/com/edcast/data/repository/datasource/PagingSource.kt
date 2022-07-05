package com.edcast.data.repository.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.edcast.data.api.StarWarsService
import com.edcast.domain.data.characters.Character
import retrofit2.HttpException
import java.io.IOException

private const val SWAPI_STARTING_PAGE_INDEX = 1
const val NETWORK_PAGE_SIZE = 10

class MoviesPagingSource(private val service: StarWarsService) : PagingSource<Int, Character>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        val pageIndex = params.key ?: SWAPI_STARTING_PAGE_INDEX
        return try {
            val response = service.getCharacterList(
                page = pageIndex
            )
            response.body()?.let {
                val nextKey =
                    it.results.let {data->
                        if (data.isEmpty()) {
                            null
                        } else {
                            pageIndex + (params.loadSize / NETWORK_PAGE_SIZE)
                        }
                    }
                LoadResult.Page(
                    data = it.results,
                    prevKey = if (pageIndex == SWAPI_STARTING_PAGE_INDEX) null else pageIndex,
                    nextKey = nextKey
                )
            }?:LoadResult.Error(IllegalArgumentException("Unknown Error"))

        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    /**
     * The refresh key is used for subsequent calls to PagingSource.Load after the initial load.
     */
    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        // We need to get the previous key (or next key if previous is null) of the page
        // that was closest to the most recently accessed index.
        // Anchor position is the most recently accessed index.
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}