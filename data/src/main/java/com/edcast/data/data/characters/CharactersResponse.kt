package com.edcast.data.data.characters


import com.google.gson.annotations.SerializedName
//Response of the character list
data class CharactersResponse(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String?,
    @SerializedName("previous")
    val previous: String?,
    @SerializedName("results")
    val results: List<Character>
)