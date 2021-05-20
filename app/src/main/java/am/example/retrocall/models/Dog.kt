package am.example.retrocall.models


import com.google.gson.annotations.SerializedName

data class Dog(

    @field:SerializedName("id")
    val id: Int?,
    @field:SerializedName("status")
    val status: Int?,
    @field:SerializedName("pictureUrl")
    val pictureUrl: String?,
    @field:SerializedName("cordinats")
    val cordinats: Cordinats?,
)