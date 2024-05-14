package com.example.disneycharacaters.di

import com.example.disneycharacaters.data.api.APIDetail
import com.example.disneycharacaters.data.api.APIEndpoints
import com.example.disneycharacaters.data.repository.Repoistory
import com.example.disneycharacaters.data.repository.RepositoryImplementaion
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
class MainModule {

    @Provides
    fun gson(): Gson{
        return  Gson()
    }
    @Provides
    fun loggingInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    @Provides
    fun covertor(gson: Gson) = GsonConverterFactory.create()


    @Provides
    fun provideOkHttpClient(
        logging: HttpLoggingInterceptor
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()


    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        converterFactory: GsonConverterFactory
    ): Retrofit = Retrofit.Builder()
        .baseUrl(APIDetail.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(converterFactory)
        .build()

    @Provides
    fun apiInstance(retrofit: Retrofit): APIEndpoints = retrofit.create(APIEndpoints::class.java)

    @Provides
    fun providesRepository(apiEndpoints: APIEndpoints): Repoistory {
        return RepositoryImplementaion(apiEndpoints)
    }
}