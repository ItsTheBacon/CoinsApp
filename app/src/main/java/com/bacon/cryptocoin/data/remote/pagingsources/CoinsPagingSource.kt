package com.bacon.cryptocoin.data.remote.pagingsources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bacon.cryptocoin.data.remote.apiservices.CoinsApiService
import com.bacon.cryptocoin.data.remote.dtos.CoinsDto
import retrofit2.HttpException
import java.io.IOException

class CoinsPagingSource (private val service: CoinsApiService) :
    PagingSource<Int, CoinsDto>() {

    override fun getRefreshKey(state: PagingState<Int, CoinsDto>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CoinsDto> {
        return try {
            val nextPageNumber = params.loadSize
            val response = service.fetchCoins(params.key,nextPageNumber)
            LoadResult.Page(
                data = response.data,
                prevKey = null,
                nextKey = nextPageNumber
            )
        } catch (http: HttpException) {
            LoadResult.Error(http)
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }

}
