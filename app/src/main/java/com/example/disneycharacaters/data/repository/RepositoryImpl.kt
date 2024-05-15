package com.example.disneycharacaters.data.repository

import android.telecom.Call.Details
import com.example.disneycharacaters.data.api.ApiDetails
import com.example.disneycharacaters.data.api.ApiEndpoints
import com.example.disneycharacaters.data.model.disney_package.DataModel
import com.example.disneycharacaters.data.model.disney_package.DisneyItemModel
import javax.inject.Inject

class RepositoryImpl @Inject constructor (
    private val apiDetails: ApiEndpoints
) : Repository {

    override suspend fun getCharacters(): DisneyItemModel = apiDetails.getCharacters()
    override suspend fun getVideoGame(): DisneyItemModel = apiDetails.getVideoGames()


}