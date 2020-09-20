package com.data.data_cloud.response

import com.google.gson.annotations.SerializedName

data class PreviewResponse(
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("image") val image: String
)