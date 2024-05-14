package com.example.disneycharacaters.data.model.disney


import com.google.gson.annotations.SerializedName

data class InfoModel(
    @SerializedName("count")
    val count: Int? = 0,
    @SerializedName("nextPage")
    val nextPage: String? = "",
    @SerializedName("previousPage")
    val previousPage: String? = String(),
    @SerializedName("totalPages")
    val totalPages: Int? = 0
)