package com.example.disneycharacaters.data.repository

import com.example.disneycharacaters.data.model.disney_package.DataModel
import com.example.disneycharacaters.data.model.disney_package.DisneyItemModel

interface Repository {

    suspend fun getCharacters() : DisneyItemModel

    suspend fun getVideoGame() : DisneyItemModel
}