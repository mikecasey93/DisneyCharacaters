package com.example.disneycharacaters.data.api

import com.example.disneycharacaters.data.model.disney_package.DataModel
import com.example.disneycharacaters.data.model.disney_package.DisneyItemModel
import retrofit2.http.GET

interface ApiEndpoints {
    @GET(ApiDetails.ENDPOINT)
    suspend fun getCharacters(): DisneyItemModel

    @GET(ApiDetails.ENDPOINT)
    suspend fun getVideoGames(): DisneyItemModel
}