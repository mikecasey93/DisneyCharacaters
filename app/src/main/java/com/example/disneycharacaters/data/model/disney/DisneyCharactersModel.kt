package com.example.disneycharacaters.data.model.disney


import com.google.gson.annotations.SerializedName

data class DisneyCharactersModel(
    @SerializedName("data")
    val `data`: List<DataModel?>? = listOf(),
    @SerializedName("info")
    val info: InfoModel? = InfoModel()
)