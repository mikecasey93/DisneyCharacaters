package com.example.disneycharacaters.data.model.disney_package


import com.google.gson.annotations.SerializedName

data class DisneyItemModel(
    @SerializedName("data")
    val data: List<DataModel?>? = listOf(),
    @SerializedName("info")
    val info: InfoModel? = InfoModel()
)