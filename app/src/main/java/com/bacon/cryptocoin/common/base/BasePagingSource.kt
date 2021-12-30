package com.bacon.cryptocoin.common.base

//import androidx.paging.PagingSource
//import androidx.paging.PagingState
//import com.bacon.cryptocoin.data.remote.dtos.CoinsResponseDto
//import com.bumptech.glide.load.HttpException
//import java.io.IOException
//
//abstract class BasePagingSource<ValueDto : Any, Value : Any>(
//    private val service: suspend (nextPageToken: String) -> CoinsResponseDto<ValueDto>,
//    private val mappedData: (data: List<ValueDto>) -> List<Value>
//) : PagingSource<String, Value>() {
//
//    override suspend fun load(params: LoadParams<String>): LoadResult<String, Value> {
//        return try {
//            val nextPageToken = params.key ?: ""
//            val response = service(nextPageToken)
//            LoadResult.Page(
//                data = mappedData(response.data),
//                prevKey = null,
//                nextKey = response.timestamp
//            )
//        } catch (http: HttpException) {
//            LoadResult.Error(http)
//        } catch (e: IOException) {
//            LoadResult.Error(e)
//        } catch (exception: Exception) {
//            LoadResult.Error(exception)
//        }
//    }
//
//    override fun getRefreshKey(state: PagingState<String, Value>): String? {
//        return state.anchorPosition?.let { anchorPosition ->
//            val anchorPage = state.closestPageToPosition(anchorPosition)
//            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey
//        }
//    }
//}
