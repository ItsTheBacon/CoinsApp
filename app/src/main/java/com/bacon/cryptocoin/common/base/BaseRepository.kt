package com.bacon.cryptocoin.common.base

import com.bacon.cryptocoin.common.resources.Resource
import kotlinx.coroutines.flow.flow

abstract class BaseRepository {

    protected fun <T> doRequest(request: suspend () -> T) = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(data = request()))
        } catch (e: Exception) {
            emit(
                Resource.Error(
                    data = null, message = e.localizedMessage ?: "Error Occurred"
                )
            )
        }
    }

//    protected fun <ValueDto : Any, Value : Any> doPagingRequest(
//        pagingSource: BasePagingSource<ValueDto, Value>,
//        pageSize: Int = 10,
//        prefetchDistance: Int = pageSize,
//        enabledPlaceholder: Boolean = true,
//        initialLoadSize: Int = pageSize * 3,
//        maxSize: Int = Int.MAX_VALUE,
//        jumpThreshold: Int = Int.MIN_VALUE,
//    ): Flow<PagingData<Value>> {
//        return Pager(
//            config = PagingConfig(
//                pageSize,
//                prefetchDistance,
//                enabledPlaceholder,
//                initialLoadSize,
//                maxSize,
//                jumpThreshold
//            ),
//            pagingSourceFactory = { pagingSource }
//        ).flow
//    }
}