package com.example.disneycharacaters.data.repository

import com.example.disneycharacaters.data.api.APIDetail
import com.example.disneycharacaters.data.model.disney.DataModel
import com.example.disneycharacaters.data.model.disney.DisneyCharactersModel
import retrofit2.http.GET

interface Repoistory {
    suspend fun getCharacterList(): DisneyCharactersModel
    suspend fun getVideoGames(): DisneyCharactersModel
}