package com.example.disneycharacaters.data.api

import com.example.disneycharacaters.data.model.disney.DataModel
import com.example.disneycharacaters.data.model.disney.DisneyCharactersModel
import retrofit2.http.GET

interface APIEndpoints {
    @GET(APIDetail.CHARACTER_ENDPOINT)
    suspend fun getCharacterList(): DisneyCharactersModel
    @GET(APIDetail.CHARACTER_ENDPOINT)
    suspend fun getVideoGames(): DisneyCharactersModel
}