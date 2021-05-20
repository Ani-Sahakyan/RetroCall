package am.example.retrocall.models


import com.google.gson.annotations.SerializedName

data class Cordinats(
    @SerializedName("latitude")
    val latitude: Double?,
    @SerializedName("longitude")
    val longitude: Double?
)