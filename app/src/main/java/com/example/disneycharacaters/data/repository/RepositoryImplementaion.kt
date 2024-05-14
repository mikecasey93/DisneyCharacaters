package com.example.disneycharacaters.data.repository

import android.provider.ContactsContract.Data
import com.example.disneycharacaters.data.api.APIDetail
import com.example.disneycharacaters.data.api.APIEndpoints
import com.example.disneycharacaters.data.model.disney.DataModel
import com.example.disneycharacaters.data.model.disney.DisneyCharactersModel

import javax.inject.Inject

class RepositoryImplementaion @Inject constructor(
    private val apiDetail: APIEndpoints) :Repoistory {
    override suspend fun getCharacterList(): DisneyCharactersModel {
        return apiDetail.getCharacterList()
    }

}
