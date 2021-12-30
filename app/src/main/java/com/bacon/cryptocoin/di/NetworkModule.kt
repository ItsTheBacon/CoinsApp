package com.bacon.cryptocoin.di

import com.bacon.cryptocoin.common.constants.Constants
import com.bacon.cryptocoin.data.remote.apiservices.CoinDetailApiService
import com.bacon.cryptocoin.data.remote.apiservices.CoinsApiService
import com.bacon.cryptocoin.data.remote.interceptors.ApiKeyInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {
    @Singleton
    @Provides
    fun createOkHttpClient() =
        OkHttpClient()
            .newBuilder()
            .addInterceptor(
                HttpLoggingInterceptor().setLevel(
                    HttpLoggingInterceptor.Level.BODY
                )
            )
            .addInterceptor(ApiKeyInterceptor())
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

    @Singleton
    @Provides
    fun createRetrofitClient(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideCoinsApiService(retrofit: Retrofit): CoinsApiService =
        retrofit.create(CoinsApiService::class.java)

    @Provides
    @Singleton
    fun provideCoinDetailApiService(retrofit: Retrofit) :CoinDetailApiService =
        retrofit.create(CoinDetailApiService::class.java)

}