package com.edcast.domain.characters


import com.edcast.domain.characters.Character
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