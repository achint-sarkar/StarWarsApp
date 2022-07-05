package com.edcast.domain.data.characters


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

//characters
data class Character(
    @SerializedName("birth_year")
    val birthYear: String?,
    @SerializedName("created")
    val created: String?,
    @SerializedName("edited")
    val edited: String?,
    @SerializedName("eye_color")
    val eyeColor: String?,
    @SerializedName("films")
    val films: ArrayList<String>?,
    @SerializedName("gender")
    val gender: String?,
    @SerializedName("hair_color")
    val hairColor: String?,
    @SerializedName("height")
    val height: String?,
    @SerializedName("homeworld")
    val homeworld: String?,
    @SerializedName("mass")
    val mass: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("skin_color")
    val skinColor: String?,
    @SerializedName("species")
    val species: ArrayList<String>?,
    @SerializedName("starships")
    val starships: ArrayList<String>?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("vehicles")
    val vehicles: ArrayList<String>?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.createStringArrayList(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.createStringArrayList(),
        parcel.createStringArrayList(),
        parcel.readString(),
        parcel.createStringArrayList()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(birthYear)
        parcel.writeString(created)
        parcel.writeString(edited)
        parcel.writeString(eyeColor)
        parcel.writeStringList(films)
        parcel.writeString(gender)
        parcel.writeString(hairColor)
        parcel.writeString(height)
        parcel.writeString(homeworld)
        parcel.writeString(mass)
        parcel.writeString(name)
        parcel.writeString(skinColor)
        parcel.writeStringList(species)
        parcel.writeStringList(starships)
        parcel.writeString(url)
        parcel.writeStringList(vehicles)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Character> {
        override fun createFromParcel(parcel: Parcel): Character {
            return Character(parcel)
        }

        override fun newArray(size: Int): Array<Character?> {
            return arrayOfNulls(size)
        }
    }
}