package com.example.disneycharacaters.di

import com.example.disneycharacaters.data.api.ApiDetails
import com.example.disneycharacaters.data.api.ApiEndpoints
import com.example.disneycharacaters.data.repository.Repository
import com.example.disneycharacaters.data.repository.RepositoryImpl
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
    fun provideGson(): Gson {
        return Gson()
    }

    @Provides
    fun provideLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Provides
    fun provideConverter(
        gson: Gson
    ) = GsonConverterFactory.create()

    @Provides
    fun provideHttpClient(
        logging: HttpLoggingInterceptor
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        converterFactory: GsonConverterFactory
    ): Retrofit = Retrofit.Builder()
        .baseUrl(ApiDetails.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(converterFactory)
        .build()

    @Provides
    fun apiInstance(retrofit: Retrofit): ApiEndpoints = retrofit.create(ApiEndpoints::class.java)

    @Provides
    fun provideRepository(apiEndpoints: ApiEndpoints): Repository {
        return RepositoryImpl(apiEndpoints)
    }

}