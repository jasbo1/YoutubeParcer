package com.youtubeparcer.model

import com.google.gson.annotations.SerializedName

data class Playlist (
    @SerializedName("kind") var kind: String? = null,
    @SerializedName("items") var item: String? = null
)